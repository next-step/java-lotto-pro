package study.lotto.view;

import study.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public String inputAmount() {
        return scanner.nextLine();
    }

    public int inputManualQuantity() {
        return NumberUtil.convertToPositiveInt(scanner.nextLine());
    }

    public String inputManualLotto() {
        return scanner.nextLine();
    }

    public String inputWinningNumbers() {
        return scanner.nextLine();
    }

    public int inputBonusBall() {
        return NumberUtil.convertToPositiveInt(scanner.nextLine());
    }
}
