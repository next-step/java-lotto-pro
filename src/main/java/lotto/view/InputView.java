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

    private final MessageUtil message;
    private final BufferedReader br;

    public InputView() {
        message = new MessageUtil();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public long inputPurchasePrice() throws IOException {
        message.printMessage(INPUT_PURCHASE_PRICE_MESSAGE);
        return Long.parseLong(br.readLine());
    }

    public List<Integer> inputWinningLottoNumbers() throws IOException {
        message.printMessage(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
        message.printMessage();
        return Arrays.stream(br.readLine().split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }
}
