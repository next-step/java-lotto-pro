package lotto.factory;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.LottoNumber;
import lotto.model.WinningLotto;
import lotto.view.ErrorMessage;

import java.util.*;

public class LottoCreateFactory {

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

    public static Lottos createLottos(int size) {
        List<Lotto> lottoGroup = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoGroup.add(createRandomLotto());
        }
        return new Lottos(lottoGroup);
    }

    public static WinningLotto createWinningLotto(List<Integer> winLottoNumbers, int bonusNumber) {
        return new WinningLotto(createLotto(winLottoNumbers), new LottoNumber(bonusNumber));
    }

    private static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
