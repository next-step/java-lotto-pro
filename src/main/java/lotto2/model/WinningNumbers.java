package lotto2.model;

import lotto2.common.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private static final String LOTTO_NUMBERS_STRING_DELIMITER_REGEX = ",";
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(String input) {
        if (StringUtils.isNullOrEmpty(input)) {
            throw new IllegalArgumentException("올바르지 않은 값을 당첨 번호로 입력했습니다.");
        }
        final String trimmedInput = input.trim();
        if (isCommaPrefixOrPostfix(trimmedInput)) {
            throw new IllegalArgumentException("쉽표가 맨 앞 또는 맨 뒤에 올 수 없습니다.");
        }
        final String[] tokens = splitBLottoDelimiter(trimmedInput);
        if (numberMissingInWinningNumbersInput(tokens)) {
            throw new IllegalArgumentException("당첨 번호는 반드시 6 개를 입력해야 합니다.");
        }
        winningNumbers = toLottoNumbers(tokens);
    }

    private boolean isCommaPrefixOrPostfix(String input) {
        return input.charAt(0) == ',' || input.charAt(input.length() - 1) == ',';
    }

    private String[] splitBLottoDelimiter(String input) {
        return input.split(LOTTO_NUMBERS_STRING_DELIMITER_REGEX);
    }

    private boolean numberMissingInWinningNumbersInput(String[] tokens) {
        return tokens.length != LottoGenerator.COUNT_OF_NUMBER_IN_LOTTO;
    }

    private List<LottoNumber> toLottoNumbers(String[] tokens) {
        final List<LottoNumber> lottoNumbersData = new ArrayList<>(tokens.length);
        for (String token : tokens) {
            final LottoNumber lottoNumber = new LottoNumber(token);
            lottoNumbersData.add(lottoNumber);
        }
        return lottoNumbersData;
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
