package study.step3.message;

public enum LottoMachineMessage {
    INPUT_PURCHASE_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    ERROR_PURCHASE_MONEY_SHOULD_BE_NUMBER("구입금액은 숫자만 입력이 가능합니다."),
    ERROR_PURCHASE_MONEY_SHOULD_BE_NOT_EMPTY("구입금액은 필수값입니다."),
    ERROR_PURCHASE_MONEY_IS_GREATER_THAN_MINIMUM_MONEY("구입금액의 최소 금액은 1000원입니다.");
    private final String message;

    LottoMachineMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
