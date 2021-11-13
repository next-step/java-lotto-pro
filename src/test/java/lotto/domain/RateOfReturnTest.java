package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RateOfReturnTest {

    @Test
    public void 수익률이_음수로_생성할_경우_0으로_초기화가_된다() {
        //given
        double input = -1;

        //when
        RateOfReturn expected = RateOfReturn.from(input);

        //then
        Assertions.assertThat(RateOfReturn.from(0)).isEqualTo(expected);
    }

}