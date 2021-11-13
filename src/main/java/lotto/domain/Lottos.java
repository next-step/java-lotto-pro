package lotto.domain;

import lotto.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class Lottos {
    private static final int MANUAL_LOTTO_COUNT_MINIMUM = 0;
    private final int totalLottoCount;
    private final int manualLottoCount;
    private List<Lotto> manualLottos = new LinkedList<>();

    public Lottos(int totalLottoCount, int manualLottoCount) {
        validateManualLottoCount(totalLottoCount, manualLottoCount);
        this.totalLottoCount = totalLottoCount;
        this.manualLottoCount = manualLottoCount;
    }

    private void validateManualLottoCount(int totalLottoCount, int manualLottoCount) {
        if (totalLottoCount < manualLottoCount) {
            throw new IllegalArgumentException("수동 로또 개수는 총 구매한 로또 개수를 넘으면 안됩니다.");
        }
        if (manualLottoCount < MANUAL_LOTTO_COUNT_MINIMUM) {
            throw new IllegalArgumentException("수동 로또 개수는 0 이상이어야 합니다.");
        }
    }

    public void createManualLottos(List<String> inputManualLottoNumbersString) {
        for (int i = 0; i < manualLottoCount; i++) {
            manualLottos.add(new Lotto(new LottoNumbers(StringUtils.separate(inputManualLottoNumbersString.get(i)))));
        }
    }

    public List<Lotto> getManualLotts() {
        return manualLottos;
    }
}
