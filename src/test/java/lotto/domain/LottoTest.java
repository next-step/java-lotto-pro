package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("당첨 번호가 입력되면 맞춘 갯수를 반환한다")
    void test1() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int count = lotto.check(Arrays.asList(1, 2, 3, 10, 11, 12));

        assertThat(count).isEqualTo(3);
    }
}