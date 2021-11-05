package lotto.domain;

public class LottoCalculator {

    public static final int LOTTO_PRICE = 1_000;
    public static final int PROFIT_RATE = 1;

    private final Lottos lottos;
    private WinResults winResults;

    public LottoCalculator(PurchaseAmount purchaseAmount) {
        this.lottos = Lottos.fromQuantity(purchaseAmount.getQuantity());
    }

    public void calculate(Lotto winNumber) {
        this.winResults = lottos.getWinResults(winNumber);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public Prints getLottosPrints() {
        Prints prints = new Prints();
        prints.append(String.format("%d개를 구매했습니다.", getLottosSize()));
        prints.append(lottos.getLottosPrints());
        return prints;
    }

    public Prints getStatsPrints() {
        Prints prints = new Prints();
        appendWinResults(prints);
        appendProceeds(prints);
        return prints;
    }

    private void appendWinResults(Prints prints) {
        for (WinResult winResult : WinResult.values()) {
            prints.append(String.format("%d개 일치 (%d원) - %d개",
                    winResult.getCount(), winResult.getPrize(), winResults.getCount(winResult.getCount())));
        }
    }

    private void appendProceeds(Prints prints) {
        float proceedsRate = (float) winResults.getProceeds() / ((float) getLottosSize() * LOTTO_PRICE);
        String comment = getComment(proceedsRate);
        prints.append(String.format("총 수익률은 %.2f입니다.%s", proceedsRate, comment));
    }

    private String getComment(float proceedsRate) {
        String comment = "";
        if (proceedsRate < PROFIT_RATE) {
            comment = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        return comment;
    }
}
