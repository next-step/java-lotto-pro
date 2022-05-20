package step3.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanIn = new Scanner(System.in);
    private final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final String GET_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final String GET_BONUS_LOTTO = "보너스 볼을 입력해 주세요.";
    private final String GET_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final String GET_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private final int TICKET_EXIST_BOUNDARY = 1;

    public String getMoney() {
        System.out.println(GET_MONEY_MESSAGE);
        return customTrim(scanIn.nextLine());
    }

    public String getWinnerLotto() {
        System.out.println(GET_LOTTO_MESSAGE);
        return customTrim(scanIn.nextLine());
    }

    public String getManualLottoCount() {
        System.out.println(GET_MANUAL_LOTTO_COUNT);
        return customTrim(scanIn.nextLine());
    }

    public List<String> getManualLotto(int manualTicket) {
        List<String> manualLottoTicketsSource = new ArrayList<>();
        if (manualTicket >= TICKET_EXIST_BOUNDARY) {
            System.out.println(GET_MANUAL_LOTTO_MESSAGE);
        }
        for (int i = 0; i < manualTicket; i++) {
            manualLottoTicketsSource.add(customTrim(scanIn.nextLine()));
        }
        return manualLottoTicketsSource;
    }

    public String getBonusLotto() {
        System.out.println(GET_BONUS_LOTTO);
        return customTrim(scanIn.nextLine());
    }

    private String customTrim(String source) {
        return source.replace(" ", "");
    }
}
