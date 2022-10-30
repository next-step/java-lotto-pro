package step3.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public long inputPayment() {
        System.out.println("구입금액을 입력해주세요.");
        return Long.parseLong(scanner.nextLine());
    }

    public List<Integer> inputNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        return Arrays.stream(
                input.replace(" ", "")
                .split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
