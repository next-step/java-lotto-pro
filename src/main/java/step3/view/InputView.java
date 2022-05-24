package step3.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanIn = new Scanner(System.in);
    private static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GET_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_LOTTO = "보너스 볼을 입력해 주세요.";
    private static final String GET_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String GET_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final int TICKET_EXIST_BOUNDARY = 1;
    private static final String BEFORE_REPLACE = " ";
    private static final String AFTER_REPLACE = "";
    public String getMoney() {
        System.out.println(InputView.GET_MONEY_MESSAGE);
        return customTrim(InputView.scanIn.nextLine());
    }

    public String getWinnerLotto() {
        System.out.println(InputView.GET_LOTTO_MESSAGE);
        return customTrim(InputView.scanIn.nextLine());
    }

    public String getManualTicketCount() {
        System.out.println(InputView.GET_MANUAL_LOTTO_COUNT);
        return customTrim(InputView.scanIn.nextLine());
    }

    public List<String> getManualLotto(int manualTicketCount) {
        List<String> manualLottoTicketsSource = new ArrayList<>();
        if (manualTicketCount >= InputView.TICKET_EXIST_BOUNDARY) {
            System.out.println(InputView.GET_MANUAL_LOTTO_MESSAGE);
        }
        for (int i = 0; i < manualTicketCount; i++) {
            manualLottoTicketsSource.add(customTrim(InputView.scanIn.nextLine()));
        }
        return manualLottoTicketsSource;
    }

    public String getBonusLotto() {
        System.out.println(InputView.GET_BONUS_LOTTO);
        return customTrim(InputView.scanIn.nextLine());
    }

    private String customTrim(String source) {
        return source.replace(InputView.BEFORE_REPLACE, InputView.AFTER_REPLACE);
    }
}
