package lotto.domain;

import lotto.ui.ConsoleMessage;
import lotto.ui.Input;
import lotto.ui.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

import static lotto.domain.RandomLottoGenerator.LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoGeneratorTest {

    @Test
    @DisplayName("1 ~ 45 숫자 6개로 구성된 숫자세트 랜덤 생성 작업이 정상적으로 동작한다.")
    public void constructor_auto() {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();

        List<Integer> lottoNumbers = lottoGenerator.create(null);

        assertThat(lottoNumbers).hasSize(LOTTO_NUMBER_COUNT);
        assertAll(
                () -> assertThat(lottoNumbers.get(0)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(1)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(2)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(3)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(4)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(5)).isBetween(1, 45)
        );
    }

    @Test
    @DisplayName("1 ~ 45 숫자 6개로 구성된 숫자세트 수동 생성 작업이 정상적으로 동작한다.")
    public void constructor_manual() {
        ManualLottoGenerator lottoGenerator = new ManualLottoGenerator();
        final InputView inputView = new InputView(createTestInput());

        Supplier<List<Integer>> supplier = inputView::inputManualLottoNumber;
        List<Integer> lottoNumbers = lottoGenerator.create(supplier);

        assertThat(lottoNumbers).hasSize(LOTTO_NUMBER_COUNT);
        assertAll(
                () -> assertThat(lottoNumbers.get(0)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(1)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(2)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(3)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(4)).isBetween(1, 45),
                () -> assertThat(lottoNumbers.get(5)).isBetween(1, 45)
        );
    }

    private Input createTestInput() {
        return new Input() {
            @Override
            public String nextLine() {
                return "1,2,3,4,5,6\n";
            }

            @Override
            public String nextLine(final ConsoleMessage message) {
                return null;
            }
        };
    }
}
