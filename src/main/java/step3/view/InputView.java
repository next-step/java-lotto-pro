package step3.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import step3.domain.LottoNumber;

public class InputView {

  private static final Scanner sc = new Scanner(System.in);

  public static List<LottoNumber> getWinningNumbersInput() {
    ResultView.printWinningNumberRequest();
    String winningNumbersInput = sc.nextLine();

    if (winningNumbersInput == null || winningNumbersInput.isEmpty()) {
      return new ArrayList<>();
    }
    return Arrays.stream(
        winningNumbersInput.replaceAll(" ", "").split(","))
        .map((Integer::parseInt))
        .map(LottoNumber::new)
        .collect(Collectors.toList());
  }

  public static int getPurchasePriceInput() {
    ResultView.printPurchasePriceRequest();
    return Integer.parseInt(sc.nextLine());
  }
}
