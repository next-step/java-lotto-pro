package lotto.factory;

import lotto.model.*;

import java.util.*;

public class LottoCreateFactory {
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            numbers.add(i);
        }
    }

    public static Lottos createTotalLottos(LottosCount lottosCount, List<Lotto> manualLotto) {
        List<Lotto> totalLottoGroup = new ArrayList<>();
        Collections.addAll(totalLottoGroup, manualLotto.toArray(new Lotto[0]));
        Collections.addAll(totalLottoGroup, createAutoLottos(lottosCount.auto()).toArray(new Lotto[0]));
        return new Lottos(totalLottoGroup);
    }

    private static List<Lotto> createAutoLottos(int size) {
        List<Lotto> lottoGroup = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoGroup.add(createRandomLotto());
        }
        return lottoGroup;
    }

    private static Lotto createRandomLotto() {
        List<Integer> randomNumbers = createRandomNumbers();
        return new Lotto(randomNumbers);
    }

    private static List<Integer> createRandomNumbers() {
        Collections.shuffle(numbers);
        List<Integer> result = numbers.subList(0, Lotto.SIZE);
        Collections.sort(result);
        return result;
    }

    public static WinningLotto createWinningLotto(List<Integer> winLottoNumbers, int bonusNumber) {
        return new WinningLotto(new Lotto(winLottoNumbers), LottoNumber.of(bonusNumber));
    }
}
