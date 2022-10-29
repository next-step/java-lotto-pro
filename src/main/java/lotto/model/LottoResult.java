package lotto.model;

import static lotto.model.Counter.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.code.RankCode;

public class LottoResult {

  private static final int DEFAULT_VALUE = 0;
  private static final int COUNT_VALUE = 1;
  private static final double MATH_ROUND_VALUE = 100d;


  private final HashMap<RankCode, Integer> resultMap;
  private final LottoList lottoList;
  private final WinningLotto winningLotto;


  public LottoResult(LottoList lottoList, WinningLotto winningLotto) {
    resultMap = new HashMap<RankCode, Integer>();
    this.lottoList = lottoList;
    this.winningLotto = winningLotto;
    calculateLottoResult();
  }

  private void calculateLottoResult() {

    for (Lotto lotto : lottoList.getLottoList()) {
      int matchingCount = lotto.countMatchingNumber(winningLotto.getLotto());

      RankCode rankCode = RankCode.getRankCode(matchingCount);

      if (resultMap.containsKey(rankCode)) {
        int value = resultMap.get(rankCode);

        value++;

        resultMap.put(rankCode, value);
      }

      resultMap.put(rankCode, 1);
    }
  }

  public List<String> convertResultMapToString() {

    List<String> rankStringList = new ArrayList<>();

    for (Map.Entry<RankCode, Integer> rankEntry : resultMap.entrySet()) {
      validNothing(rankStringList, rankEntry);
    }
    Collections.sort(rankStringList);

    return rankStringList;
  }

  private String stringBuilderAppend(Map.Entry<RankCode, Integer> rankEntry) {
    RankCode rankCode = rankEntry.getKey();
    StringBuilder stringBuilder = new StringBuilder();
    return stringBuilder
        .append(RankCode.containsCount(rankCode))
        .append("개 일치 ")
        .append("(")
        .append(RankCode.getMoney(rankCode))
        .append("원)- ")
        .append(rankEntry.getValue())
        .append("개").toString();
  }

  private void validNothing(List<String> rankStringList, Map.Entry<RankCode, Integer> rankEntry) {
    if (rankEntry.getKey() != RankCode.NOTHING) {
      rankStringList.add(stringBuilderAppend(rankEntry));
    }
  }

  private double calculateYield() {
    int prizeMoney = DEFAULT_VALUE;

    for (RankCode rankCode : resultMap.keySet()) {
      int money = RankCode.getMoney(rankCode);
      int value = resultMap.get(rankCode);

      prizeMoney += money * value;
    }

    return prizeMoney / (lottoList.getLottoList().size() * LOTTO_PRICE);
  }

  public String convertYieldToString() {
    StringBuilder stringBuilder = new StringBuilder();
    double yield = (Math.round((calculateYield() * MATH_ROUND_VALUE)) / MATH_ROUND_VALUE);
    stringBuilder
        .append("총 수익률은 ")
        .append(yield)
        .append("입니다.");
    if (yield < COUNT_VALUE) {
      stringBuilder.append("(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
    }
    return stringBuilder.toString();
  }

}
