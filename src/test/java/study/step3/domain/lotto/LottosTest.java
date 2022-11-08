package study.step3.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.domain.lottostatistics.LottoRankCountCache;
import study.step3.domain.utils.LottoNumbersGenerator;
import study.step3.domain.utils.LottosGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = LottosGenerator.createLottos(Arrays.asList(
                new int[]{1, 2, 3, 4, 5, 8},
                new int[]{1, 2, 3, 4, 5, 9},
                new int[]{1, 2, 3, 4, 5, 13},
                new int[]{1, 2, 3, 4, 12, 13},
                new int[]{1, 2, 3, 11, 12, 13}
        ));
    }

    @Test
    @DisplayName("당첨 번호와 보너스볼 번호를 비교하여 당첨 등수별 개수가 담긴 결과를 반환한다")
    void match_winning_numbers_and_bonus_number_test() {
        LottoNumbers winningNumbers = LottoNumbersGenerator.createLottoNumbers(1, 2, 3, 4, 5, 8);
        LottoNumber bonusNumber = LottoNumber.of(9);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);

        LottoRankCountCache lottoRankCountCache = lottos.matchAll(winningLotto);

        assertAll(
            () -> assertThat(lottoRankCountCache.count(LottoRank.FIRST_PLACE)).isEqualTo(1),
            () -> assertThat(lottoRankCountCache.count(LottoRank.SECOND_PLACE)).isEqualTo(1),
            () -> assertThat(lottoRankCountCache.count(LottoRank.THIRD_PLACE)).isEqualTo(1),
            () -> assertThat(lottoRankCountCache.count(LottoRank.FOURTH_PLACE)).isEqualTo(1),
            () -> assertThat(lottoRankCountCache.count(LottoRank.FIFTH_PLACE)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("로또 번호 컬렉션이 가진 로또 번호를 모두 출력한다")
    void report_lottos_test() {
        String lottoReport = lottos.report();
        assertThat(lottoReport)
                .contains("[1, 2, 3, 4, 5, 8]")
                .contains("[1, 2, 3, 4, 5, 9]")
                .contains("[1, 2, 3, 4, 5, 13]")
                .contains("[1, 2, 3, 4, 12, 13]")
                .contains("[1, 2, 3, 11, 12, 13]");
    }

    @Test
    @DisplayName("주어진 다수의 로또를 추가한다")
    void add_lottos_test() {
        Lottos otherLottos = LottosGenerator.createLottos(Arrays.asList(
                new int[]{3, 4, 5, 6, 7, 8},
                new int[]{8, 9, 11, 13, 15, 17}
        ));

        lottos.addLottos(otherLottos);

        assertThat(lottos.size()).isEqualTo(7);
    }
}
