package lotto.model;

import lotto.LottoConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.LottoConstants.MAX_VALUE;
import static lotto.LottoConstants.MIN_VALUE;
import static lotto.LottoConstants.LOTTO_SIZE;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateAuto(int count) {
        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            final List<Integer> numbers = Lottos.getRandomNumbers();
            final Lotto lotto = Lotto.generate(numbers);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public LottoResult calculateWinning(WinTicket winTicket) {
        final List<Winning> winnings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            winnings.add(lotto.calculateWinning(winTicket));
        }
        return new LottoResult(winnings);
    }

    public Money getSellingPrice() {
        return LottoConstants.SELLING_PRICE.multiplyBy(lottos.size());
    }

    private static List<Integer> getRandomNumbers() {
        final List<Integer> allNumbers = getAllNumbers();
        Collections.shuffle(allNumbers);
        final List<Integer> pickedNumbers = new ArrayList<>(allNumbers.subList(0, LOTTO_SIZE));
        Collections.sort(pickedNumbers);
        return pickedNumbers;
    }

    private static List<Integer> getAllNumbers() {
        final List<Integer> numbers = new ArrayList<>();
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
