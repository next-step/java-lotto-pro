package study.lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumbers;
import study.lotto.domain.Lottos;

class LottoDrawTest {
    @Nested
    @DisplayName("사용자 당첨번호 일치")
    class 사용자_당첨번호_일치 {
        LottoNumbers lottoNumbers;
        LottoDraw lottoDraw;

        @BeforeEach
        void setUp() {
            lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
            lottoDraw = new LottoDraw(lottoNumbers);
        }

        @Test
        void 다수의_로또_당첨확인() {
            List<Lotto> lottoList = Arrays.asList(
                    new Lotto(new LottoNumbers(Arrays.asList(8, 21, 23, 41, 42, 43))),
                    new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 38))),
                    new Lotto(new LottoNumbers(Arrays.asList(7, 11, 16, 35, 36, 44))),
                    new Lotto(new LottoNumbers(Arrays.asList(13, 14, 16, 38, 42, 45))),
                    new Lotto(new LottoNumbers(Arrays.asList(1, 3, 5, 14, 22, 45))));

            List<DivisionResult> divisionResultList = Arrays.asList(
                    new DivisionResult(Division.DIVISION_ONE, 0L),
                     new DivisionResult(Division.DIVISION_TWO, 1L),
                     new DivisionResult(Division.DIVISION_THREE, 0L),
                     new DivisionResult(Division.DIVISION_FOUR, 1L));

            DivisionResults divisionResults = new DivisionResults(divisionResultList);
            DrawResult expected = new DrawResult(divisionResults);

            DrawResult drawResult = lottoDraw.match(new Lottos(lottoList));
            assertThat(drawResult).isEqualTo(expected);
        }
    }
}
