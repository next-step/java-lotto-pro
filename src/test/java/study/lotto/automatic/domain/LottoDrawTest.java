package study.lotto.automatic.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import study.lotto.automatic.domain.draw.Division;

class LottoDrawTest {
    @Test
    @DisplayName("당첨 번호를 자동으로 생성한다.")
    void 당첨_번호_생성() {
        LottoDraw lottoDraw = new LottoDraw(new AutomaticLottoGenerator());
        assertThat(lottoDraw).isNotNull();
    }

    @Nested
    @DisplayName("사용자 당첨번호")
    class 사용자_당첨번호 {
        LottoNumbers lottoNumbers;
        LottoDraw lottoDraw;

        @BeforeEach
        void setUp() {
            lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
            lottoDraw = new LottoDraw(lottoNumbers);
        }

        @Test
        @DisplayName("당첨 번호를 사용자가 생성한다.")
        void 당첨_번호_사용자_생성() {
            assertThat(lottoDraw).isNotNull().isEqualTo(new LottoDraw(lottoNumbers));
        }

        @Test
        @DisplayName("당첨번호가 3개 일치하면 4등이다.")
        void 당첨번호_3개_일치() {
            Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9)));
            assertThat(lottoDraw.match(lotto)).isEqualTo(Division.DIVISION_FOUR);
        }

        @Test
        @DisplayName("당첨번호가 4개 일치하면 3등이다.")
        void 당첨번호_4개_일치() {
            Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 6, 8, 9)));
            assertThat(lottoDraw.match(lotto)).isEqualTo(Division.DIVISION_THREE);
        }

        @Test
        @DisplayName("당첨번호가 5개 일치하면 2등이다.")
        void 당첨번호_5개_일치() {
            Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 5, 6, 9)));
            assertThat(lottoDraw.match(lotto)).isEqualTo(Division.DIVISION_TWO);
        }

        @Test
        @DisplayName("당첨번호가 6개 모두 일치하면 1등이다.")
        void 당첨번호_6개_일치() {
            Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
            assertThat(lottoDraw.match(lotto)).isEqualTo(Division.DIVISION_ONE);
        }
    }
}
