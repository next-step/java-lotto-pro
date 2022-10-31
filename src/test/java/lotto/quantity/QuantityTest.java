package lotto.quantity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class QuantityTest {


    @ParameterizedTest
    @ValueSource(strings = {"1","2"})
    void 로또_수동번호를_입력받은_수량만큼_생성한다(String input){
        LottoQuantity lottoQuantity = new LottoQuantity(input);
        assertThat(lottoQuantity.quantity()).isEqualTo(Integer.parseInt(input));
    }

    @Test
    void 로또_수동번호_입력시_문자가_포함된_경우_예외를_발생시킨다(){
        assertThatThrownBy(() -> new LottoQuantity("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_수동번호_입력시_음수인_경우_예외를_발생시킨다(){
        assertThatThrownBy(() -> new LottoQuantity("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}