package lotto.constant;

public class LottoInputMessage {

    public static final String MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String SELF_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String SELF_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";


    private LottoInputMessage() {
        throw new IllegalStateException(ErrorMessage.CONSTANT_CLASS);
    }
}
