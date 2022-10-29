package step3.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.util.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

  @Test()
  @DisplayName("1-45 범위의 랜덤한 6 자리의 숫자 리스틀 잘 생성하는지 확인.")
  void generator_lotto_numbers() {
    //given, when
    List<Integer> lottoNumbers = LottoGenerator.generateLottoNumbers();
    //then
    assertAll(
        () -> assertThat(lottoNumbers.size()).isEqualTo(6),
        () -> lottoNumbers.forEach(
            number -> assertThat(number).isBetween(1, 45))
    );
  }

}