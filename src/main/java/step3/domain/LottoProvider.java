package step3.domain;

public class LottoProvider {
    private static final int PRICE = 1000;

    private final int purchaseCost;

    public LottoProvider(int purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public LottoTicketVoucher buyLotto() {
        LottoTicketBundle lottoTicketBundle = new LottoTicketBundle();
        for (int i = 0; i < availableQuantity(); i++) {
            lottoTicketBundle.addLottoTicket();
        }
        return lottoTicketBundle.toLottoTicketVoucher();
    }

    public int availableQuantity() {
        return purchaseCost / PRICE;
    }

    public int totalPurchasePrice(int quantity) {
        return quantity * PRICE;
    }

    public String winningVerification(LottoTicketVoucher lottoTicketVoucher,
        LottoTicket winningLottoTicket) {
        LottoWinningReport lottoWinningReport = new LottoWinningReport(lottoTicketVoucher.getLottoTicketBundle(),
            winningLottoTicket,
            totalPurchasePrice(availableQuantity()));
        return lottoWinningReport.toString();
    }
}
