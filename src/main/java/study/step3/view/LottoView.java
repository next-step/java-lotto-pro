package study.step3.view;

import study.step3.domain.lotto.Lottos;
import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.message.LottoMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LottoView {

    private static final String REGEX_ONLY_NUMBER_AND_COMMA = "^\\d{1,2}(,\\d})*(\\.\\d+)?";
    private static final Pattern PATTERN_NUMBER_AND_COMMA = Pattern.compile(REGEX_ONLY_NUMBER_AND_COMMA);

    public static void printLottos(long manualLottoCount, Lottos lottos) {
        StringBuilder printer = new StringBuilder();
        printer.append(String.format(LottoMessage.OUTPUT_COUNTS_OF_LOTTOS_FORMAT.message(), manualLottoCount, lottos.size() - manualLottoCount))
                .append(lottos.report());
        ResultView.output(printer);
    }

    public static LottoNumbers getWinningNumbers() {
        LottoNumbers winningNumbers = null;
        while (InputView.isNeedToRetryInputValue(winningNumbers)) {
            ResultView.output(LottoMessage.INPUT_WINNING_NUMBERS.message());
            winningNumbers = inputWinningLottoNumbers();
        }
        ResultView.newline();
        return winningNumbers;
    }

    public static LottoNumbers inputWinningLottoNumbers() {
        try {
            String winningNumbers = InputView.input();
            validateWinningLottoNumbers(winningNumbers);
            return mapToLottoNumbers(winningNumbers);
        } catch (Exception e) {
            ResultView.output(e.getMessage());
            return null;
        }
    }

    private static void validateWinningLottoNumbers(String lottoNumbers) {
        validateLottoNumberIsNotEmpty(lottoNumbers, LottoMessage.ERROR_WINNING_NUMBERS_SHOULD_BE_NOT_EMPTY);
        validateLottoNumberIsNumber(lottoNumbers);
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

    private static LottoNumbers mapToLottoNumbers(String lottoNumbers) {
        String[] numbers = lottoNumbers.trim().split("\\s*,\\s*");
        return LottoNumbers.of(numbers);
    }

    public static LottoNumber getBonusNumber(LottoNumbers winningNumbers) {
        LottoNumber bonusNumber = null;
        while (InputView.isNeedToRetryInputValue(bonusNumber)) {
            bonusNumber = inputBonusNumber(winningNumbers);
        }
        return bonusNumber;
    }

    private static LottoNumber inputBonusNumber(LottoNumbers winningNumbers) {
        try {
            ResultView.output(LottoMessage.INPUT_BONUS_NUMBER.message());
            String bonusNumber = InputView.input();
            validateBonusNumber(winningNumbers, bonusNumber);
            return LottoNumber.of(bonusNumber);
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

    public static List<LottoNumbers> getManualLottoNumbers(long manualLottoCount) {
        List<LottoNumbers> lottoNumbers = null;
        while (InputView.isNeedToRetryInputValue(lottoNumbers)) {
            ResultView.output(LottoMessage.INPUT_MANUAL_LOTTO_NUMBERS.message());
            lottoNumbers = inputManualLottoNumbers(manualLottoCount);
        }

        return lottoNumbers;
    }

    private static List<LottoNumbers> inputManualLottoNumbers(long manualLottoCount) {
        List<LottoNumbers> manualLottoNumbers = new ArrayList<>();
        while(manualLottoNumbers.size() != manualLottoCount) {
            inputManualLottoNumbers(manualLottoNumbers);
        }
        return manualLottoNumbers;
    }

    private static void inputManualLottoNumbers(List<LottoNumbers> lottoNumbers) {
        try {
            String inputLottoNumbers = InputView.input();
            validateManualLottoNumbers(inputLottoNumbers);
            lottoNumbers.add(mapToLottoNumbers(inputLottoNumbers));
        } catch (Exception e) {
            ResultView.output(e.getMessage());
        }
    }

    private static void validateManualLottoNumbers(String lottoNumbers) {
        validateLottoNumberIsNotEmpty(lottoNumbers, LottoMessage.ERROR_LOTTO_NUMBER_SHOULD_BE_NOT_EMPTY);
        validateLottoNumberIsNumber(lottoNumbers);
    }
}
