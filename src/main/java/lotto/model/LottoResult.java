package lotto.model;

import static lotto.model.Counter.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

  private static final int DEFAULT_VALUE = 0;
  private static final int COUNT_VALUE = 1;
  private static final double MATH_ROUND_VALUE = 100d;


  private final HashMap<LottoRank, Integer> resultMap;
  private final LottoList lottoList;
  private final WinningLotto winningLotto;


  public LottoResult(LottoList lottoList, WinningLotto winningLotto) {
    resultMap = new HashMap<LottoRank, Integer>();
    this.lottoList = lottoList;
    this.winningLotto = winningLotto;
    calculateLottoResult();
  }

  private void calculateLottoResult() {
    for (Lotto lotto : lottoList.getLottoList()) {
      calculateLottoMatch(lotto);
    }
  }

  private void calculateLottoMatch(Lotto lotto) {
    LottoRank lottoRank = this.winningLotto.getLottoRankByLotto(lotto);

    if (resultMap.containsKey(lottoRank)) {
      int value = resultMap.get(lottoRank);

      value++;

      resultMap.put(lottoRank, value);

      return;
    }

    resultMap.put(lottoRank, 1);
  }

  public List<String> convertResultMapToString() {

    List<String> rankStringList = new ArrayList<>();

    rankStringList = resultMap.entrySet().stream()
        .filter(entry -> entry.getKey() != LottoRank.NOTHING)
        .map(this::generateRankResultByStringFormat)
        .collect(Collectors.toList());

    Collections.sort(rankStringList);

    return rankStringList;
  }

  private String generateRankResultByStringFormat(Map.Entry<LottoRank, Integer> rankEntry) {
    LottoRank lottoRank = rankEntry.getKey();

    if (lottoRank == LottoRank.SECOND) {
      return String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개",
          lottoRank.containsCount(), lottoRank.getMoney(), rankEntry.getValue());
    }

    return String.format("%d개 일치 (%d원)- %d개",
        lottoRank.containsCount(), lottoRank.getMoney(), rankEntry.getValue());
  }

  private double calculateYield() {
    int prizeMoney = DEFAULT_VALUE;

    for (LottoRank lottoRank : resultMap.keySet()) {
      int money = lottoRank.getMoney();
      int value = resultMap.get(lottoRank);

      prizeMoney += money * value;
    }

    return (double) prizeMoney / (lottoList.getLottoList().size() * LOTTO_PRICE);
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
