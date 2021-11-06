package lotto.model;

import java.util.List;

public class Lotto {
  private final List<Integer> lottoNumbers;

  public Lotto(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public int countMatchNumber(Lotto targetLotto) {
    int count = 0;
    for (Integer lottoNumber : targetLotto.lottoNumbers) {
      count += matchCount(lottoNumber);
    }
    return count;
  }

  private int matchCount(Integer lottoNumber) {
    if (lottoNumbers.contains(lottoNumber)) {
      return 1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }
}
