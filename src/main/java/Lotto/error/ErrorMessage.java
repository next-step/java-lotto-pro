package Lotto.error;

public enum ErrorMessage {
    PurchaseMoneyMinimum("1000원 이하의 금액으로는 구매하실 수 없습니다."),
    PurchaseMoney1000NotLeft("로또는 1000원 단위로 구매할 수 있습니다."),
    LastPrizeNumberGenerate("로또 번호 입력이 올바르지 않습니다."),
    LastPrizeNumberCount("지난 회차 로또 당첨 번호는 6개여야 합니다."),
    BonusNumberOutOfRange("입력한 보너스 번호가 1~45사이가 아닙니다."),
    BonusNumberDuplicate("입력한 보너스 번호는 이미 뽑힌 번호입니다."),
    BonusNumberInputWrong("보너스 번호는 입력이 올바르지 않습니다.");

    private final String errorMsg;

    ErrorMessage(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return "[ERROR] " + errorMsg;
    }

}
