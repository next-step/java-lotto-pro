package lotto.view;

import lotto.util.GameRule;

public class GameMessage {

    private GameMessage() {
    }

    public final static String ERR_MSG = "[ERROR]";
    public static final String BUY_PRICE_INPUT = "구입금액을 입력해 주세요";
    public static final String FORMAT_BUY_COUNT_OUTPUT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";

    public static final String WINNING_NUMBER_INPUT = "지난 주 당첨 번호를 입력해 주세요";
    public static final String ERROR_WINNING_NUMBER_INPUT = "1부터 45까지의 숫자만 입력 가능합니다.";
    public static final String ERROR_BUY_PRICE_INPUT = String.format("로또금액은 최소 %d원 이상이어야 합니다.", GameRule.LOTTO_PAPER_PRICE);
    public static final String ERROR_LOTTO_NUMBER_INPUT = String.format("로또는 %d 개의 숫자로 입력이 필요합니다.", GameRule.LOTTO_END_INDEX);

    public static final String ERROR_LOTTO_NUMBER_DUPLICATION_INPUT = "로또 번호가 중복되었습니다.";

    public static final String BONUS_NUMBER_INPUT = "보너스 볼을 입력해 주세요.";
    public static final String ERROR_BONUS_NUMBER_INPUT = "보너스 볼 번호가 당첨번호에 포함되어 있습니다.";

    public static final String MANUAL_LOTTO_BUY_COUNT_INPUT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_LOTTO_NUMBER_INPUT = "수동으로 구매할 번호를 입력해 주세요.";

    public static final String ERROR_MANUAL_LOTTO_BUY_COUNT_INPUT = "금액이 충분하지 않습니다.";
    public static final String ERROR_NUMBER_INPUT = "0 이상의 양수만 입력이 가능합니다.";

    public static String invalidInputMsg(String msg) {
        return String.format("%s %s", GameMessage.ERR_MSG, msg);
    }
}
