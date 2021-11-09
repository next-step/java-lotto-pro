package lotto.domain;

import lotto.constant.LottoRank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    private static WinningLotto winningLotto;

    @BeforeAll
    static void beforeAll() {
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        Lotto winningLottoNumber = new Lotto(winningNumbers);
        LottoNumber bonusNumber = new LottoNumber(7);
        winningLotto = new WinningLotto(winningLottoNumber, bonusNumber);
    }

    @Test
    @DisplayName("로또 결과 확인 - 1등")
    void 로또_결과_확인_1등() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 6};
        Lotto lotto = new Lotto(numbers);

        // when
        LottoRank lottoRank = winningLotto.checkMatchRank(lotto);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("로또 결과 확인 - 2등")
    void 로또_결과_확인_2등() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 7};
        Lotto lotto = new Lotto(numbers);

        // when
        LottoRank lottoRank = winningLotto.checkMatchRank(lotto);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("로또 결과 확인 - 3등")
    void 로또_결과_확인_3등() {
        // given
        int[] numbers = {1, 2, 3, 4, 5, 8};
        Lotto lotto = new Lotto(numbers);

        // when
        LottoRank lottoRank = winningLotto.checkMatchRank(lotto);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("로또 결과 확인 - 4등")
    void 로또_결과_확인_4등() {
        // given
        int[] numbers = {1, 2, 3, 4, 7, 8};
        Lotto lotto = new Lotto(numbers);

        // when
        LottoRank lottoRank = winningLotto.checkMatchRank(lotto);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("로또 결과 확인 - 5등")
    void 로또_결과_확인_5등() {
        // given
        int[] numbers = {1, 2, 3, 7, 8, 9};
        Lotto lotto = new Lotto(numbers);

        // when
        LottoRank lottoRank = winningLotto.checkMatchRank(lotto);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("로또 결과 확인 - 당첨안됨")
    void 로또_결과_확인_당첨안됨() {
        // given
        int[] numbers = {1, 2, 7, 8, 9, 10};
        Lotto lotto = new Lotto(numbers);

        // when
        LottoRank lottoRank = winningLotto.checkMatchRank(lotto);

        // then
        assertThat(lottoRank)
                .isEqualTo(LottoRank.NONE);
    }
}