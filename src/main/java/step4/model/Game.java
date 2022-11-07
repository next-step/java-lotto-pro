package step4.model;

import step4.model.generator.LottoGenerator;

public class Game {
    private Lottos totalLottos = new Lottos();

    public void startLottoGame(LottoGenerator lottoGenerator) {
        Lottos result = lottoGenerator.createLottos();
        totalLottos = totalLottos.plus(result);
    }

    public Lottos getTotalLottos() {
        return totalLottos;
    }

}
