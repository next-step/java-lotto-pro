package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("당첨 번호가 입력되면 해당하는 등수를 반환한다.")
    void test1() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        Rank rank = lotto.getRankBy(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }


    @Test
    @DisplayName("로또 하나의 문자열 형식은 [숫자,]가 되어야 함")
    void test2() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.toString()).matches("\\[[0-9,]+]");
    }

}