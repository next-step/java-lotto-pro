package lotto.controller;

import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoCountTest {

    @Test
    void 생성자의_인수로_넘어온_값이_숫자_형식이_아닐_경우_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() ->
            new LottoCount("A")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void count만큼_로또를_생성한다() {
        // given
        LottoCount lottoCount = new LottoCount(3);
        // when
        Lottos result = lottoCount.generateLottos(new LottoNumberGenerator());
        // then
        assertThat(result.count()).isEqualTo(3);
    }
}