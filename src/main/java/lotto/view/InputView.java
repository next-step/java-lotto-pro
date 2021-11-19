package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static lotto.constants.ErrorMessage.*;
import static lotto.view.OutputView.*;

public class InputView {
  private static final String SPLIT_DELIMITER = ",";
  private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
  private static final Scanner SCANNER = new Scanner(System.in);

  public PurchaseAmount inputPurchaseAmount() {
    printInputPurchaseAmountGuideMessage();
    return inputPurchaseAmountAndVerify();
  }

  public LottoNumbers inputWinningLottoNumbers() {
    printInputWinningLottoNumbersGuideMessage();
    return inputWinningLottoNumbersAndVerify();
  }

  public LottoNumber inputBonusNumber() {
    OutputView.printInputBonusNumberGuideMessage();

    return inputBonusNumberAndVerify();
  }

  private LottoNumber inputBonusNumberAndVerify() {
    String input = SCANNER.nextLine();
    try {
      checkStringIsNumber(input);
      return new LottoNumber(parseInt(input));
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputBonusNumberAndVerify();
    }
  }

  private PurchaseAmount inputPurchaseAmountAndVerify() {
    String input = SCANNER.nextLine();
    try {
      return new PurchaseAmount(parseInt(input));
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputPurchaseAmountAndVerify();
    }
  }

  private LottoNumbers inputWinningLottoNumbersAndVerify() {
    String input = SCANNER.nextLine();
    try {
      String[] splitedString = getSplitedString(input);
      return makeLottoNumbers(splitedString);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputWinningLottoNumbersAndVerify();
    }
  }

  private LottoNumbers makeLottoNumbers(String[] splitedString) {
    checkSplitedStringIsNumber(splitedString);

    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (String numberString : splitedString) {
      lottoNumbers.add(new LottoNumber(parseInt(numberString)));
    }

    return new LottoNumbers(lottoNumbers);
  }

  private String[] getSplitedString(String input) {
    checkNullOrEmpty(input);
    checkSplitByComma(input);
    return input.split(SPLIT_DELIMITER);
  }

  private void checkSplitedStringIsNumber(String[] splitedString) {
    for (String numberString : splitedString) {
      checkStringIsNumber(numberString);
    }
  }

  private void checkNullOrEmpty(String input) {
    if (input == null || input.isEmpty()) {
      throw new NullPointerException(INPUT_EMPTY_ERROR_MESSAGE);
    }
  }

  private int parseInt(String input) {
    return Integer.parseInt(input);
  }

  private void checkStringIsNumber(String string) {
    if (!NUMBER_PATTERN.matcher(string).matches()) {
      throw new NumberFormatException();
    }
  }

  private void checkSplitByComma(String input) {
    if (!input.contains(SPLIT_DELIMITER)) {
      throw new IllegalArgumentException();
    }
  }

}