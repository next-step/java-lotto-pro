package Lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또_1과45사이_6개의_숫자_추출() {
        Lotto lotto = new Lotto();
        assertThat(Collections.max(lotto.getNumbers())).isBetween(1, 45);
        assertThat(Collections.min(lotto.getNumbers())).isBetween(1, 45);
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:false"}, delimiter = ':')
    public void 지난주_당첨번호_생성(int input, boolean flag) {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.getNumbers().contains(input)).isEqualTo(flag);
    }
}
