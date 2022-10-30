package study.step3.domain.lottonumber;

public enum LottoNumberMessage {

    ERROR_SHOULD_BE_GIVEN_SIX_LOTTO_NUMBERS("Unable to create lotto numbers. 6 lotto numbers must be given."),
    ERROR_SHOULD_BE_NOT_DUPLICATED_LOTTO_NUMBER("Unable to create lotto numbers. 6 lotto numbers must not be duplicated.");

    private final String message;

    LottoNumberMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
