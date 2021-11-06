package lotto.view;

import lotto.model.PurchaseAmount;
import lotto.util.Console;

import java.util.regex.Pattern;

import static lotto.constants.ErrorMessage.*;
import static lotto.view.OutputView.*;

public class InputView {
  private static Pattern numberPattern = Pattern.compile("\\d+");

  public static PurchaseAmount inputPurchaseAmount() {
    printInputPurchaseAmountGuideMessage();
    return inputPurchaseAmountAndVerify();
  }

  private static PurchaseAmount inputPurchaseAmountAndVerify() {
    String input = Console.readLine();
    try {
      checkNullOrEmpty(input);
      checkStringIsNumber(input);
      return new PurchaseAmount(parseInt(input));
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputPurchaseAmountAndVerify();
    }
  }

  private static void checkNullOrEmpty(String input) {
    if (input == null || input.isEmpty()) {
      throw new NullPointerException(INPUT_EMPTY_ERROR_MESSAGE);
    }
  }

  private static int parseInt(String input) {
    return Integer.parseInt(input);
  }

  public static void checkStringIsNumber(String string) {
    if (!numberPattern.matcher(string).matches()) {
      throw new NumberFormatException();
    }
  }
}
