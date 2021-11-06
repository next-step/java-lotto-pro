package lotto.constants;

import java.util.Arrays;

public enum LottoRank {
  THREE_MATCHES(3, 5000),
  FOUR_MATCHES(4, 50000),
  FIVE_MATCHES(5, 1500000),
  SIX_MATCHES(6, 2000000000);

  private final int rank;
  private final int money;

  LottoRank(int rank, int money) {
    this.rank = rank;
    this.money = money;
  }

  public int getRank() {
    return rank;
  }

  public int getMoney() {
    return money;
  }

  public static LottoRank valueOf(int rank) {
    return Arrays.stream(LottoRank.values())
      .filter(lottoRank -> lottoRank.rank == rank)
      .findAny()
      .orElse(null);
  }
}
