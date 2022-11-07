package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String MESSAGE_FOR_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    private static final String MESSAGE_FOR_INPUT_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_FOR_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String MESSAGE_FOR_INPUT_MANUAL_LOTTO_TICKET_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_FOR_INPUT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private static final String EXCEPTION_MESSAGE_FOR_OVER_PURCHASE_TICKET_COUNT = "구매할 수 있는 로또 수를 넘었습니다.";

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
        Lotto lotto = readLottoNumbersForLotto();
        int bonusNumber = readBonusNumberForWinningLotto();
        return new WinningLotto(lotto, LottoNumber.of(bonusNumber));
    }

    @Override
    public int readManualLottoTicketCount(int allLottoTicketCount) {
        System.out.println(MESSAGE_FOR_INPUT_MANUAL_LOTTO_TICKET_COUNT);
        int manualLottoTicketCount = Integer.parseInt(scanner.nextLine());
        if (manualLottoTicketCount > allLottoTicketCount) {
            throw new IllegalStateException(EXCEPTION_MESSAGE_FOR_OVER_PURCHASE_TICKET_COUNT);
        }
        return manualLottoTicketCount;
    }

    @Override
    public List<Lotto> readManualLottos(int manualLottoTicketCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        if (manualLottoTicketCount > 0) {
            System.out.println(MESSAGE_FOR_INPUT_MANUAL_LOTTO_NUMBER);
        }
        for (int i = 0; i < manualLottoTicketCount; i++) {
            manualLottos.add(readLottoNumbersForLotto());
        }
        return manualLottos;
    }

    private Lotto readLottoNumbersForLotto() {
        String lottoNumbers = scanner.nextLine();
        String[] split = lottoNumbers.split(",");
        return new Lotto(Arrays.stream(split)
                .mapToInt(i -> Integer.parseInt(i.trim()))
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private int readBonusNumberForWinningLotto() {
        System.out.println(MESSAGE_FOR_INPUT_BONUS_NUMBER);
        String bonusNumber = scanner.nextLine();
        return Integer.parseInt(bonusNumber);
    }
}
