package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Number.MAX_NUMBER;
import static lotto.domain.Number.MIN_NUMBER;

public class LottoGenerator {

    private static final int MIN_SUBLIST_INDEX = 0;
    private static final int MAX_SUBLIST_INDEX = LottoTicket.LOTTO_NUMBER_COUNT;
    private static final int MINUS_PURCHASE_COUNT = 1;
    private static final List<Number> numbers = new ArrayList<>();

    public LottoGenerator() {
        if (numbers.isEmpty()) {
            initNumbers();
        }
    }

    public List<LottoTicket> createAutoLottoTickets(PurchaseCount purchaseCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        while (purchaseCount.isGreaterThanZero()) {
            Collections.shuffle(numbers);
            List<Number> selectedNumbers = new ArrayList<>(numbers.subList(MIN_SUBLIST_INDEX, MAX_SUBLIST_INDEX));
            Collections.sort(selectedNumbers);
            lottoTickets.add(new LottoTicket(selectedNumbers));
            purchaseCount = purchaseCount.minus(MINUS_PURCHASE_COUNT);
        }
        return lottoTickets;
    }

    public List<LottoTicket> createManualLottoTickets(List<List<Integer>> manualNumbers) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (List<Integer> numbers : manualNumbers) {
            Collections.sort(numbers);
            lottoTickets.add(LottoTicket.of(numbers));
        }
        return lottoTickets;
    }

    private void initNumbers() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(Number.of(i));
        }
    }
}
