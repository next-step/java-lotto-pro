package study.lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.Lottos;

class LottoDrawTest {
    private Lotto lotto;
    private LottoNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Nested
    @DisplayName("추첨 생성 성공")
    class 생성_성공 {
        @BeforeEach
        void setUp() {
            bonusNumber = new LottoNumber(10);
        }

        @Test
        @DisplayName("당첨번호와 보너스 번호로 로또 추첨 클래스를 생성할 수 있어야 한다.")
        void 로또_추첨_생성() {
            assertThat(new LottoDraw(lotto, bonusNumber)).isNotNull();
        }
    }

    @Nested
    @DisplayName("로또 추첨 생성 실패")
    class 생성_실패 {
        @BeforeEach
        void setUp() {
            bonusNumber = new LottoNumber(1);
        }

        @Test
        @DisplayName("당첨번호와 보너스 번호는 중복될 수 없다.")
        void 로또_추첨_유효성_검사_실패() {
            assertThatThrownBy(() -> new LottoDraw(lotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("사용자 당첨번호 일치")
    class 사용자_당첨번호_일치 {
        private LottoDraw lottoDraw;

        @BeforeEach
        void setUp() {
            lottoDraw = new LottoDraw(lotto, new LottoNumber(10));
        }

        @Test
        void 다수의_로또_당첨확인() {
            Lottos lottos = getFixtures();
            DrawResult expected = getExpectedDrawResult();
            
            assertThat(lottoDraw.match(lottos)).isEqualTo(expected);
        }

        private Lottos getFixtures() {
            List<Lotto> lottoList = Arrays.asList(
                    Lotto.from(Arrays.asList(8, 21, 23, 41, 42, 43)),
                    Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 38)),
                    Lotto.from(Arrays.asList(7, 11, 16, 35, 36, 44)),
                    Lotto.from(Arrays.asList(13, 14, 16, 38, 42, 45)),
                    Lotto.from(Arrays.asList(1, 3, 5, 14, 22, 45)));
            return new Lottos(lottoList);
        }

        private DrawResult getExpectedDrawResult() {
            List<DivisionResult> divisionResultList = Arrays.asList(
                    new DivisionResult(Division.DIVISION_ONE, 0L),
                    new DivisionResult(Division.DIVISION_TWO, 0L),
                    new DivisionResult(Division.DIVISION_THREE, 1L),
                    new DivisionResult(Division.DIVISION_FOUR, 0L),
                    new DivisionResult(Division.DIVISION_FIVE, 1L));

            return new DrawResult(divisionResultList);
        }
    }
}
