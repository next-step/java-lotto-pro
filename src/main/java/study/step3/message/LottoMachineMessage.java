package study.step3.message;

public enum LottoMachineMessage {
    INPUT_PURCHASE_MONEY_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    LottoMachineMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
