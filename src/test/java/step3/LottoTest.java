package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;

public class LottoTest {

    Lotto lotto = new Lotto();

    @Test
    void 자동번호_받기_테스트() {

        Assertions.assertEquals(6, lotto.gainAutoNumbers().size());
    }

    @Test
    @DisplayName("자동 로또 번호와 당첨 번호 비교 로직이지만, 자동 로또번호 자신과 비교하면 무조건 6이 나옴")
    void 당첨번호_비교() {
        lotto.match(lotto.gainAutoNumbers());
        Assertions.assertEquals(6, lotto.getMatchCount());
    }

    @Test
    @DisplayName("자동 로또 번호와 당첨 번호 비교 로직이지만, 자동 로또번호 자신과 비교하면 무조건 6이 나옴")
    void 로또_숫자_범위() {
        lotto.gainAutoNumbers().forEach(ball -> {
            Assertions.assertTrue(0 < ball && ball <= 45);
        });
    }

}
