package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.infrastructure.util.RandomLottoNumber;

public class LottoNumbers {
  private static final int VALID_LOTTONUMBER_HAS_COUNT = 6;
  private List<LottoNumber> numbers;

  private LottoNumbers(List<LottoNumber> numbers) {
    checkLottoNumberInvalid(numbers);

    this.numbers = new ArrayList<>(numbers);
  }
  
  public static LottoNumbers valueOf(String ... numbers) {
    return Stream.of(numbers)
                  .map(LottoNumber::valueOf)
                  .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::valueOf));
  }
 
  public static LottoNumbers valueOf(List<LottoNumber> numbers) {
    return new LottoNumbers(numbers);
  }

  public static LottoNumbers generate() {
    return LottoNumbers.valueOf(RandomLottoNumber.generate());
  }

  private void checkLottoNumberInvalid(List<LottoNumber> numbers) {
    checkLottoNumberCount(numbers);
    checkDuplicateLottoNumber(numbers);
  }

  private static void checkLottoNumberCount(List<LottoNumber> numbers) {
    if (numbers.size() != VALID_LOTTONUMBER_HAS_COUNT) {
      throw new IllegalArgumentException("로또 번호의 갯수가 6개가 아닙니다.");
    }
  }

  private void checkDuplicateLottoNumber(List<LottoNumber> numbers) {
    if (numbers.size() != new HashSet<>(numbers).size()) {
      throw new IllegalArgumentException("로또 번호가 중복된 값이 존재합니다.");
    }
  }

  public boolean contains(LottoNumber lottoNumber) {
    return numbers.contains(lottoNumber);
  }

  public Long countOf(LottoNumbers lottoNumbers) {
    return this.numbers.stream()
                        .filter(lottoNumbers::contains)
                        .count();
  }

  public List<String> getNumbersToString() {
    return this.numbers.stream()
                        .map(LottoNumber::toString)
                        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)  {
      return true;
    }
    if (!(o instanceof LottoNumbers)) {
      return false;
    }
    LottoNumbers lottoNumbers = (LottoNumbers) o;

    return Objects.equals(numbers, lottoNumbers.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(numbers);
  }
}
