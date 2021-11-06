package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.utils.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final LottoController lottoController = new LottoController();

    public static void start() throws IOException {
        int purchaseCount = inputAmountAndGetPurchaseCount();

        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        createLottoNumbers(purchaseCount, lottoNumbers);

        System.out.println();
        LottoNumbers winningLottoNumbers = createWinningLottoNumbers();

        ResultView.start(lottoNumbers, winningLottoNumbers);
    }

    private static int inputAmountAndGetPurchaseCount() {
        int purchaseCount = 0;
        while (purchaseCount <= 0) {
            int amount = inputAmount();
            purchaseCount = getPurchaseCount(amount);
        }
        return purchaseCount;
    }

    private static int getPurchaseCount(int amount) {
        int purchaseCount = 0;
        try {
            purchaseCount = lottoController.countPurchasableLotto(amount);
            System.out.println(purchaseCount + "개를 구매했습니다.");
            return purchaseCount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return 0;
        }
    }

    private static int inputAmount() {
        int amount = 0;
        while (amount <= 0) {
            amount = inputAndValidateAmount();
        }
        return amount;
    }

    private static int inputAndValidateAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            System.out.println("숫자만 입력 가능합니다.");
            System.out.println();
            return 0;
        }
    }

    private static LottoNumbers createWinningLottoNumbers() {
        LottoNumbers winningLottoNumbers = null;
        while (winningLottoNumbers == null) {
            winningLottoNumbers = inputWinningLottoNumbers();
        }
        return winningLottoNumbers;
    }

    private static LottoNumbers inputWinningLottoNumbers() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            String[] split = input.split(", ");
            List<LottoNumber> winningNumbers = new ArrayList<>();
            splitWinningNumbers(split, winningNumbers);
            return new LottoNumbers(winningNumbers);
        } catch (Exception e) {
            System.out.println("당첨 번호는 숫자만 입력 가능하며, 다음과 같은 형식으로 입력 가능합니다. (ex: 1, 2, 3, 4, 5, 6)");
            System.out.println();
            return null;
        }
    }

    private static void splitWinningNumbers(String[] split, List<LottoNumber> winningNumbers) {
        for (String str : split) {
            int number = Integer.parseInt(str);
            winningNumbers.add(new LottoNumber(number));
        }
    }

    private static void createLottoNumbers(int purchaseCount, List<LottoNumbers> lottoNumbersList) {
        for (int i = 0; i < purchaseCount; i++) {
            LottoNumbers lottoNumbers = lottoController.createLottoNumbers();
            lottoNumbersList.add(lottoNumbers);
            printLottoNumbers(lottoNumbers);
        }
    }

    private static void printLottoNumbers(LottoNumbers lottoNumbers) {
        List<LottoNumber> numbers = lottoNumbers.getLottoNumbers();
        int size = numbers.size();
        int[] lottoNumberArray = new int[size];
        for (int j = 0; j < size; j++) {
            lottoNumberArray[j] = numbers.get(j).getNumber();
        }
        System.out.println(Arrays.toString(lottoNumberArray));
    }
}
