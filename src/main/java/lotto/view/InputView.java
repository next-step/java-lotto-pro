package lotto.view;

import lotto.dto.LottoRequest;
import lotto.infrastructure.util.StringUtils;

import java.util.Scanner;

public class InputView {

    private static final String WINNING_NUMBER_SPLIT_REGEX = ",";
    private static final String INPUT_PAY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public LottoRequest.PurchaseRequest inputPayAmount() {
        System.out.println(INPUT_PAY_AMOUNT_MESSAGE);
        String payAmount = scanner.nextLine();
        return new LottoRequest.PurchaseRequest(payAmount);
    }

    public LottoRequest.ResultRequest inputWinningNumbers() {
        System.out.println(INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE);
        String[] winningNumbers = StringUtils.splitAndTrim(scanner.nextLine(), WINNING_NUMBER_SPLIT_REGEX);
        return new LottoRequest.ResultRequest(winningNumbers);
    }
}
