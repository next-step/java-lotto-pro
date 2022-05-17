package lotto.domain;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.DecimalFormat;
import java.util.Collections;

import static lotto.common.Messages.MONEY_NOT_NUMBER;
import static lotto.common.Messages.POSITIVE_MONEY;
import static lotto.domain.LottoResult.isCriterionRate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"14000"})
    void 정상적인_금액_입금(String string) {
        // given
        Money money = new Money(string);

        // when
        int currentMoney = money.currentMoney();

        // then
        assertThat(currentMoney).isEqualTo(14000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1300"})
    void 음수인_금액_입금(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(string))
                .withMessageContaining(POSITIVE_MONEY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdf"})
    void 문자열_형태의_숫자가_아닌_금액_입금(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(string))
                .withMessageContaining(MONEY_NOT_NUMBER);
    }

    @Test
    void 로또_수익률_계산() {
        // given
        Money money = new Money("10000");
        LottoRanks lottoRanks = new LottoRanks(Collections.singletonList(
                LottoRank.THIRD
        ));

        // when
        double earningsRate = money.lottoGameEarningsRate(lottoRanks);

        // then
        assertThat(earningsRate).isEqualTo(5.0);
    }

    @Test
    void 로또_수익률_계산2() {
        // given
        Money money = new Money("14000");
        LottoRanks lottoRanks = new LottoRanks(Collections.singletonList(
                LottoRank.FOURTH
        ));

        // when
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double earningsRate = money.lottoGameEarningsRate(lottoRanks);

        // then
        assertThat(decimalFormat.format(earningsRate)).isEqualTo("0.36");
    }

    @Test
    void 로또_수익률_기준을_초과() {
        // given
        Money money = new Money("14000");
        LottoRanks lottoRanks = new LottoRanks(Collections.singletonList(
                LottoRank.FOURTH
        ));

        double earningsRate = money.lottoGameEarningsRate(lottoRanks);
        assertThat(isCriterionRate(earningsRate)).isFalse();
    }

    @Test
    void 로또_수익률_기준에_미만() {
        // given
        Money money = new Money("1000");
        LottoRanks lottoRanks = new LottoRanks(Collections.singletonList(
                LottoRank.FOURTH
        ));

        double earningsRate = money.lottoGameEarningsRate(lottoRanks);
        assertThat(isCriterionRate(earningsRate)).isTrue();
    }
}
