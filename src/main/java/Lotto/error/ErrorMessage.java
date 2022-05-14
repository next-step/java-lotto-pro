package Lotto.error;

public enum ErrorMessage {
    PurchaseMoneyMinimum("1000원 이하의 금액으로는 구매하실 수 없습니다.");

    private final String errorMsg;

    ErrorMessage(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return "[ERROR] " + errorMsg;
    }

}
