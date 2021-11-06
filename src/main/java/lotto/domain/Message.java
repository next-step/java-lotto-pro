package lotto.domain;

public enum Message {
    NON_POSITIVE_NUMBER_MESSAGE("금액에 음수나 문자열은 사용할 수 없습니다."),
    WRONG_LOTTO_AMOUNT_UNIT("로또 구매는 1000원 단위로 가능합니다."),
    NON_POSITIVE_LOTTO_NUMBER_MESSAGE("로또 번호는 문자열이나 음수가 될 수 없습니다."),
    WRONG_NUMBERS_SIZE_MESSAGE("로또 번호는 6개만 가능합니다."),
    EXIST_DUPLICATE_NUMBER_MESSAGE("중복된 번호가 존재합니다."),
    OUT_OF_RANGE_NUMBER_MESSAGE("로또 숫자는 1~45 사이만 가능합니다."),
    NON_SORTED_NUMBERS_MESSAGE("로또 번호가 정렬되어 있지 않습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
