package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<Integer> lottoBalls = new ArrayList<>();

    public LottoCreator() {
        initLottoBall();
    }

    public List<Integer> makeLotto() {
        Collections.shuffle(lottoBalls);
        List<Integer> selectedLottoBalls = new ArrayList<>(lottoBalls.subList(0, 6));
        return sortLottoBalls(selectedLottoBalls);
    }

    private List<Integer> sortLottoBalls(List<Integer> selectedLottoBalls) {
        Collections.sort(selectedLottoBalls);
        return selectedLottoBalls;
    }

    private void initLottoBall() {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoBalls.add(i);
        }
    }

}
