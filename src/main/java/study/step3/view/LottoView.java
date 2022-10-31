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

    public static LottoNumbers inputWinningNumbers() {
        String winningNumbers = null;
        while (!validateWinningNumbers(winningNumbers)) {
            ResultView.output(LottoMessage.INPUT_WINNING_NUMBERS.message());
            winningNumbers = InputView.input();
        }
        ResultView.newline();
        return mapToLottoNumbers(winningNumbers);
    }

    private static boolean validateWinningNumbers(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            return false;
        }
        return PATTERN_NUMBER_AND_COMMA.matcher(winningNumbers).find();
    }

    private static LottoNumbers mapToLottoNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToInt(number -> Integer.parseInt(number.trim()))
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }
}
