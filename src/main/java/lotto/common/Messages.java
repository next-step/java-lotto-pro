package lotto.common;

public class Messages {

    private Messages() {
        throw new UnsupportedOperationException();
    }

    public static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    public static final String MANUAL_LOTTO_COUNT_INPUT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String LAST_WEEK_WINNING_NUMBER_INPUT = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String LAST_WEEK_WINNING_BONUS_NUMBER_INPUT = "보너스 볼을 입력해 주세요.";

    public static String getPurchasedLottoCount(int count) {
        return String.format("%d개를 구매했습니다.", count);
    }
}
