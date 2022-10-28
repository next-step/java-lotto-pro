package study.lotto.domain;

import study.splitter.Splitter;
import study.util.NumberUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        this.winningNumbers = inputWinningNumbers(winningNumbers);
    }

    private List<Integer> inputWinningNumbers(String winningNumbers) {
        String[] strings = Splitter.split(winningNumbers);
        if(checkSize(strings)) {
            return convertStringArrToList(strings);
        }
        return Collections.EMPTY_LIST;
    }

    private boolean checkSize(String[] strings) {
        if(strings.length == LOTTO_SIZE) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] The numbers entered are invalid as lotto numbers.");
    }

    private List<Integer> convertStringArrToList(String[] strings) {
        return Arrays.stream(strings)
                .mapToInt((str) -> NumberUtil.convertToPositiveIntNotContainsZero(str.trim()))
                .boxed()
                .collect(Collectors.toList());
    }

    public WinStats drawLots(List<Lotto> lottos, WinStats stats) {
        lottos.forEach((lotto) -> {
            stats.accumulate(lotto.drawLots(winningNumbers));
        });
        stats.calculate();
        return stats;
    }
}
