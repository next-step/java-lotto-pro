package study.step3.view;

import study.step3.domain.lotto.Lottos;
import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.message.LottoMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoView {

    private static final String REGEX_ONLY_NUMBER_AND_COMMA = "^\\d{1,2}(,\\d})*(\\.\\d+)?";
    private static final Pattern PATTERN_NUMBER_AND_COMMA = Pattern.compile(REGEX_ONLY_NUMBER_AND_COMMA);

    public static void printLottos(Lottos lottos) {
        StringBuilder printer = new StringBuilder();
        printer.append(String.format(LottoMessage.OUTPUT_COUNTS_OF_LOTTOS_FORMAT.message(), lottos.size()))
                .append(lottos.report());
        ResultView.output(printer);
    }

    public static LottoNumbers getWinningNumbers() {
        LottoNumbers winningNumbers = null;
        while (isNeedToInputWinningNumbers(winningNumbers)) {
            winningNumbers = inputWinningNumbers();
        }
        ResultView.newline();
        return winningNumbers;
    }

    private static boolean isNeedToInputWinningNumbers(LottoNumbers winningNumbers) {
        return winningNumbers == null;
    }

    private static LottoNumbers inputWinningNumbers() {
        try {
            ResultView.output(LottoMessage.INPUT_WINNING_NUMBERS.message());
            String winningNumbers = InputView.input();
            validateWinningNumbers(winningNumbers);
            return mapToWinningNumbers(winningNumbers);
        } catch (Exception e) {
            ResultView.output(e.getMessage());
            return null;
        }
    }

    private static void validateWinningNumbers(String winningNumbers) {
        validateLottoNumberIsNotEmpty(winningNumbers, LottoMessage.ERROR_WINNING_NUMBERS_SHOULD_BE_NOT_EMPTY);
        validateLottoNumberIsNumber(winningNumbers);
    }

    private static void validateLottoNumberIsNotEmpty(String winningNumbers, LottoMessage message) {
        if(winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(message.message());
        }
    }

    private static void validateLottoNumberIsNumber(String winningNumbers) {
        if(!PATTERN_NUMBER_AND_COMMA.matcher(winningNumbers).find()) {
            throw new IllegalArgumentException(LottoMessage.ERROR_WINNING_NUMBERS_SHOULD_BE_NUMBER.message());
        }
    }

    private static LottoNumbers mapToWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToInt(number -> Integer.parseInt(number.trim()))
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumber getBonusNumber(LottoNumbers winningNumbers) {
        LottoNumber bonusNumber = null;
        while (isNeedToInputBonusNumber(bonusNumber)) {
            bonusNumber = inputBonusNumber(winningNumbers);
        }
        return bonusNumber;
    }

    private static boolean isNeedToInputBonusNumber(LottoNumber bonusNumber) {
        return bonusNumber == null;
    }

    private static LottoNumber inputBonusNumber(LottoNumbers winningNumbers) {
        try {
            ResultView.output(LottoMessage.INPUT_BONUS_NUMBER.message());
            String bonusNumber = InputView.input();
            validateBonusNumber(winningNumbers, bonusNumber);
            return new LottoNumber(Integer.parseInt(bonusNumber));
        } catch (Exception e) {
            ResultView.output(e.getMessage());
            return null;
        }
    }

    private static void validateBonusNumber(LottoNumbers winningNumbers, String bonusNumber) {
        validateLottoNumberIsNotEmpty(bonusNumber, LottoMessage.ERROR_BONUS_NUMBER_SHOULD_BE_NOT_EMPTY);
        validateWinningIsContainsBonusNumber(winningNumbers, bonusNumber);
    }

    private static void validateWinningIsContainsBonusNumber(LottoNumbers winningNumbers, String bonusNumber) {
        if(winningNumbers.contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException(LottoMessage.ERROR_BONUS_NUMBER_IS_INCLUDING_WINNING_NUMBERS.message());
        }
    }
}
