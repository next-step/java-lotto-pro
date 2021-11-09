package lotto.common;

public class Messages {

    private Messages() {
        throw new UnsupportedOperationException();
    }

    public static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_AMOUNT_LESS_THAN_LOTTO_PRICE = "구매금액이 로또 가격보다 작습니다.";
    public static final String LAST_WEEK_WINNING_NUMBER_INPUT = "지난 주 당첨 번호를 입력해 주세요.";

    public static String getPurchasedLottoCount(int count) {
        return String.format("%d개를 구매했습니다.", count);
    }
}
