package lotto.util;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumbers;

class LottoUtilTest {
    @Test
    void 숫자1부터_45까지_중복없이_6개_숫자_선택한다() {
        Set<Integer> numbers = LottoUtil.generate();
        for (Integer number : numbers) {
            System.out.println(number);
        }
        assertThat(numbers).hasSize(6);
    }

    @Test
    void 당첨번호를_규칙대로_파싱후_객체를_반환한다() {
        assertThat(LottoUtil.toLottoNumber("1,2,3,4,5,6")).isEqualTo(
            new LottoNumbers(new HashSet<>(asList(1, 2, 3, 4, 5, 6))));
        assertThat(LottoUtil.toLottoNumber("1 , 2 , 3 , 4 , 5 , 6")).isEqualTo(
            new LottoNumbers(new HashSet<>(asList(1, 2, 3, 4, 5, 6))));
        assertThatThrownBy(() -> LottoUtil.toLottoNumber("1 , 2 , 3 , 4 , 5 , 6, 7"))
            .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> LottoUtil.toLottoNumber("1 , 2 , 3 , 4 , 5 , 5"))
            .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> LottoUtil.toLottoNumber("1234"))
            .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> LottoUtil.toLottoNumber(null))
            .isInstanceOf(IllegalStateException.class);
    }
}