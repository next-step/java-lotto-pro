package lotto.domain;

import lotto.domain.LottoTicket;
import lotto.domain.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoGeneratorTest {
    @DisplayName("랜덤하게 로또 티켓을 생성할 수 있다")
    @Test
    void create_test() {
        assertThat(new RandomLottoGenerator().create()).isInstanceOf(LottoTicket.class);
    }
}
