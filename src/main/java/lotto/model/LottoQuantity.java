package lotto.model;

import lotto.generator.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoQuantity {
  private final int lottoQuantity;

  public LottoQuantity(int lottoQuantity) {
    this.lottoQuantity = lottoQuantity;
  }

  public List<LottoNumbers> makeLottoNumbersAsQuantity(LottoGenerator lottoGenerator) {
    List<LottoNumbers> lottoNumbersList = new ArrayList<>();

    for (int i = 0; i < lottoQuantity; i++) {
      lottoNumbersList.add(lottoGenerator.generate());
    }

    return lottoNumbersList;
  }

  public int getLottoQuantity() {
    return lottoQuantity;
  }

  @Override
  public String toString() {
    return String.valueOf(lottoQuantity);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoQuantity that = (LottoQuantity) o;
    return lottoQuantity == that.lottoQuantity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoQuantity);
  }

}