package study.step3.message;

public enum LottoMachineMessage {
    INPUT_PURCHASE_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    ERROR_PURCHASE_MONEY_SHOULD_BE_NUMBER("구입금액은 숫자만 입력이 가능합니다."),
    ERROR_PURCHASE_MONEY_SHOULD_BE_NOT_EMPTY("구입금액은 필수값입니다."),
    ERROR_PURCHASE_MONEY_IS_GREATER_THAN_MINIMUM_MONEY("구입금액의 최소 금액은 1000원입니다."),
    INPUT_MANUAL_LOTTO_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    ERROR_MANUAL_LOTTO_COUNT_SHOULD_BE_NUMBER("로또 수량은 숫자만 입력할 수 있습니다."),
    ERROR_MANUAL_LOTTO_LACK_OF_MONEY("금액이 모자르기떄문에 해당 수량만큼 구입할 수 없습니다.");

    private final String message;

    LottoMachineMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
