package lotto.view;

public class View {
    private static final String MSG_LOTTO_COUNT = "%d개를 구매했습니다.";
    public int insertMoney() {
        OutputView.print("구입금액을 입력해 주세요.");
        return InputView.nextInt();
    }

    public void printLottoCount(int count) {
        OutputView.print(String.format(MSG_LOTTO_COUNT, count));
    }
}
