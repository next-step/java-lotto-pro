package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.Fixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayslipsTest {

    private Playslips playslips;

    @BeforeEach
    void setUp() {
        playslips = new Playslips(
            Arrays.asList(
                new Playslip(Fixtures.createNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new Playslip(Fixtures.createNumbers(Arrays.asList(40, 41, 42, 43, 44, 45)))
            )
        );
    }

    @Test
    @DisplayName("여러장의 로또 용지로 로또 용지 일급 컬렉션을 생성할 수 있다.")
    void create() {
        assertThat(playslips.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 당첨 결과를 생성할 수 있다.")
    void checkResult() {
        assertThat(
            playslips.checkResult(Fixtures.winningNumbers, Fixtures.bonusNumber)
        ).isNotNull();
    }
}
