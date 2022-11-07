package lotto.ui;

import lotto.domain.*;

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
    public Lottos readManualLottos(PurchaseAmount purchaseAmount) {
        return readManualLottos(readManualLottoTicketCount(purchaseAmount));
    }

    @Override
    public WinningLotto readWinningLotto() {
        return new WinningLotto(readWinningLottoNumbers(), readBonusNumberForWinningLotto());
    }

    private Lottos readManualLottos(int manualLottoTicketCount) {
        if (manualLottoTicketCount > 0) {
            System.out.println(MESSAGE_FOR_INPUT_MANUAL_LOTTO_NUMBER);
        }

        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoTicketCount; i++) {
            manualLottos.add(readLottoNumbersForLotto());
        }

        return LottoSeller.sellManualLottos(manualLottos);
    }

    private int readManualLottoTicketCount(PurchaseAmount purchaseAmount) {
        System.out.println(MESSAGE_FOR_INPUT_MANUAL_LOTTO_TICKET_COUNT);
        int manualLottoTicketCount = Integer.parseInt(scanner.nextLine());
        if (manualLottoTicketCount > purchaseAmount.getLottoTicketCount()) {
            throw new IllegalStateException(EXCEPTION_MESSAGE_FOR_OVER_PURCHASE_TICKET_COUNT);
        }
        return manualLottoTicketCount;
    }

    private Lotto readLottoNumbersForLotto() {
        String lottoNumbers = scanner.nextLine();
        String[] split = lottoNumbers.split(",");
        return new Lotto(Arrays.stream(split)
                .mapToInt(i -> Integer.parseInt(i.trim()))
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    private Lotto readWinningLottoNumbers() {
        System.out.println(MESSAGE_FOR_INPUT_WINNING_LOTTO_NUMBERS);
        return readLottoNumbersForLotto();
    }

    private LottoNumber readBonusNumberForWinningLotto() {
        System.out.println(MESSAGE_FOR_INPUT_BONUS_NUMBER);
        String bonusNumber = scanner.nextLine();
        return LottoNumber.of(Integer.parseInt(bonusNumber));
    }
}
