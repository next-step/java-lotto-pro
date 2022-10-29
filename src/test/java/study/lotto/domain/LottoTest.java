package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 추첨 기능 테스트")
class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lotto = new Lotto(numbers);
    }

    @Test
    void drawLots_낙첨() {
        assertEquals(LottoStatus.NONE, lotto.drawLots(new WinningLotto(("11, 22, 23, 33, 35, 45"))));
    }

    @Test
    void drawLots_4등_당첨() {
        assertEquals(LottoStatus.FOURTH_PLACE, lotto.drawLots(new WinningLotto(("1, 2, 3, 11, 23, 45"))));
    }

    @Test
    void drawLots_3등_당첨() {
        assertEquals(LottoStatus.THIRD_PLACE, lotto.drawLots(new WinningLotto("1, 2, 3, 4, 11, 23")));
    }

    @Test
    void drawLots_2등_당첨() {
        assertEquals(LottoStatus.SECOND_PLACE, lotto.drawLots(new WinningLotto(("1, 2, 3, 4, 5, 11"))));
    }

    @Test
    void drawLosts_1등_당첨() {
        assertEquals(LottoStatus.FIRST_PLACE, lotto.drawLots(new WinningLotto(("1, 2, 3, 4, 5, 6"))));
    }

    @ParameterizedTest
    @CsvSource(value = { "1:1", "8:0", "2:1", "45:0" }, delimiter = ':')
    void Lotto가_가진_LottoNumber_목록에_입력된_LottoNumber의_포함여부(int lottoNumber, int expected) {
        assertEquals(expected, lotto.contains(LottoNumber.of(lottoNumber)));
    }
}
