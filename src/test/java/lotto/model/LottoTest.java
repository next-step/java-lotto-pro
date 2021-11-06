package lotto.model;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
  int[] lottoData;

  @BeforeEach
  void setUp() {
    lottoData = new int[]{1, 2, 3, 4, 5, 6};
  }

  @DisplayName("당첨 번호와 발급한 로또 번호의 일치 횟수를 확인한다.")
  @Test
  void matchCount() {
    Lotto machineLotto = new Lotto(asList(new int[]{1, 2, 3, 5, 10, 11}));
    Lotto buyerLotto = new Lotto(asList(lottoData));

    assertThat(buyerLotto.countMatchNumber(machineLotto)).isEqualTo(4);
  }

  @DisplayName("로또 번호를 문자열 형태로 반환한다.")
  @Test
  void lottoToString() {
    Lotto lotto = new Lotto(asList(lottoData));
    assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
  }


  private List<Integer> asList(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int number : numbers) {
      list.add(number);
    }

    return list;
  }
}
