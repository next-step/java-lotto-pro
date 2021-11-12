package lotto.factory;

import lotto.model.*;
import lotto.util.Console;
import lotto.view.ErrorMessage;
import lotto.view.InputHandler;

import java.util.*;

public class LottoCreateFactory {

    public static Lottos createTotalLottos(LottosCount lottosCount, List<String> manualLottoTexts) {
        Lottos manualLottos = createManualLotto(manualLottoTexts);
        Lottos autoLottos = createAutoLottos(lottosCount.auto());
        return mergeLottos(manualLottos, autoLottos);
    }

    private static Lottos createManualLotto(List<String> manualLottoTexts) {
        List<Lotto> lottoGroup = new ArrayList<>();
        for (String manualLottoText : manualLottoTexts) {
            lottoGroup.add(new Lotto(InputHandler.splitTextToInts(manualLottoText)));
        }
        return new Lottos(lottoGroup);
    }

    private static Lottos createAutoLottos(int size) {
        List<Lotto> lottoGroup = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoGroup.add(createRandomLotto());
        }
        return new Lottos(lottoGroup);
    }

    private static Lotto createRandomLotto() {
        List<Integer> randomNumbers = createRandomNumbers();
        return new Lotto(randomNumbers);
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> numbers = makeNumbers();
        Collections.shuffle(numbers);
        List<Integer> result = numbers.subList(0, Lotto.SIZE);
        Collections.sort(result);
        return result;
    }

    private static List<Integer> makeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static Lottos mergeLottos(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> totalLottoGroup = new ArrayList<>();
        Collections.addAll(totalLottoGroup,manualLottos.getLottoGroup().toArray(new Lotto[0]));
        Collections.addAll(totalLottoGroup,autoLottos.getLottoGroup().toArray(new Lotto[0]));
        return new Lottos(totalLottoGroup);
    }

    public static WinningLotto createWinningLotto(List<Integer> winLottoNumbers, int bonusNumber) {
        return new WinningLotto(new Lotto(winLottoNumbers), new LottoNumber(bonusNumber));
    }


}
