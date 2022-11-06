package lotto.controller;

import lotto.domain.*;
import lotto.dto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoController {

    public BuyAmountDto getBuyAmount(String userInput) {
        int buyAmount = readBuyAmount(userInput);
        return new BuyAmountDto(buyAmount, new BuyAmount(buyAmount));
    }

    public BuyCountLottoDto getBuyCountLotto(String userInput, BuyAmountDto buyAmountDto) {
        int directBuyCount = readDirectBuyCount(userInput);
        BuyAmount buyAmount = buyAmountDto.getBuyAmountDomain();
        return new BuyCountLottoDto(directBuyCount, buyAmount, new BuyCountLotto(directBuyCount, buyAmount));
    }

    public LotteriesDto initDirectLotteries(String userInput) {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(readLottoNumbers(userInput));
        return (new Lotteries(lottoList)).getLotteriesDto();
    }

    public LotteriesDto mergeLotteries(LotteriesDto lotteriesDto, String userInput) {
        lotteriesDto.getLotteriesDomain().addLotto(readLottoNumbers(userInput));
        return lotteriesDto;
    }

    public LotteriesDto buyLotto(BuyCountLottoDto buyCountLottoDto, LotteriesDto directLotteriesDto) {
        LotteriesDto lotteriesDto =  buyCountLottoDto.getBuyCountLotto()
                .getLotteries(new AutoLottoCreator(), directLotteriesDto.getLotteriesDomain())
                .getLotteriesDto();
        int directBuyCount = buyCountLottoDto.getDirectBuyCount();
        lotteriesDto.setDirectBuyCount(directBuyCount);
        lotteriesDto.setAutoBuyCount(lotteriesDto.getLotteries().size() - directBuyCount);
        return lotteriesDto;
    }

    public LotteriesDto buyLotto(String userInput) {
        BuyAmount buyAmount = new BuyAmount(readBuyAmount(userInput));
        Lotteries lotteries = buyAmount.getLotteries(new AutoLottoCreator());
        return lotteries.getLotteriesDto();
    }

    public WinningNumbersDto getWinningNumbers(String userInput) {
        return new WinningNumbersDto(new WinningNumbers(readWinningNumbers(userInput)));
    }

    public WinningNumbersDto getBonusNumber(WinningNumbersDto winningNumbersDto, String readUserInput) {
        List<Integer> winningNumbers = winningNumbersDto.getWinningNumbers();
        return new WinningNumbersDto(new WinningNumbers(winningNumbers, BonusNumber.of(readBonusNumber(readUserInput))));
    }

    public LottoResultDto lottoResult(LottoResultRequestDto lottoResultRequestDto) {
        return new LottoResult(lottoResultRequestDto.getLotteriesDto().getLotteriesDomain(),
                lottoResultRequestDto.getWinningNumbers().getWinningNumbersDomain(),
                lottoResultRequestDto.getBuyAmountDto().getBuyAmountDomain())
                .getLottoResultDto();
    }


    private int readBuyAmount(String userInput) {
        checkEmpty(userInput);
        checkPositiveInt(userInput);
        return Integer.parseInt(userInput);
    }

    private int readDirectBuyCount(String userInput) {
        checkEmpty(userInput);
        checkPositiveInt(userInput);
        return Integer.parseInt(userInput);
    }

    private List<Integer> readWinningNumbers(String userInput) {
        checkEmpty(userInput);
        return splitStringByComma(userInput).stream()
                .map(str -> checkStringNotEmptyPositiveIntAndParsing(str))
                .collect(Collectors.toList());
    }

    private int readBonusNumber(String userInput) {
        return checkStringNotEmptyPositiveIntAndParsing(userInput);
    }

    private boolean isEmpty(String str) {
        if(str == null || str.equals("")) {
            return true;
        }
        return false;
    }

    private void checkEmpty(String str) {
        if(isEmpty(str)) {
            throw new IllegalArgumentException("빈값은 입력할 수 없습니다.");
        }
    }

    private boolean isPositiveInt(String str) {
        if(!str.trim().matches("\\d+")) {
            return true;
        }
        return false;
    }

    private void checkPositiveInt (String str) {
        if(isPositiveInt(str)) {
            throw new IllegalArgumentException("자연수 형식이 아닙니다.");
        }
    }

    private int checkStringNotEmptyPositiveIntAndParsing(String str) {
        checkEmpty(str);
        checkPositiveInt(str);
        return Integer.parseInt(str.trim());
    }

    private List<String> splitStringByComma(String userInput) {
        return Optional.ofNullable(userInput)
                .map(str -> Arrays.asList(str.split(",")))
                .orElse(new ArrayList<>());
    }

    private List<Lotto> readDirectLotteries(String userInput) {
        checkEmpty(userInput);
        return Arrays.asList(userInput.split("\n")).stream()
                .map((lottoString) -> readLottoNumbers(lottoString))
                .collect(Collectors.toList());
    }


    private Lotto readLottoNumbers(String userInput) {
        checkEmpty(userInput);
        return new Lotto(splitStringByComma(userInput).stream()
                .map(str -> LottoNumber.of(checkStringNotEmptyPositiveIntAndParsing(str)))
                .collect(Collectors.toList()));
    }

}
