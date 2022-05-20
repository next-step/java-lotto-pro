package lotto.dto;

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

        public ResultRequest(String[] winningNumbers) {
            this.winningNumbers = winningNumbers;
        }

        public String[] getWinningNumbers() {
            return winningNumbers;
        }
    }
}
