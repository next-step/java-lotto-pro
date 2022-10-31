package study.step3.controller;

import study.step3.domain.lotto.Lottos;
import study.step3.domain.lotto.PurchaseMoney;
import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.domain.lottostatistics.LottoStatistics;
import study.step3.message.LottoMessage;
import study.step3.view.InputView;
import study.step3.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoController {

    private static final String REGEX_ONLY_NUMBER_AND_COMMA = "^\\d{1,2}(,\\d})*(\\.\\d+)?";
    private static final Pattern PATTERN_NUMBER_AND_COMMA = Pattern.compile(REGEX_ONLY_NUMBER_AND_COMMA);

    public LottoStatistics match(PurchaseMoney purchaseMoney, Lottos lottos) {
        String winningNumbers = inputWinningNumbers();
        List<Long> matchCounts = lottos.matchAll(mapToLottoNumbers(winningNumbers));
        return new LottoStatistics(purchaseMoney, matchCounts);
    }

    private String inputWinningNumbers() {
        String winningNumbers = null;
        while (!validateWinningNumbers(winningNumbers)) {
            ResultView.output(LottoMessage.INPUT_WINNING_NUMBERS.message());
            winningNumbers = InputView.input();
        }
        ResultView.newline();
        return winningNumbers;
    }

    private boolean validateWinningNumbers(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            return false;
        }
        return PATTERN_NUMBER_AND_COMMA.matcher(winningNumbers).find();
    }

    private LottoNumbers mapToLottoNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToInt(number -> Integer.parseInt(number.trim()))
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }
}
