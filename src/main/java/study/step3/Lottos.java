package study.step3;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final int PRICE_PER_LOTTO = 1000;

    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> makeLottos(int inputMoney) {
        int num = count(inputMoney);
        for (int i = 0; i < num; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private int count(int inputMoney) {
        return inputMoney / PRICE_PER_LOTTO;
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
}
