package study.lotto.domain;

import java.util.Map;

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

    public Map<LottoStatus, Long> getPrintDataWithCountsByLottoStatus() {
        return amountByLottoStatus.countsByLottoStatus();
    }

    public String getPrintDataWithProfitRate() {
        return profitRate.toString();
    }
}
