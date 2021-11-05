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
        prints.append(String.format(Message.LOTTOS_PRINT.getMessage(), getLottosSize()));
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
            prints.append(String.format(Message.WIN_RESULTS_PRINT.getMessage(),
                    winResult.getCount(), winResult.getPrize(), winResults.getCount(winResult.getCount())));
        }
    }

    private void appendProceeds(Prints prints) {
        float proceedsRate = (float) winResults.getProceeds() / ((float) getLottosSize() * LOTTO_PRICE);
        String comment = getComment(proceedsRate);
        prints.append(String.format(Message.PROCEEDS_PRINT.getMessage(), proceedsRate, comment));
    }

    private String getComment(float proceedsRate) {
        String comment = "";
        if (proceedsRate < PROFIT_RATE) {
            comment = Message.PROCEEDS_COMMENT.getMessage();
        }
        return comment;
    }
}
