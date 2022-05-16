package lotto.view;

import lotto.util.MessageUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final static String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private final static String INPUT_NON_AUTO_PURCHASE_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String INPUT_NON_AUTO_LOTTOS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    private final MessageUtil message;
    private final BufferedReader br;

    public InputView() {
        message = new MessageUtil();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public long inputPurchasePrice() throws IOException {
        message.printlnMessage(INPUT_PURCHASE_PRICE_MESSAGE);
        return Long.parseLong(br.readLine());
    }

    public List<Integer> inputWinningLottoNumbers() throws IOException {
        message.printlnMessage(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
        return Arrays.stream(br.readLine().split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int inputBonusBall() throws IOException {
        message.printlnMessage(INPUT_BONUS_BALL_MESSAGE);
        return Integer.parseInt(br.readLine());
    }

    public int inputManualLottoPurchaseCount() throws IOException {
        message.printlnMessage();
        message.printlnMessage(INPUT_NON_AUTO_PURCHASE_COUNT_MESSAGE);
        return Integer.parseInt(br.readLine());
    }

    public void inputManualLottosTitle() {
        message.printlnMessage();
        message.printlnMessage(INPUT_NON_AUTO_LOTTOS_MESSAGE);
    }

    public List<Integer> inputManualLottoNumbers() throws IOException {
        return Arrays.stream(br.readLine().split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }
}
