package lotto.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTest {

  @Test
  @DisplayName("로또 자동생성시, 사이즈와 숫자 범위 확인")
  void generate_lotto_default() {
    //given //when
    Lotto lotto = Lotto.createAutoLotto();

    //then
    assertAll(
        () -> assertThat(lotto.getNumbers().size()).isEqualTo(6),
        () -> lotto.getNumbers().forEach(
            number -> assertThat(number.toInt()).isBetween(1, 45))
    );
  }

  @Test
  @DisplayName("로또 주어진 숫자 리스트로 생성시, 올바르게 로또가 생성되는지 확인.")
  void generate_lotto_by_parameter() {
    //given
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    //when
    Lotto lotto = Lotto.createManualLotto(numbers);

    //then
    assertAll(
        () -> assertThat(lotto.getNumbers().get(0)).isEqualTo(LottoNumber.from(1)),
        () -> assertThat(lotto.getNumbers().get(1)).isEqualTo(LottoNumber.from(2)),
        () -> assertThat(lotto.getNumbers().get(2)).isEqualTo(LottoNumber.from(3)),
        () -> assertThat(lotto.getNumbers().get(3)).isEqualTo(LottoNumber.from(4)),
        () -> assertThat(lotto.getNumbers().get(4)).isEqualTo(LottoNumber.from(5)),
        () -> assertThat(lotto.getNumbers().get(5)).isEqualTo(LottoNumber.from(6))

    );
  }

  @Test
  @DisplayName("로또끼리 비교를 하여 동일한 값의 개수를 주는지 확인")
  void 로또_비교() {
    //given
    Lotto lotto = Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto targetLotto = Lotto.createManualLotto(Arrays.asList(4, 5, 6, 7, 8, 9));
    //when
    int count = lotto.getMatchingCount(targetLotto);
    //then
    assertThat(count).isEqualTo(3);
  }

  @ParameterizedTest(name = "숫자가 포함되어 있을 떄, specificNumber: {0}, result: {1}")
  @CsvSource(value = {
      "6 : true",
      "8: false"
  }, delimiter = ':')
  @DisplayName("로또에 특정 번호가 포함되어 있는지 확인")
  void lotto_is_contain_number(int specificNumber, boolean isContain) {
    //given
    Lotto lotto = Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    //when
    boolean result = lotto.isContainNumber(LottoNumber.from(specificNumber));
    //then
    assertThat(result).isEqualTo(isContain);
  }

}
