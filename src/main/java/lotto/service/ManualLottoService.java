package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class ManualLottoService {
    public static List<Lotto> createManualLotties(int manualLottoCount, List<String> inputManualLottoNumbersString) {
        List<Lotto> manualLotties = new LinkedList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            manualLotties.add(new Lotto(new LottoNumbers(StringUtils.separate(inputManualLottoNumbersString.get(i)))));
        }
        return manualLotties;
    }
}
