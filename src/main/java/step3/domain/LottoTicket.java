package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
  public static final int NUMBERS_COUNT = 6;

  private final List<LottoNumber> numbers;

  public LottoTicket() {
    this.numbers = generateRandomLottoNumbers();
  }

  public LottoTicket(List<LottoNumber> numbers) {
    this.numbers = numbers;
  }

  public List<LottoNumber> getNumbers() {
    return this.numbers;
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
}
