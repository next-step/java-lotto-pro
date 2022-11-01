package study.step3.message;

public enum LottoNumberMessage {

    ERROR_SHOULD_BE_GIVEN_SIX_LOTTO_NUMBERS("6개의 로또 번호가 있어야 합니다."),
    ERROR_SHOULD_BE_NOT_DUPLICATED_LOTTO_NUMBER("중복되는 로또 번호가 없어야합니다.");

    private final String message;

    LottoNumberMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
