package lotto.model;

import java.util.List;

public class LottoNumbers {
  private final List<Integer> lottoNumbers;

  public LottoNumbers(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public int countMatchNumber(LottoNumbers targetLottoNumbers) {
    int count = 0;
    for (Integer lottoNumber : targetLottoNumbers.lottoNumbers) {
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
