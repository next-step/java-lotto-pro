package lotto.view;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static List<LottoNumber> inputLotto() {
        return Arrays.stream(scanner.next().split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoNumber inputBonusBall() {
        return new LottoNumber(nextInt());
    }
}
