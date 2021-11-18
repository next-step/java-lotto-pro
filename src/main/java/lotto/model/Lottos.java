package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final int totalCount;
    private final int manualCount;
    private final int autoCount;
    private final List<LottoTicket> lottos;

    public Lottos(int totalCount, int manualCount, List<List<Integer>> numbers) {
        this.totalCount = totalCount;
        this.manualCount = manualCount;
        this.autoCount = totalCount - manualCount;
        validateCounts();
        lottos = new ArrayList<>();
        generateManual(numbers);
        generateAuto();
    }

    public Lottos(int totalCount, int manualCount) {
        this.totalCount = totalCount;
        this.manualCount = manualCount;
        this.autoCount = totalCount - manualCount;
        validateCounts();
        lottos = new ArrayList<>();
        generateAuto();
    }

    private void validateCounts() {
        if (totalCount >= manualCount
                && totalCount > 0
                && manualCount >= 0) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private void generateManual(List<List<Integer>> numberInputs) {
        for (List<Integer> numbers : numberInputs) {
            Collections.sort(numbers);
            final LottoTicket lotto = LottoTicket.of(numbers);
            lottos.add(lotto);
        }
    }

    private void generateAuto() {
        for (int i = 0; i < autoCount; i++) {
            lottos.add(LottoTicket.ofRandomNumbers());
        }
    }

    public static Lottos ofAllAuto(int count) {
        return new Lottos(count, 0);
    }

    public List<LottoTicket> getLottos() {
        return lottos;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount() {
        return autoCount;
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

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }

    public boolean hasEqualTickets(List<LottoTicket> tickets) {
        return this.lottos.equals(tickets);
    }
}
