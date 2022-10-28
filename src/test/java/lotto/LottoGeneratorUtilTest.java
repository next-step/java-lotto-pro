package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.util.LottoGeneratorUtil;

class LottoGeneratorUtilTest {
    @Test
    void 숫자1부터_45까지_중복없이_6개_숫자_선택한다() {
        List<Integer> numbers = LottoGeneratorUtil.generate();
        for (Integer number : numbers) {
            System.out.println(number);
        }
        assertThat(numbers).hasSize(6);
    }
}