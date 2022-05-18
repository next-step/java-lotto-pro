package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoQuantity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"5000:6", "0:1", "3000:4"}, delimiter = ':')
    void 수동_구매량은_돈을_넘길수_없다(int money, int manualQuantity) {
        assertThatThrownBy(() -> {
            LottoMachine machine = new LottoMachine(5000);
            LottoGame.getAutomaticQuantity(machine, new LottoQuantity(6));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
