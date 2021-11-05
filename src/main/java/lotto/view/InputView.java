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

    public static void start() throws IOException {
        int amount = 0;
        while (amount <= 0) {
            amount = getAmount();
        }

        LottoController lottoController = new LottoController();
        int purchaseCount = lottoController.countPurchasableLotto(amount);
        System.out.println(purchaseCount + "개를 구매했습니다.");

        if (purchaseCount == 0) {
            System.out.println("구매한 로또가 없으므로 종료합니다.");
            return;
        }

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        createLottoNumbersList(lottoController, purchaseCount, lottoNumbersList);

        System.out.println();
        LottoNumbers winningLottoNumbers = createWinningLottoNumbers();

        ResultView.start(lottoNumbersList, winningLottoNumbers);
    }

    private static int getAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());
            return amount;
        } catch (Exception e) {
            System.out.println("0보다 큰 숫자만 입력 가능합니다.");
            System.out.println();
            return 0;
        }
    }

    private static LottoNumbers createWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] split = input.split(", ");
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (String str : split) {
            int number = Integer.parseInt(str);
            winningNumbers.add(new LottoNumber(number));
        }
        return new LottoNumbers(winningNumbers);
    }

    private static void createLottoNumbersList(LottoController lottoController, int purchaseCount, List<LottoNumbers> lottoNumbersList) {
        for (int i = 0; i < purchaseCount; i++) {
            LottoNumbers lottoNumbers = lottoController.createLottoNumbers();
            lottoNumbersList.add(lottoNumbers);
            printLottoNumbers(lottoNumbers);
        }
    }

    private static void printLottoNumbers(LottoNumbers lottoNumbers) {
        List<LottoNumber> lottoNumberList = lottoNumbers.getLottoNumbers();
        int size = lottoNumberList.size();
        int[] lottoNumberArray = new int[size];
        for (int j = 0; j < size; j++) {
            lottoNumberArray[j] = lottoNumberList.get(j).getNumber();
        }
        System.out.println(Arrays.toString(lottoNumberArray));
    }
}
