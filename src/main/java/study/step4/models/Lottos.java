package study.step4.models;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void printAll() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public String toString() {
        return lottos.toString();
    }

    public Winners findWinners(WinningLotto winLotto, BonusBall bonusBall) {
        Winners winners = new Winners();
        for (Lotto lotto : lottos) {
            int numberOfMatching = lotto.countNumberOfMatching(winLotto);
            winners.add(Rank.valueOf(numberOfMatching, lotto.hasBonusBall(bonusBall)));
        }
        return winners;
    }
}
