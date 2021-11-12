package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

  public static final int NUMBERS_COUNT = 6;

  private final List<LottoNumber> numbers;

  // 랜덤 티켓
  public LottoTicket() {
    this.numbers = generateRandomLottoNumbers();
  }

  // 번호를 입력 받는 티켓
  public LottoTicket(List<LottoNumber> numbers) {
    this.numbers = numbers;
    validate();
  }

  public List<LottoNumber> getNumbers() {
    return this.numbers;
  }

  public List<Integer> getNumbersAsInteger() {
    return this.numbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
  }

  private List<LottoNumber> generateRandomLottoNumbers() {
    final List<Integer> totalNumbers = getTotalNumbers();
    Collections.shuffle(totalNumbers);

    final List<Integer> lottoNumbers = totalNumbers.subList(0, NUMBERS_COUNT);
    Collections.sort(lottoNumbers);

    return lottoNumbers.stream()
        .map(LottoNumber::new)
        .collect(Collectors.toList());
  }

  private List<Integer> getTotalNumbers() {
    final List<Integer> totalNumbers = new ArrayList<>();
    for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
      totalNumbers.add(i);
    }
    return totalNumbers;
  }

  private void validate() {
    if (this.numbers == null || this.numbers.size() != NUMBERS_COUNT
        || this.numbers.stream().distinct().count() != NUMBERS_COUNT) {
      throw new RuntimeException("[ERROR] not valid lotto ticket. numbers = " + this.numbers);
    }
  }

  @Override
  public String toString() {
    return this.numbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList())
        .toString();
  }
}
