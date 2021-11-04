package step3.domain;

import java.util.List;

public class LottoWinningReport {
    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 1_500_000;
    private static final int THIRD_PRIZE = 50_000;
    private static final int FOURTH_PRIZE = 5_000;
    private static final int NONE = 0;
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private int totalAmount = 0;
    private int firstCount = 0;
    private int secondCount = 0;
    private int thirdCount = 0;
    private int fourthCount = 0;

    public LottoWinningReport(List<LottoTicket> lottoTicketBundle,
        LottoTicket winningLottoTicket, int totalAmount) {
        this.totalAmount = totalAmount;
        winningVerificationReport(lottoTicketBundle, winningLottoTicket);
    }

    public void winningVerificationReport(List<LottoTicket> lottoTicketBundle,
        LottoTicket winningLottoTicket) {
        for (LottoTicket lottoTicket : lottoTicketBundle) {
            incrementRankCount(lottoTicket.containCounting(winningLottoTicket));
        }
    }

    @Override
    public String toString() {
        double totalWinningAmount = totalAmountCalculate();

        String format = getReportFormat();
        if (totalWinningAmount < 1) {
            format += LOSS_MESSAGE;
        }

        return String.format(
            format,
            fourthCount, thirdCount, secondCount, firstCount,
            parseAmount(totalWinningAmount)
        );
    }

    private String parseAmount(double totalWinningAmount) {
        return String.format("%.2f", totalWinningAmount);
    }

    private double totalAmountCalculate() {
        return (double)(FIRST_PRIZE * firstCount + SECOND_PRIZE * secondCount + THIRD_PRIZE * thirdCount
            + FOURTH_PRIZE * fourthCount) / totalAmount;
    }

    private static String getReportFormat() {
        return "당첨 통계\n"
            + "---------\n"
            + "3개 일치 (5000원)- %s개\n"
            + "4개 일치 (50000원)- %s개\n"
            + "5개 일치 (1500000원)- %s개\n"
            + "6개 일치 (2000000000원)- %s개\n"
            + "총 수익률은 %s 입니다.";
    }

    private void incrementRankCount(int containCount) {
        switch (containCount) {
            case 6:
                firstCount++;
                break;
            case 5:
                secondCount++;
                break;
            case 4:
                thirdCount++;
                break;
            case 3:
                fourthCount++;
                break;
        }
    }

}
