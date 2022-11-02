package step3.ui;

import step3.domain.LottoCreateStrategy;
import step3.domain.PurchaseAmount;
import step3.domain.WinningLotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String MESSAGE_FOR_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    private static final String MESSAGE_FOR_INPUT_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private final Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public PurchaseAmount readPurchaseAmount() {
        System.out.println(MESSAGE_FOR_INPUT_PURCHASE_AMOUNT);
        int purchaseAmount = Integer.parseInt(scanner.nextLine());
        return new PurchaseAmount(purchaseAmount);
    }

    @Override
    public WinningLotto readWinningLottoNumbers() {
        System.out.println(MESSAGE_FOR_INPUT_WINNING_LOTTO_NUMBERS);
        String winningLottoNumbers = scanner.nextLine();
        String[] split = winningLottoNumbers.split(",");

        return new WinningLotto(Arrays.stream(split)
                .mapToInt(i -> Integer.parseInt(i.trim()))
                .mapToObj(i -> LottoCreateStrategy.lottoNumberMap.get(i))
                .collect(Collectors.toList()));
    }
}
