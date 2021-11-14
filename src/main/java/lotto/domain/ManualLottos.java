package lotto.domain;

import lotto.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class ManualLottos {
    private List<Lotto> manualLottos = new LinkedList<>();

    public void createManualLottos(List<String> inputManualLottoNumbersString) {
        for (int i = 0; i < inputManualLottoNumbersString.size(); i++) {
            manualLottos.add(new Lotto(new LottoNumbers(StringUtils.separate(inputManualLottoNumbersString.get(i)))));
        }
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }
}
