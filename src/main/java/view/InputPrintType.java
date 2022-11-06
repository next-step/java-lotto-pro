package view;

enum InputPrintType {

    MONEY_INPUT("구매 금액을 입력해주세요."),
    BONUS_NUMBER("보너스 볼을 입력해주세요."),
    MANUAL_NUMBER("수동으로 구매할 로또 수를 입력해 주세요.");


    private final String message;

    InputPrintType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
