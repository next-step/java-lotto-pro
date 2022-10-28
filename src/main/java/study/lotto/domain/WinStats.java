package study.lotto.domain;

public class WinStats {

    private final ProfitRate profitRate;
    private final AmountByLottoStatus amountByLottoStatus;

    public WinStats(int quantity) {
        this.profitRate = new ProfitRate(quantity);
        this.amountByLottoStatus = new AmountByLottoStatus();
    }

    public void accumulate(LottoStatus status) {
        amountByLottoStatus.accumulate(status);
    }

    public void calculate() {
        profitRate.calculate(amountByLottoStatus.sumTotalAmount());
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("\n당첨 통계");
        sb.append("\n---------");
        sb.append("\n3개 일치 (5000원) - " + amountByLottoStatus.countByLottoStatus(LottoStatus.FOURTH_PLACE));
        sb.append("\n4개 일치 (50000원) - " + amountByLottoStatus.countByLottoStatus(LottoStatus.THIRD_PLACE));
        sb.append("\n5개 일치 (1500000원) - " + amountByLottoStatus.countByLottoStatus(LottoStatus.SECOND_PLACE));
        sb.append("\n6개 일치 (2000000000원) - " + amountByLottoStatus.countByLottoStatus(LottoStatus.FIRST_PLACE));
        sb.append("\n총 수익률은 " + profitRate.toString() + "입니다.");
        return sb.toString();
    }
}
