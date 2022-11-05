package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.number.LottoGenerator;
import study.lotto.domain.order.OrderType;
import study.message.LottoExceptionCode;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 추첨 기능 테스트")
class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = LottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 6), OrderType.AUTO);
    }

    @Test
    void 로또_숫자_갯수가_6개가_아니면_IllegalArgumentException_발생() {
        assertThatThrownBy(() -> {
            LottoGenerator.generate(Arrays.asList(1, 2, 3), OrderType.MANUAL);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.NOT_MATCH_LOTTO_SIZE.getMessage());
    }

    @Test
    void drawLots_낙첨() {
        assertEquals(LottoStatus.NONE, lotto.drawLots(new WinningLotto(("11, 22, 23, 33, 35, 45"))));
    }

    @Test
    void drawLots_5등_당첨() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 11, 23, 45");
        winningLotto.addBonusBall(18);

        assertEquals(LottoStatus.FIFTH_PLACE, lotto.drawLots(winningLotto));
    }

    @Test
    void drawLots_4등_당첨() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 23, 45");
        winningLotto.addBonusBall(18);

        assertEquals(LottoStatus.FOURTH_PLACE, lotto.drawLots(winningLotto));
    }

    @Test
    void drawLots_3등_당첨() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 23");
        winningLotto.addBonusBall(18);

        assertEquals(LottoStatus.THIRD_PLACE, lotto.drawLots(winningLotto));
    }

    @Test
    void drawLots_2등_당첨() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 23");
        winningLotto.addBonusBall(6);

        assertEquals(LottoStatus.SECOND_PLACE, lotto.drawLots(winningLotto));
    }

    @Test
    void drawLosts_1등_당첨() {
        assertEquals(LottoStatus.FIRST_PLACE,
                lotto.drawLots(new WinningLotto(("1, 2, 3, 4, 5, 6"))));
    }

    @ParameterizedTest
    @CsvSource(value = { "1:true", "8:false", "2:true", "45:false" }, delimiter = ':')
    void Lotto가_가진_LottoNumber_목록에_입력된_LottoNumber의_포함여부(int lottoNumber, boolean expected) {
        assertEquals(expected, lotto.contains(LottoGenerator.toLottoNumber(lottoNumber)));
    }

    @Test
    void orderType을_확인한다() {
        Lotto tempLotto = Store.buyLottoManually("1, 2, 3, 4, 5, 6");

        assertAll(
                () -> assertTrue(lotto.isAuto()),
                () -> assertFalse(lotto.isManual()),
                () -> assertFalse(tempLotto.isAuto()),
                () -> assertTrue(tempLotto.isManual())
        );
    }
}
