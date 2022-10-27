package step3;

import java.util.ArrayList;
import java.util.Arrays;
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
        lotto.match(lotto.gainAutoNumbers(), 1);
        Assertions.assertEquals(6, lotto.getMatchCount());
    }

    @Test
    @DisplayName("자동 로또 번호와 당첨 번호 비교 로직이지만, 자동 로또번호 자신과 비교하면 무조건 6이 나옴")
    void 보너스볼_일치() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lotto.match(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)), 6);
        Assertions.assertTrue(lotto.hasBonusNumber());
    }

    @Test
    @DisplayName("자동 로또 번호와 당첨 번호 비교 로직이지만, 자동 로또번호 자신과 비교하면 무조건 6이 나옴")
    void 로또_숫자_범위() {
        lotto.gainAutoNumbers().forEach(ball -> {
            Assertions.assertTrue(0 < ball && ball <= 45);
        });
    }

}
