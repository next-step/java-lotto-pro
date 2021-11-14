package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playslips {

    private static final int NUMBER_NOT_CONTAINED = 0;
    private static final int NUMBER_CONTAINED = 1;

    private final List<Playslip> playslips;

    public Playslips(List<Playslip> playslips) {
        this.playslips = new ArrayList<>(playslips);
    }

    public Result checkResult(PickedNumbers winningNumbers) {
        int numberOfFirstPrizes = 0;
        int numberOfSecondPrizes = 0;
        int numberOfThridPrizes = 0;
        int numberOfFourthPrizes = 0;
        for (int i = 0; i < playslips.size(); i++) {
            numberOfFirstPrizes += contains(winningNumbers, Prize.FIRST.getMatchCount(), i);
            numberOfSecondPrizes += contains(winningNumbers, Prize.SECOND.getMatchCount(), i);
            numberOfThridPrizes += contains(winningNumbers, Prize.THIRD.getMatchCount(), i);
            numberOfFourthPrizes += contains(winningNumbers, Prize.FOURTH.getMatchCount(), i);
        }
        final int numberOfNoPrizes = size()
            - numberOfFirstPrizes
            - numberOfSecondPrizes
            - numberOfThridPrizes
            - numberOfFourthPrizes;
        return new Result(
            numberOfFirstPrizes,
            numberOfSecondPrizes,
            numberOfThridPrizes,
            numberOfFourthPrizes,
            numberOfNoPrizes
        );
    }

    public List<Playslip> getPlayslips() {
        return Collections.unmodifiableList(playslips);
    }

    public int size() {
        return playslips.size();
    }

    private int contains(PickedNumbers winningNumbers, int x, int i) {
        final Playslip ithPlayslip = playslips.get(i);
        return ithPlayslip.contains(winningNumbers, x) ? NUMBER_CONTAINED : NUMBER_NOT_CONTAINED;
    }
}
