package lotto.domain;

import lotto.domain.AutoLottoPrinter;
import lotto.domain.CollectionsShuffler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoPrinterTest {

    @DisplayName("입력된 숫자만큼 로또 번호를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 100, 1000})
    void testPrintLottos(int count) {
        AutoLottoPrinter printer = new AutoLottoPrinter(new CollectionsShuffler());
        assertThat(printer.print(count)).hasSize(count);
    }
}
