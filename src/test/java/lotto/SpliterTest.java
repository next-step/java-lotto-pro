package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class SpliterTest {
    @Test
    void 입력값_리스트_생성() {
        Spliter spliter = new Spliter();
        List<LottoNumber> input = spliter.split("1, 2, 3");
        assertThat(input.get(0)).isEqualTo(new LottoNumber(1));
        assertThat(input.get(1)).isEqualTo(new LottoNumber(2));
        assertThat(input.get(2)).isEqualTo(new LottoNumber(3));
    }
}
