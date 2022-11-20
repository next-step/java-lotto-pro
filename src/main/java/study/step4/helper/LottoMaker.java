package study.step4.helper;

import study.step4.models.Lotto;
import study.step4.models.LottoNumber;
import study.step4.models.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    private static final int SUB_LIST_START_INDEX = 0;
    private static final int SUB_LIST_END_INDEX = 6;

    public static Lottos makeLottos(int number, List<String> manualLottosString) {
        List<Lotto> manualLottosList = makeManualLottoList(manualLottosString);
        List<Lotto> autoLottoList = new ArrayList<>();
        int autoLottoCount = number - manualLottosList.size();
        for (int i = 0; i < autoLottoCount; i++) {
            autoLottoList.add(makeLotto());
        }
        return new Lottos(manualLottosList, autoLottoList);
    }

    private static List<Lotto> makeManualLottoList(List<String> manualLottosString) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (String manualLottoString : manualLottosString) {
            manualLottos.add(new Lotto(manualLottoString));
        }
        return manualLottos;
    }

    private static Lotto makeLotto() {
        List<LottoNumber> numbers = new ArrayList<>(LottoNumber.getLottoNumbers());
        Collections.shuffle(numbers);
        return new Lotto(new ArrayList<>(numbers.subList(SUB_LIST_START_INDEX, SUB_LIST_END_INDEX)));
    }
}
