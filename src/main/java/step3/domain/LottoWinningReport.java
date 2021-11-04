package step3.domain;

import step3.domain.constance.LottoConstant;

public class LottoWinningReport {
    private final LottoRanks lottoRanks;
    private final int totalAmount;

    public LottoWinningReport(LottoTicketBundle lottoTicketBundle, LottoTicket winningLottoTicket, int totalAmount) {
        this.lottoRanks = new LottoRanks();
        this.totalAmount = totalAmount;
        winningVerificationReport(lottoTicketBundle, winningLottoTicket);
    }

    public void winningVerificationReport(LottoTicketBundle lottoTicketBundle,
        LottoTicket winningLottoTicket) {
        for (LottoTicket lottoTicket : lottoTicketBundle.getLottoTicketToList()) {
            lottoRanks.matchOfMatchCount(lottoTicket.containCount(winningLottoTicket));
        }
    }

    @Override
    public String toString() {
        return String.format(LottoConstant.REPORT_STATISTICS_FORMAT, lottoRanks.toString(),
            getYieldStatistics());
    }

    private String getYieldStatistics() {
        double totalPrize = lottoRanks.totalPrize(); // 당첨금
        double yield = totalPrize / totalAmount;

        String result = String.format(LottoConstant.YIELD_MESSAGE_FORMAT, yield);
        if (yield < 1) {
            result += LottoConstant.LOTTO_LOSS_MESSAGE;
        }
        return result;
    }

}
