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

    @Test
    void 로또_카운트가_음수일_경우_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() ->
                new LottoCount(-1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_카운트를_인자로_받아_마이너스를_한다() {
        // given
        LottoCount lottoCount = new LottoCount(5);
        LottoCount minus = new LottoCount(2);
        // when
        LottoCount result = lottoCount.minus(minus);
        // then
        assertThat(result.count()).isEqualTo(3);
    }
}