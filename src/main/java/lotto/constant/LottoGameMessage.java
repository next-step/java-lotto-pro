package lotto.constant;

public class LottoGameMessage {

    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private LottoGameMessage() {
        throw new IllegalStateException(ErrorMessage.CONSTANT_CLASS);
    }
}
