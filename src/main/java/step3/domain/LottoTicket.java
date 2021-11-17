package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

  public static final int NUMBERS_COUNT = 6;
  public static final List<LottoNumber> totalLottoNumbers = IntStream
      .rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
      .boxed()
      .map(LottoNumber::new)
      .collect(Collectors.toList());

  private final List<LottoNumber> numbers;
  private final LottoNumber bonusNumber;

  // 랜덤 티켓
  public LottoTicket() {
    this.numbers = generateRandomLottoNumbers();
    this.bonusNumber = null;
  }

  // 번호를 입력 받는 티켓
  public LottoTicket(List<LottoNumber> numbers) {
    validate(numbers);
    this.numbers = numbers;
    this.bonusNumber = null;
  }

  // 번호 + 보너스 번호를 입력 받는 티켓
  public LottoTicket(List<LottoNumber> numbers, LottoNumber bonusNumber) {
    validate(numbers, bonusNumber);
    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  public List<LottoNumber> getNumbers() {
    return this.numbers;
  }

  public LottoNumber getBonusNumber() {
    return bonusNumber;
  }

  public boolean contains(LottoNumber number) {
    return number != null &&
        this.numbers.stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toList())
        .contains(number.getNumber());
  }

  private List<LottoNumber> generateRandomLottoNumbers() {
    Collections.shuffle(totalLottoNumbers);
    List<LottoNumber> lottoNumbers = new ArrayList<>(totalLottoNumbers.subList(0, NUMBERS_COUNT));
    Collections.sort(lottoNumbers);
    return lottoNumbers;
  }

  private void validate(List<LottoNumber> numbers) {
    if (numbers == null || numbers.size() != NUMBERS_COUNT
        || numbers.stream().distinct().count() != NUMBERS_COUNT) {
      throw new IllegalArgumentException("[ERROR] not valid lotto numbers. numbers = " + numbers);
    }
  }

  private void validate(List<LottoNumber> numbers, LottoNumber bonusNumber) {
    validate(numbers);

    if (bonusNumber != null && numbers.stream()
        .map(LottoNumber::getNumber)
        .collect(Collectors.toList())
        .contains(bonusNumber.getNumber())) {
      throw new IllegalArgumentException(
          "[ERROR] not valid bonus number. bonusNumber = " + bonusNumber);
    }
  }
}
