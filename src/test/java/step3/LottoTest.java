package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.WinningLotto;
import step3.enums.Rank;

import java.util.Arrays;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void given() {
        LottoNumbers lottoNumbers = new LottoNumbers(
                Arrays.asList(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))
        );
        lotto = new Lotto(lottoNumbers);
    }

    @Test
    @DisplayName("로또 숫자는 1-45 사이의 숫자를 갖는다")
    void 로또_숫자_범위() {
        lotto.getLottoNumbers().getLottoNumbers().forEach(ball -> {
            Assertions.assertTrue(0 < ball.getLottoNumber() && ball.getLottoNumber() <= 45);
        });
    }

    @Test
    @DisplayName("로또 6자리 숫자를 자동으로 생성한다.")
    void 로또_자동번호_6자리() {
        Assertions.assertEquals(6, lotto.getLottoNumbers().getLottoNumbers().size());
    }


    @Test
    @DisplayName("5개 볼과 보너스 볼이 맞으면 2등이다.")
    void 매칭번호_5개_보너스_1개() {
        Rank rank = lotto.match(new WinningLotto(new LottoNumbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(7))), 6));
        Assertions.assertEquals(Rank.SECOND, rank);
    }

    @Test
    @DisplayName("5개 볼이 맞고 보너스 볼이 맞지 않으면 3등이다.")
    void 매칭번호_5개_보너스_0개() {
        Rank rank = lotto.match(new WinningLotto(new LottoNumbers(Arrays.asList(new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(7))), 8));
        Assertions.assertEquals(Rank.THIRD, rank);
    }

    @Test
    @DisplayName("4개 볼이 맞으면 4등이다.")
    void 매칭번호_4개_보너스_0개() {
        Rank rank = lotto.match(new WinningLotto(new LottoNumbers(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(8),
                new LottoNumber(7))), 6));
        Assertions.assertEquals(Rank.FOURTH, rank);
    }

}
