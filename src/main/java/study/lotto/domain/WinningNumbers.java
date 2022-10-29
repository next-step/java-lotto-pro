package study.lotto.domain;

import study.splitter.Splitter;
import study.util.NumberUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final int LOTTO_SIZE = 6;
    private static final int MATCH_NUM = 1;
    private static final int NOT_MATCH_NUM = 0;

    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        this.winningNumbers = inputWinningNumbers(winningNumbers);
    }

    private List<Integer> inputWinningNumbers(String winningNumbers) {
        String[] winningNumbersSplited = Splitter.split(winningNumbers);
        checkSize(winningNumbersSplited);
        return convertStringArrToList(winningNumbersSplited);
    }

    private void checkSize(String[] winningNumbersSplited) {
        if(winningNumbersSplited.length == LOTTO_SIZE) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] The numbers entered are invalid as lotto numbers.");
    }

    private List<Integer> convertStringArrToList(String[] winningNumbersSplited) {
        return Arrays.stream(winningNumbersSplited)
                .mapToInt((str) -> NumberUtil.convertToPositiveIntNotContainsZero(str.trim()))
                .boxed()
                .collect(Collectors.toList());
    }

    public WinStats drawLots(List<Lotto> lottos, WinStats stats) {
        lottos.forEach((lotto) -> {
            stats.accumulate(lotto.drawLots(this));
        });
        stats.calculate();
        return stats;
    }

    public int matchNumber(int num) {
        if(winningNumbers.contains(num)) {
            return MATCH_NUM;
        }
        return NOT_MATCH_NUM;
    }
}
