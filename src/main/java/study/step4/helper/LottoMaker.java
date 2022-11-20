package study.step4.helper;

import study.step4.models.IntegratedLottos;
import study.step4.models.Lotto;
import study.step4.models.LottoNumber;
import study.step4.models.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    private static final int SUB_LIST_START_INDEX = 0;
    private static final int SUB_LIST_END_INDEX = 6;

    public static IntegratedLottos makeLottos(int number, List<String> manualLottosString) {
        Lottos manualLottos = makeManualLottoList(manualLottosString);
        List<Lotto> lottoList = new ArrayList<>();
        int autoLottoCount = number - manualLottos.size();
        for (int i = 0; i < autoLottoCount; i++) {
            lottoList.add(makeLotto(manualLottos));
        }
        return new IntegratedLottos(manualLottos, new Lottos(lottoList));
    }

    private static Lottos makeManualLottoList(List<String> manualLottosString) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (String manualLottoString : manualLottosString) {
            manualLottos.add(new Lotto(manualLottoString));
        }
        return new Lottos(manualLottos);
    }

    private static Lotto makeLotto(Lottos manualLottos) {
        List<LottoNumber> numbers = new ArrayList<>(LottoNumber.getLottoNumbers());
        Lotto lotto;
        boolean isDuplicate;
        do {
            Collections.shuffle(numbers);
            lotto = new Lotto(new ArrayList<>(numbers.subList(SUB_LIST_START_INDEX, SUB_LIST_END_INDEX)));
            isDuplicate = manualLottos.contains(lotto);
        } while (isDuplicate);
        return lotto;
    }
}
