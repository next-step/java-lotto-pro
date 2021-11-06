package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.infrastructure.util.RandomLottoNumber;

public class LottoNumbers {
  private static final int VALID_LOTTONUMBER_HAS_COUNT = 6;
  private List<LottoNumber> values;

  public LottoNumbers() {
    this.values = new ArrayList<>();
  }

  public LottoNumbers(List<LottoNumber> values) {
    checkLottoNumberCount(values);

    this.values = new ArrayList<>(values);
  }

  public static LottoNumbers valueOf(String ... values) {
    return Stream.of(values)
                  .map(LottoNumber::valueOf)
                  .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::new));
  }


  private static void checkLottoNumberCount(List<LottoNumber> values) {
    if (values.size() != VALID_LOTTONUMBER_HAS_COUNT) {
      throw new IllegalArgumentException("로또 번호의 갯수가 6개가 아닙니다.");
    }
  }

  public void generate() {
    this.values = RandomLottoNumber.generate();
  }

  public boolean contains(LottoNumber lottoNumber) {
    return values.contains(lottoNumber);
  }

  public Integer size() {
    return values.size();
  }

  public LottoNumber get(Integer index) {
    return values.get(index);
  }

  public String toString() {
    return values.stream().map(LottoNumber::toString)
                          .reduce((result, seed) -> result += ", " + seed)
                          .orElse("");
  }

  public Long countOf(LottoNumbers lottoNumbers) {
    return lottoNumbers.values.stream()
                              .filter(item -> this.values.contains(item))
                              .count();
  }
}
