package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.model.LottoNumber.MAX_VALUE;
import static lotto.model.LottoNumber.MIN_VALUE;
import static lotto.model.LottoTicket.LOTTO_SIZE;

public class Lottos {
    private final List<LottoTicket> lottos;

    private Lottos(List<LottoTicket> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateAuto(int count) {
        final List<LottoTicket> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            final List<Integer> numbers = Lottos.getRandomNumbers();
            final LottoTicket lotto = LottoTicket.of(numbers);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public List<LottoTicket> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public LottoResult calculateWinning(WinTicket winTicket) {
        final List<Rank> ranks = new ArrayList<>();
        for (LottoTicket lotto : lottos) {
            ranks.add(lotto.calculateWinning(winTicket));
        }
        return new LottoResult(ranks);
    }

    public Money calculateTotalSellingPrice() {
        return LottoTicket.SELLING_PRICE.multiplyBy(lottos.size());
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
