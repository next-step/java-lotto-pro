package study.step3;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Winners findWinners(Lotto winLotto) {
        Winners winners = new Winners();
        for (Lotto lotto : lottos) {
            int countOfMatch = lotto.countMatchingNumbers(winLotto);
            winners.add(new Winner(countOfMatch));
        }
        return winners;
    }

    public Winners findWinners(String winLottoNumbers) {
        return findWinners(new Lotto(LottoParser.stringToListInteger(winLottoNumbers)));
    }

    public int size() {
        return lottos.size();
    }

    public void printAll() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public boolean hasEqualSize(int expected) {
        return lottos.size() == expected;
    }
}
