package lotto2.model.generator;

import lotto2.common.StringUtils;
import lotto2.model.Lotto;
import lotto2.model.constant.LottoConstant;
import lotto2.model.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoGeneratorFromWinningNumbers {
    private final String input;

    private static final String LOTTO_NUMBERS_STRING_DELIMITER_REGEX = ",";

    public LottoGeneratorFromWinningNumbers(String input) {
        this.input = input;
    }

    public Lotto generate() {
        final String[] tokens = tokensOfSplitInput();
        if (numberMissingInWinningNumbersInput(tokens)) {
            throw new IllegalArgumentException("당첨 번호는 반드시 6 개를 입력해야 합니다.");
        }
        final List<LottoNumber> winningLottoNumbers = toLottoNumbers(tokens);
        return new Lotto(winningLottoNumbers);
    }

    private String[] tokensOfSplitInput() {
        if (StringUtils.isNullOrEmpty(input)) {
            throw new IllegalArgumentException("올바르지 않은 값을 당첨 번호로 입력했습니다.");
        }
        final String trimmedInput = input.trim();
        if (isCommaPrefixOrPostfix(trimmedInput)) {
            throw new IllegalArgumentException("쉽표가 맨 앞 또는 맨 뒤에 올 수 없습니다.");
        }
        return splitBLottoDelimiter(trimmedInput);
    }

    private boolean isCommaPrefixOrPostfix(String input) {
        return input.charAt(0) == ',' || input.charAt(input.length() - 1) == ',';
    }

    private String[] splitBLottoDelimiter(String input) {
        return input.split(LOTTO_NUMBERS_STRING_DELIMITER_REGEX);
    }

    private boolean numberMissingInWinningNumbersInput(String[] tokens) {
        return tokens.length != LottoConstant.COUNT_OF_NUMBER_IN_LOTTO;
    }

    private List<LottoNumber> toLottoNumbers(String[] tokens) {
        final List<LottoNumber> lottoNumbersData = new ArrayList<>(tokens.length);
        for (String token : tokens) {
            final LottoNumber lottoNumber = new LottoNumber(token);
            lottoNumbersData.add(lottoNumber);
        }
        return lottoNumbersData;
    }
}
