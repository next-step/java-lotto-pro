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

    public Result checkResult(PickedNumbers winningNumbers, Number bonusNumber) {
        int numberOfFirstPrizes = 0;
        int numberOfSecondPrizes = 0;
        int numberOfThirdPrizes = 0;
        int numberOfFourthPrizes = 0;
        int numberOfFifthPrizes = 0;
        for (int i = 0; i < playslips.size(); i++) {
            numberOfFirstPrizes +=
                contains(playslips.get(i), winningNumbers, Prize.FIRST.getMatchCount());
            numberOfSecondPrizes +=
                containsSecondPrize(playslips.get(i), winningNumbers, bonusNumber);
            numberOfThirdPrizes +=
                contains(playslips.get(i), winningNumbers, Prize.THIRD.getMatchCount());
            numberOfFourthPrizes +=
                contains(playslips.get(i), winningNumbers, Prize.FOURTH.getMatchCount());
            numberOfFifthPrizes +=
                contains(playslips.get(i), winningNumbers, Prize.FIFTH.getMatchCount());
        }
        final int numberOfNoPrizes = size()
            - numberOfFirstPrizes
            - numberOfSecondPrizes
            - numberOfThirdPrizes
            - numberOfFourthPrizes
            - numberOfFifthPrizes;
        return new Result(
            numberOfFirstPrizes,
            numberOfSecondPrizes,
            numberOfThirdPrizes,
            numberOfFourthPrizes,
            numberOfFifthPrizes,
            numberOfNoPrizes
        );
    }

    public List<Playslip> getPlayslips() {
        return Collections.unmodifiableList(playslips);
    }

    public int size() {
        return playslips.size();
    }

    private int contains(Playslip playslip, PickedNumbers winningNumbers, int x) {
        return playslip.contains(winningNumbers, x) ? NUMBER_CONTAINED : NUMBER_NOT_CONTAINED;
    }

    private int containsSecondPrize(
        Playslip playslip,
        PickedNumbers winningNumbers,
        Number bonusNumber
    ) {
        return contains(playslip, winningNumbers, Prize.SECOND.getMatchCount()) == NUMBER_CONTAINED
            && playslip.contains(bonusNumber) ? NUMBER_CONTAINED : NUMBER_NOT_CONTAINED;
    }
}
