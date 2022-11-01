package step3.ui;

import step3.domain.LotteryTicket;
import step3.domain.Payment;
import step3.domain.Statistics;

public interface ResultView {
    void resultLotteryTicket(LotteryTicket lotteryTicket);
    void resultStatistics(Statistics statistics, Payment payment);
}
