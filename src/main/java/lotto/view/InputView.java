package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.PurchaseAmount;

import java.util.ArrayList;
import java.util.Arrays;
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
    return inputLottoNumbersAndVerify();
  }

  public int inputManualLottoQuantity() {
    printInputManualLottoQuantityGuideMessage();
    return inputNumberAndVerify();
  }

  public LottoNumbers inputManualLottoNumbers() {
    return inputLottoNumbersAndVerify();
  }

  public LottoNumber inputBonusNumber() {
    printInputBonusNumberGuideMessage();
    return new LottoNumber(inputNumberAndVerify());
  }

  private int inputNumberAndVerify() {
    String input = SCANNER.nextLine();
    try {
      checkStringIsNumber(input);
      return parseInt(input);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputNumberAndVerify();
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

  private LottoNumbers inputLottoNumbersAndVerify() {
    String input = SCANNER.nextLine();
    try {
      String[] splitedString = splitAndTrim(input);
      return makeLottoNumbers(splitedString);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputLottoNumbersAndVerify();
    }
  }

  private LottoNumbers makeLottoNumbers(String[] splitedString) {
    checkElementsIsNumber(splitedString);

    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (String numberString : splitedString) {
      lottoNumbers.add(new LottoNumber(parseInt(numberString)));
    }

    return new LottoNumbers(lottoNumbers);
  }

  private String[] splitAndTrim(String input) {
    checkNullOrEmpty(input);
    checkSplitByComma(input);

    String[] strings = input.split(SPLIT_DELIMITER);
    return Arrays.stream(strings).map(String::trim).toArray(String[]::new);
  }

  private void checkElementsIsNumber(String[] splitedString) {
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