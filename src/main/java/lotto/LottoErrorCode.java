package lotto;

import view.Printable;

public enum LottoErrorCode implements Printable {
    INVALID_MONEY("0 이상의 숫자를 입력해주세요.");

    private final String message;

    LottoErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String makePrintableMessage() {
        return message;
    }
}
