package lotto.view;


import lotto.model.Counter;
import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.LottoResult;

public class OutputView {

  private final static String STARTING_BRACKET = "[";
  private final static String END_BRACKET = "]";
  private final static String SEPARATOR_BRACKET = " ,";
  private final static int START_INDEX_CALCULATE_NUMBER = 0;
  private final static int LAST_INDEX_CALCULATE_NUMBER = 1;

  public static void printCompletePurchaseLotto(Counter counter) {
    LottoList lottoList = counter.getLottoList();
    StringBuilder stringBuilder = new StringBuilder();

    if (validManualLottoAmount(counter)) {
      stringBuilder.append("수동으로 ")
          .append(counter.getManualLottoAmount())
          .append("장, ");
    }
    stringBuilder.append("자동으로 ")
        .append(counter.getAutoLottoAmount())
        .append("개를 구매했습니다.");

    System.out.println(stringBuilder);

//    System.out.println(lottoList.getLottoList().size() + "개를 구입했습니다.");
    for (Lotto lotto : lottoList.getLottoList()) {
      System.out.println(lottoNumbersToString(lotto));
    }
  }

  private static boolean validManualLottoAmount(Counter counter) {
    return counter.getManualLottoAmount() > 0;
  }

  public static void printResultHead() {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");
  }

  public static void printLottoResult(LottoResult lottoResult) {
    for (String result : lottoResult.convertResultMapToString()) {
      System.out.println(result);
    }
    System.out.println(lottoResult.convertYieldToString());
  }

  public static String lottoNumbersToString(Lotto lotto) {
    StringBuilder sb = new StringBuilder();
    int size = lotto.getNumbers().size();
    sb.append(STARTING_BRACKET);
    for (int i = START_INDEX_CALCULATE_NUMBER; i < size; i++) {
      sb.append(lotto.getNumbers().get(i).toInt());
      addSeparatorInBracket(sb, i, size);
    }
    sb.append(END_BRACKET);
    return sb.toString();
  }

  private static void addSeparatorInBracket(StringBuilder sb, int i, int size) {
    if (i < size - LAST_INDEX_CALCULATE_NUMBER) {
      sb.append(SEPARATOR_BRACKET);
    }
  }

  public static void printErrorMessage(Exception exception) {
    System.out.println(exception.getMessage());
  }


}