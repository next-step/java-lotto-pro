package lotto.view;
//
//import lotto.model.LottoGenerator;
//import lotto.model.LottoNumbers;
//import lotto.model.LottoResult;

import lotto.model.Lotto;
import lotto.model.LottoList;
import lotto.model.LottoResult;

public class OutputView {


  public static void printCompletePurchaseLotto(LottoList lottoList) {
    System.out.println(lottoList.getLottoList().size() + "개를 구입했습니다.");
    for (Lotto lotto : lottoList.getLottoList()) {
      System.out.println(lotto.getNumbers());
    }
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

}