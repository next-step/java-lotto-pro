package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
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

  @DisplayName("로또 번호들중 일치하는 로또번호 일치 여부 판단")
  @Test
  void confirm_containLotto() {
    // given
    LottoNumbers lottoNumbers = LottoNumbers.valueOf("1", "3", "7", "9", "13", "23");
    LottoNumber lottoNumber = LottoNumber.valueOf("1");

    // when
    Boolean realValue = lottoNumbers.contains(lottoNumber);

    // then
    assertThat(realValue).isTrue();
  }


  @DisplayName("로또 번호들을 생성시 기번 로또 번호의 개수가 6개가 아닐시 에러 발생.")
  @Test
  void check_illegalLottoNumberCount() {
    // given
    // when
		ThrowingCallable exceptionContent = () -> {Lotto lotto = Lotto.valueOf("1", "3", "7", "9", "13");};

    // then
		assertThatExceptionOfType(IllegalArgumentException.class)
    .isThrownBy(exceptionContent)
    .withMessageMatching("로또 번호의 갯수가 6개가 아닙니다.");

  }
}
