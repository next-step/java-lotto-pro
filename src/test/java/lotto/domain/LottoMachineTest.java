package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoMachineTest {

    static Stream<Arguments> listProvide() {
        List<Number> lottoNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3),
                Number.of(4), Number.of(5), Number.of(7));

        return Stream.of(arguments(lottoNumber));
    }

    @Test
    @DisplayName("입력 금액만큼 로또 생성")
    public void getLottoListTest() {
        Money money = new Money(5000);
        LottoMachine machine = new LottoMachine(money);

        int actualSize = machine.getLottoList().size();

        assertThat(actualSize).isEqualTo(5);
    }

    @ParameterizedTest
    @MethodSource("listProvide")
    @DisplayName("수동 금액만큼 로또 생성")
    public void getLottoListTest2(List<Number> lottoNumber) {
        Money money = new Money(1000);
        LottoMachine machine = new LottoMachine(money, Arrays.asList(lottoNumber));

        int actualSize = machine.getLottoList().size();

        assertThat(actualSize).isEqualTo(1);
    }

}