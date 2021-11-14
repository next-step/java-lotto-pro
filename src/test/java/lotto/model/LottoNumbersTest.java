package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
  int[] lottoData;

  @BeforeEach
  void setUp() {
    lottoData = new int[]{1, 2, 3, 4, 5, 6};
  }

  @DisplayName("당첨 번호와 발급한 로또 번호의 일치 횟수를 확인한다.")
  @Test
  void matchCount() {
    LottoNumbers machineLottoNumbers = new LottoNumbers(asList(new int[]{1, 2, 3, 5, 10, 11}));
    LottoNumbers buyerLotto = new LottoNumbers(asList(lottoData));

    assertThat(buyerLotto.countOfMatch(machineLottoNumbers)).isEqualTo(4);
  }

  @DisplayName("로또 번호를 문자열 형태로 반환한다.")
  @Test
  void lottoToString() {
    LottoNumbers lottoNumbers = new LottoNumbers(asList(lottoData));
    assertThat(lottoNumbers.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
  }


  private List<Integer> asList(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int number : numbers) {
      list.add(number);
    }

    return list;
  }
}
