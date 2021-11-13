package lotto.domain;

import lotto.service.CreateLottoStrategy;

import java.util.LinkedList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new LinkedList<>();

    public Lottos(ManualLottos manualLottos) {
        lottos.addAll(manualLottos.getManualLottos());
    }

    public void createAutoLottos(CreateLottoStrategy createLottoStrategy, int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(new Lotto(new LottoNumbers(createLottoStrategy.createLottoNumberStrings())));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
