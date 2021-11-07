package lotto.ui;

/**
 * packageName : lotto.ui
 * fileName : Message
 * author : haedoang
 * date : 2021/11/07
 * description :
 */
public enum Message {
    PURCHASE("구입금액을 입력해 주세요."),
    NUMBER("지난 주 당첨 번호를 입력해 주세요."),
    BONUS("보너스 볼을 입력해 주세요.");


    private String msg;

    private Message(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return this.msg;
    }

}
