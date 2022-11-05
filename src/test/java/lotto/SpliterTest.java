package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class SpliterTest {
    @Test
    void 입력값_리스트_생성() {
        Spliter spliter = new Spliter();
        List<Integer> lottoNumbers = spliter.splitToList("1, 2, 3");
        assertThat(lottoNumbers.contains(1)).isTrue();
        assertThat(lottoNumbers.contains(2)).isTrue();
        assertThat(lottoNumbers.contains(3)).isTrue();
        assertThat(lottoNumbers.contains(4)).isFalse();
    }
}
