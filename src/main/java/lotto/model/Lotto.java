package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.exception.ErrorCode;
import lotto.exception.LottoException;
import lotto.util.LottoGenerator;
import lotto.util.SplitUtil;

public class Lotto {

  private static final String NUMBER_COMMA_REGEX = "[\\s0-9,]+";
  private static final int LOTTO_SIZE = 6;


  private final List<LottoNumber> numbers;

  public Lotto(List<Integer> numbers) {
    List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::from)
        .collect(Collectors.toList());
    this.numbers = lottoNumbers;
  }

  public static Lotto createAutoLotto() {
    return new Lotto(LottoGenerator.generateLottoNumbers());
  }

  public static Lotto createManualLotto(String numbers) {
    validateStringNumbers(numbers);

    String[] splitNumbers = SplitUtil.splitInputNumbers(numbers);

    validLottoSize(splitNumbers);

    List<Integer> nums = Arrays.stream(splitNumbers).mapToInt(Integer::parseInt)
        .boxed().collect(Collectors.toList());

    return new Lotto(nums);
  }

  private static void validateStringNumbers(String numbers) {
    if (!numbers.matches(NUMBER_COMMA_REGEX)) {
      throw new LottoException(ErrorCode.IS_NOT_LOTTO_NUMBER_SIZE_ERROR);
    }
  }

  private static void validLottoSize(String[] splitNumbers) {
    if (splitNumbers.length != LOTTO_SIZE) {
      throw new LottoException(ErrorCode.IS_NOT_LOTTO_NUMBER_SIZE_ERROR);
    }
  }

  public List<LottoNumber> getNumbers() {
    return this.numbers;
  }

  public int getMatchingCount(Lotto targetLotto) {
    int count = 0;

    List<LottoNumber> targetLottoNumber = targetLotto.getNumbers();

    for (LottoNumber number : targetLottoNumber) {
      count = this.countContainNumber(number, count);
    }

    return count;
  }

  public boolean isContainNumber(LottoNumber number) {
    return this.numbers.contains(number);
  }

  private int countContainNumber(LottoNumber number, int count) {
    return isContainNumber(number) ? count + 1 : count;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(numbers, lotto.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }
}
