package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  @DisplayName("로또 디폴드 생성자로 생성시, 사이즈와 숫자 범위 확인")
  void generate_lotto_default() {
    //given //when
    Lotto lotto = new Lotto();

    //then
    assertAll(
        () -> assertThat(lotto.getNumbers().size()).isEqualTo(6),
        () -> lotto.getNumbers().forEach(
            number -> assertThat(number).isBetween(1, 45))
    );
  }

  @Test
  @DisplayName("로또 주어진 숫자 리스트로 생성시, 올바르게 로또가 생성되는지 확인.")
  void generate_lotto_by_parameter() {
    //given
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    //when
    Lotto lotto = new Lotto(numbers);

    //then
    assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
  }

  @Test
  @DisplayName("로또끼리 비교를 하여 동일한 값의 개수를 주는지 확인")
  void 로또_비교() {
    //given
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto targetLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
    //when
    int count = lotto.getMatchingCount(targetLotto);
    //then
    assertThat(count).isEqualTo(3);
  }

}
