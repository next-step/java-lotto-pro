package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.infrastructure.util.RandomLottoNumber;

public class LottoNumbers {
  private List<LottoNumber> values;

  public LottoNumbers() {
    this.values = new ArrayList<>();
  }

  private LottoNumbers(List<LottoNumber> values) {
    this.values = new ArrayList<>(values);
  }

  public static LottoNumbers valueOf(String ... values) {
    return Stream.of(values)
                  .map(LottoNumber::new)
                  .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));
  }

  public void generate() {
    this.values = RandomLottoNumber.generate();
  }

  public String toString() {
    return values.stream().map(LottoNumber::toString)
                          .reduce((result, seed) -> result += ", " + seed)
                          .orElse("");
  }
}
