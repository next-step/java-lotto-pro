package step3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoTest {
    private List<Integer> numbers;

    @BeforeEach
    void beforeEach() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void valid_로또_생성() {
        Assertions.assertThat(new Lotto(numbers)).isEqualTo(new Lotto(numbers));
    }

    @Test
    void invalid_로또_생성_숫자개수() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("중복되지 않은 %d개의 숫자를 입력해주세요.", Lotto.SIZE));
    }

    @Test
    void 구매한_로또와_당첨번호_비교() {
        Lotto buyLotto = LottoFactory.createManualLotto(numbers);
        int matchCount = buyLotto.match(new WinnerLotto(Arrays.asList(1, 2, 3, 11, 23, 44)));
        assertThat(matchCount).isEqualTo(3);
    }
}