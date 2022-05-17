package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.model.LottoMachine.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoMachineTest {
    LottoMachine lottoMachine = new LottoMachine();

    @ParameterizedTest(name = "구매금액이 {0}이면 {1}만큼의 로또가 생성된 리스트를 반환한다.")
    @CsvSource(value = {"1000|1", "10000|10", "20000|20"}, delimiter = '|')
    void 로또_구매_test(int money, int result) {
        assertThat(lottoMachine.purchase(money)).hasSize(result);
    }

    @ParameterizedTest(name = "구매금액이 1000단위가 아닌 숫자 {0}을 입력하면 IllegalArgumentException을 발생시킨다.")
    @ValueSource(ints = {-5, 0, 1200})
    void 로또_구매_예외_test(int money) {
        assertThatThrownBy(() -> lottoMachine.purchase(money))
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("금액은 " + LOTTO_PRICE + "단위이어야 합니다.");
    }

    @MethodSource(value = "lottoManualTestParameters")
    @ParameterizedTest(name = "로또수동 구매수는 {2}개 이다")
    void 로또_수동구매_test(List<List<Integer>> manualLottos, int count) {
        //when
        lottoMachine.purchaseManual(manualLottos);

        //then
        assertThat(lottoMachine.getLottos()).hasSize(count);
    }

    @MethodSource(value = "lottoManualTestParameters")
    static Stream<Arguments> lottoManualTestParameters() {
        return Stream.of(
                arguments(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6)), 1),
                arguments(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(5, 6, 7, 8, 9, 10)), 2),
                arguments(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(5, 6, 7, 8, 9, 10),
                        Arrays.asList(11, 12, 13, 14, 15, 16)), 3)
        );
    }
}
