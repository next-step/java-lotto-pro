package lotto.domain.purchase;

public class PurchaseAmount {

    private final int autoTicketAmount;
    private final int manualTicketAmount;

    public PurchaseAmount(int totalTicketAmount, int manualTicketAmount) {
        validation(totalTicketAmount, manualTicketAmount);
        this.manualTicketAmount = manualTicketAmount;
        this.autoTicketAmount = totalTicketAmount - manualTicketAmount;
    }

    private void validation(int totalTicketAmount, int manualCount) {
        if (totalTicketAmount < manualCount) {
            throw new IllegalArgumentException("수동 구매 티켓이 전체 티켓 보다 많습니다.");
        }
    }

    public int getAutoTicketAmount() {
        return autoTicketAmount;
    }

    public int getManualTicketAmount() {
        return manualTicketAmount;
    }
}
