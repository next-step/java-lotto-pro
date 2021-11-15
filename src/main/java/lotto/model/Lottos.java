package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final int totalCount;
    private final int manualCount;
    private final int autoCount;
    private final List<LottoTicket> lottos;

    public Lottos(int totalCount, int manualCount) {
        // TODO: 2021/11/15 개수 예외처리
        this.totalCount = totalCount;
        this.manualCount = manualCount;
        this.autoCount = totalCount - manualCount;
        lottos = new ArrayList<>();
    }

    public void generateManual(List<String> numberInputs) {
        for (String numberInput : numberInputs) {
            final List<Integer> numbers = Arrays.stream(numberInput.split(","))
                    .map(input -> input.replaceAll("\\s+",""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            final LottoTicket lotto = LottoTicket.of(numbers);
            lottos.add(lotto);
        }
    }

    public void generateAuto() {
        for (int i = 0; i < autoCount; i++) {
            lottos.add(LottoTicket.ofRandomNumbers());
        }
    }

    public static Lottos generateAllAuto(int count) {
        final Lottos lottos = new Lottos(count, 0);
        lottos.generateAuto();
        return lottos;
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
