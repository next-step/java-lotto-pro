package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {
    private Lotto stringToLotto;

    @BeforeEach
    void setUp() {
        String input = "1, 2, 3, 4, 5, 6";
        Lotto lotto = new Lotto(input);
        stringToLotto = lotto;
    }
    @Test
    public void 로또_생성_자동() {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=45; i++) {
            list.add(i);
        }
        Lotto lotto = new Lotto(list);
        lotto.printLottoNumber();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void 로또_생성_입력(int input) {
        assertTrue(stringToLotto.getLottoNumber().contains(input));
    }

    @Test
    public void 로또_생성_0보다_작은_수() {
        assertThatThrownBy(() -> new Lotto("-1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_생성_45보다_큰_수() {
        assertThatThrownBy(() -> new Lotto("46, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_생성_중복_수() {
        assertThatThrownBy(() -> new Lotto("1, 1, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
