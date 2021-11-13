package lotto.domain;

import lotto.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class ManualLottos {
    private final ManualLottosCount manualLottosCount;
    private List<Lotto> manualLottos = new LinkedList<>();

    public ManualLottos(ManualLottosCount manualLottosCount) {
        this.manualLottosCount = manualLottosCount;
    }

    public void createManualLottos(List<String> inputManualLottoNumbersString) {
        for (int i = 0; i < manualLottosCount.getValue(); i++) {
            manualLottos.add(new Lotto(new LottoNumbers(StringUtils.separate(inputManualLottoNumbersString.get(i)))));
        }
    }

    public List<Lotto> getManualLotts() {
        return manualLottos;
    }
}
