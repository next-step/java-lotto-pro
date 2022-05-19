package lotto.view;

import lotto.model.LottoCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return generateLottoNumber(scanner.next());
    }

    public static Integer inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return scanner.nextInt();
    }

    public static Integer inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return scanner.nextInt();
    }

    public static List<List<Integer>> inputManualLottoNumbers(LottoCount count) {

        List<List<Integer>> lottoNumbers = new ArrayList<>();
        if (count.valueOf() == 0) {
            return lottoNumbers;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count.valueOf(); i++) {
            lottoNumbers.add(generateLottoNumber(scanner.nextLine()));
        }

        return lottoNumbers;
    }

    private static List<Integer> generateLottoNumber(String input) {
        return Arrays.stream(input.trim().split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
