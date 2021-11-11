package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class ManualLottoService {
    private static final int MANUAL_LOTTO_COUNT_MINIMUM = 0;

    public static List<Lotto> createManualLotties(int manualLottoCount, List<String> inputManualLottoNumbersString) {
        validateManualLottoCount(manualLottoCount);
        validateManualLottoNumbersStringSize(manualLottoCount, inputManualLottoNumbersString.size());
        List<Lotto> manualLotties = new LinkedList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            manualLotties.add(new Lotto(new LottoNumbers(StringUtils.separate(inputManualLottoNumbersString.get(i)))));
        }
        return manualLotties;
    }

    private static void validateManualLottoNumbersStringSize(int manualLottoCount, int manualLottoNumbersStringSize) {
        if (manualLottoCount != manualLottoNumbersStringSize) {
            throw new IllegalArgumentException("수동 로또 개수와 입력받은 수동 로또 번호들의 개수는 같아야 합니다.");
        }
    }

    private static void validateManualLottoCount(int manualLottoCount) {
        if (manualLottoCount < MANUAL_LOTTO_COUNT_MINIMUM) {
            throw new IllegalArgumentException("수동 로또 개수는 0 이상이어야 합니다.");
        }
    }
}
