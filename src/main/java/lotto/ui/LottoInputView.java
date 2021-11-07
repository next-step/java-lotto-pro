package lotto.ui;

import lotto.BuyAmount;
import lotto.LottoNumbers;
import lotto.LottoNumbersGroup;
import lotto.dto.LottoNumberDto;
import lotto.dto.LottoNumbersDto;
import lotto.dto.LottoNumbersGroupDto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoInputView {
    public static final String LOTTO_NUMBERS_DESCRIPTION_OPEN_BRACKET = "[";
    public static final String LOTTO_NUMBERS_DESCRIPTION_CLOSE_BRACKET = "]";
    public static final String LOTTO_NUMBERS_DESCRIPTION_SPACE = " ";

    private final BuyAmount buyAmount;
    private final LottoNumbersGroup lottoNumbersGroup;

    public LottoInputView(BuyAmount buyAmount, LottoNumbersGroup lottoNumbersGroup) {
        this.buyAmount = buyAmount;
        this.lottoNumbersGroup = lottoNumbersGroup;
    }

    public void showBuyStats() {
        LottoMessage.showBuyAmount(buyAmount);
        showMyLottoNumbersGroup();
    }

    public void showMyLottoNumbersGroup() {
        LottoNumbersGroupDto lottoNumbersGroupDto = new LottoNumbersGroupDto(lottoNumbersGroup);
        StringBuilder myLottoNumbers = new StringBuilder();
        List<LottoNumbersDto> lottoNumbersGroup = lottoNumbersGroupDto.getLottoNumbersGroup();
        for (LottoNumbersDto lottoNumbersDto : lottoNumbersGroup) {
            printLottoNumbers(myLottoNumbers, lottoNumbersDto.getSortedLottoNumbers());
        }

        System.out.println(myLottoNumbers);
    }

    private void printLottoNumbers(StringBuilder result, List<LottoNumberDto> lottoNumbers) {
        String resultLottoNumbers = lottoNumbers.stream()
                .map(LottoNumberDto::getNumber)
                .map(String::valueOf)
                .collect(Collectors
                        .joining(LottoNumbers.LOTTO_NUMBERS_BASE_SEPARATOR + LOTTO_NUMBERS_DESCRIPTION_SPACE)
                );

        result.append(LOTTO_NUMBERS_DESCRIPTION_OPEN_BRACKET)
                .append(resultLottoNumbers)
                .append(LOTTO_NUMBERS_DESCRIPTION_CLOSE_BRACKET)
                .append(System.lineSeparator());
    }
}
