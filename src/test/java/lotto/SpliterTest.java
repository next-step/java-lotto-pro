package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SpliterTest {
    @Test
    void 입력값_리스트_생성() {
        Spliter spliter = new Spliter();
        List<Integer> input = spliter.split("1, 2, 3");
        assertThat(input.get(0)).isEqualTo(1);
        assertThat(input.get(1)).isEqualTo(2);
        assertThat(input.get(2)).isEqualTo(3);
    }
}
