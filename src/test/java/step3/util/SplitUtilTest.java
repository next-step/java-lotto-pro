package step3.util;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.util.SplitUtil;
import org.junit.jupiter.api.Test;

class SplitUtilTest {

  @Test
  void 입력된_문자열을_자르는_메소드_테스트() throws Exception {
    // given
    String input = "1, 2, 3, 4, 5, 6";

    // when
    String[] inputArray = SplitUtil.splitInputNumbers(input);

    // then
    assertThat(inputArray).hasSize(6);
    assertThat(inputArray).isEqualTo(new String[]{"1", "2", "3", "4", "5", "6"});
  }
}