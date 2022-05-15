package lotto.model;

import java.util.List;

import static lotto.view.ResultView.printLottoNumbers;

public class Lottos {
    private List<LottoNumbers> lottos;

    private Lottos(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<LottoNumbers> lottos) {
        return new Lottos(lottos);
    }

    public void printLottos() {
        for (LottoNumbers lottoNumbers : lottos) {
            printLottoNumbers(lottoNumbers);
        }
    }
}
