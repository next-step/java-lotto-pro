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
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());

        LottoController lottoController = new LottoController();
        int purchaseCount = lottoController.countPurchasableLotto(amount);
        System.out.println(purchaseCount + "개를 구매했습니다.");

        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        createLottoNumbersList(lottoController, purchaseCount, lottoNumbersList);

        System.out.println();
        List<LottoNumber> winningNumbers = new ArrayList<>();
        createWinningLottoNumbers(winningNumbers);
    }

    private static void createWinningLottoNumbers(List<LottoNumber> winningNumbers) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] split = input.split(", ");
        for (String str : split) {
            int number = Integer.parseInt(str);
            winningNumbers.add(new LottoNumber(number));
        }
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
