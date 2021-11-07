package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoMachineTest {

    static Stream<Arguments> getLottoListTest2() {
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6);

        return Stream.of(arguments(lottoNumber));
    }

    @Test
    @DisplayName("입력 금액만큼 로또 생성")
    public void getLottoListTest() {
        Money money = new Money(BigDecimal.valueOf(5000));
        LottoMachine machine = new LottoMachine();

        int actualSize = machine.getLottoList(money).size();

        assertThat(actualSize).isEqualTo(5);
    }

    @ParameterizedTest
    @MethodSource("getLottoListTest2")
    @DisplayName("수동 금액만큼 로또 생성")
    public void getLottoListTest2(List<Integer> lottoNumber) {
        Money money = new Money(BigDecimal.valueOf(1000));
        LottoMachine machine = new LottoMachine();

        int actualSize = machine.getLottoList(money, Arrays.asList(lottoNumber)).size();

        assertThat(actualSize).isEqualTo(1);
    }

}