package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String[] inputWinLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next().split(DELIMITER);
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.next();
    }

    public static int inputManualLottoQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputManualLottoNumbers(int manualQuantity) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualNumbers = new ArrayList<>();
        for (int quantity = 0; quantity < manualQuantity; quantity++) {
            manualNumbers.add(scanner.next());
        }
        return manualNumbers;
    }


}
