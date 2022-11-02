package step3.model.value;

public class OperationMsg {




    private OperationMsg() {
        throw new AssertionError();
    }

    public static final String REQUEST_INPUT_BONUS ="보너스 번호를 입력해 주세요.";

    public static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static final String REQUEST_INPUT_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";

    public static final String REQUEST_MANUAL_TICKET_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";

    public static final String REQUEST_MANUAL_TICKET_NUMBER = "수동으로 구매할 로또 번호를 입력해 주세요.";

}
