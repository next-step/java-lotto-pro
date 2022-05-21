package lotto.interfaces.dto;

public class LottoRequest {

    public static class PurchaseRequest {
        private final String payAmount;

        public PurchaseRequest(String payAmount) {
            this.payAmount = payAmount;
        }

        public String getPayAmount() {
            return payAmount;
        }
    }

    public static class ResultRequest {
        private final String[] winningNumbers;
        private final String bonusBall;

        public ResultRequest(String[] winningNumbers, String bonusBall) {
            this.winningNumbers = winningNumbers;
            this.bonusBall = bonusBall;
        }

        public String[] getWinningNumbers() {
            return winningNumbers;
        }

        public String getBonusBall() {
            return bonusBall;
        }
    }
}
