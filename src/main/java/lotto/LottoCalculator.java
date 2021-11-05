package lotto;

import java.util.List;

public class LottoCalculator {

    public static final int LOTTO_PRICE = 1_000;
    public static final int PROFIT_RATE = 1;

    private final Lottos lottos;
    private WinResults winResults;

    public LottoCalculator(PurchaseAmount purchaseAmount) {
        this.lottos = Lottos.fromQuantity(purchaseAmount.getQuantity());
    }

    public void calculate(List<Integer> winNumbers) {
        this.winResults = lottos.getWinResults(new Lotto(winNumbers));
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public void printLottos() {
        lottos.print();
    }

    public void printStats() {
        printWinResults();
        printProceeds();
    }

    private void printWinResults() {
        for (WinResult winResult : WinResult.values()) {
            System.out.printf("%d개 일치 (%d원) - %d개%n",
                    winResult.getCount(), winResult.getPrize(), winResults.getCount(winResult.getCount()));
        }
    }

    private void printProceeds() {
        float proceedsRate = (float) winResults.getProceeds() / ((float) getLottosSize() * LOTTO_PRICE);
        String comment = getComment(proceedsRate);
        System.out.printf("총 수익률은 %.2f입니다.%s%n", proceedsRate, comment);
    }

    private String getComment(float proceedsRate) {
        String comment = "";
        if (proceedsRate < PROFIT_RATE) {
            comment = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return comment;
    }
}
