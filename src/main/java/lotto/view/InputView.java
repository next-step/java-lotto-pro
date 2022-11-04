package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {
    public String purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public String prevWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public String bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public List<String> manualLottoNumbers() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoQuantity = new Scanner(System.in).nextInt();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoNumbers = new ArrayList<>();
        IntStream.range(0, manualLottoQuantity)
            .forEach(i -> manualLottoNumbers.add(new Scanner(System.in).nextLine()));
        return manualLottoNumbers;
    }
}
