package lotto.model;

import lotto.constants.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
  private static List<LottoNumber> lottoNumberList;

  @BeforeEach
  void setUp() {
    lottoNumberList = new ArrayList<>();
    lottoNumberList.add(new LottoNumber(2));
    lottoNumberList.add(new LottoNumber(5));
    lottoNumberList.add(new LottoNumber(3));
    lottoNumberList.add(new LottoNumber(4));
    lottoNumberList.add(new LottoNumber(1));
    lottoNumberList.add(new LottoNumber(6));
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6})
  void 로또_번호들을_생성(int number) {
    LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

    assertThat(lottoNumbers.getLottoNumbers()).contains(new LottoNumber(number));
  }

  @Test
  void 로또_번호들을_정렬() {
    LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
    int[] expectedNumbers = {1, 2, 3, 4, 5, 6};
    LottoNumbers expected = new LottoNumbers(getLottoNumberList(expectedNumbers));

    lottoNumbers.sort();

    assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(expected.getLottoNumbers());
  }

  @DisplayName("현재 가지고 있는 로또와 입력 받은 로또를 비교하여 일치한 갯수를 반환한다.")
  @Test
  void 로또_비교() {
    LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

    int[] lottoNumbersList = {1, 2, 3, 4, 9, 10};
    LottoNumbers toCompareLottoNumbers = new LottoNumbers(getLottoNumberList(lottoNumbersList));

    int matchCount = lottoNumbers.countNumberOfMatches(toCompareLottoNumbers);

    assertThat(matchCount).isEqualTo(4);
  }

  private List<LottoNumber> getLottoNumberList(int[] numbers) {
    return Arrays
      .stream(numbers)
      .mapToObj(LottoNumber::new)
      .collect(Collectors.toList());
  }

}