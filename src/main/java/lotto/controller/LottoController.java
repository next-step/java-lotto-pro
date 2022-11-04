package lotto.controller;

import lotto.domain.*;
import lotto.dto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoController {

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
                new BuyAmount(readBuyAmount(lottoResultRequestDto.getBuyAmountUserInput())))
                .getLottoResultDto();
    }


    private int readBuyAmount(String userInput) {
        checkEmpty(userInput);
        checkIntType(userInput);
        return Integer.parseInt(userInput);
    }

    private List<Integer> readWinningNumbers(String userInput) {
        checkEmpty(userInput);
        return splitStringByComma(userInput).stream()
                .map(str -> checkStringNotEmptyTypeIntAndParsing(str))
                .collect(Collectors.toList());
    }

    private int readBonusNumber(String userInput) {
        return checkStringNotEmptyTypeIntAndParsing(userInput);
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

    private boolean isIntType(String str) {
        if(!str.trim().matches("\\d+")) {
            return true;
        }
        return false;
    }

    private void checkIntType (String str) {
        if(isIntType(str)) {
            throw new IllegalArgumentException("자연수 형식이 아닙니다.");
        }
    }

    private int checkStringNotEmptyTypeIntAndParsing(String str) {
        checkEmpty(str);
        checkIntType(str);
        return Integer.parseInt(str);
    }

    private List<String> splitStringByComma(String userInput) {
        return Optional.ofNullable(userInput)
                .map(str -> Arrays.asList(str.split(",")))
                .orElse(new ArrayList<>());
    }

}
