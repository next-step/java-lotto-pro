package lotto.domain;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    void 문자열을_정수_리스트로_변환() {
        // given
        String input = "1, 2, 3, 4, 5, 6";

        // when
        List<Integer> result = StringUtils.convertIntegerList(input);

        // then
        assertThat(result.size()).isEqualTo(6);
        assertThat(result).isEqualTo(new ArrayList(Arrays.asList(new int[] {1, 2, 3, 4, 5, 6})));
    }
}