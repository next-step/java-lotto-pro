package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import lotto.infrastructure.util.RandomLottoNumber;

public class LottoNumbersTest {
  private static MockedStatic<RandomLottoNumber> randomLottoNumber;

  @BeforeAll
  public static void beforeClass() {
    randomLottoNumber = mockStatic(RandomLottoNumber.class);
  }

  @AfterAll
  public static void afterClass() {
    randomLottoNumber.close();
  }

  @DisplayName("로또 번호들이 자동 생성된다.")
  @Test
  void gerate_lottonumbers_auto() {
    // given
    LottoNumbers lottoNumbers = new LottoNumbers();

    when(RandomLottoNumber.generate()).thenReturn(Arrays.asList(LottoNumber.valueOf("1"),
                                                                LottoNumber.valueOf("3"),
                                                                LottoNumber.valueOf("5"),
                                                                LottoNumber.valueOf("6"),
                                                                LottoNumber.valueOf("14"),
                                                                LottoNumber.valueOf("17")));

    // when
    lottoNumbers.generate();

    // then
    assertThat(lottoNumbers.toString()).isEqualTo("1, 3, 5, 6, 14, 17");
  }
}
