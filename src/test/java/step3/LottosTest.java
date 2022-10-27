package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또를 추가하면 생성된 로또번호를 조회할 수 있다")
    void test_that_throw_exception_when_number_is_outofrange(){
        //given
        Lottos lottos = new Lottos(new ArrayList());

        //when
        lottos.addByAuto();

        //then
        assertThat(lottos.getAllLottoNumbers()).hasSize(1);
        assertThat(lottos.getAllLottoNumbers().get(0)).hasSize(6);
        assertThat(lottos.getAllLottoNumbers().get(0)).hasSize(6);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    @DisplayName("로또를 추가하면 구매가격의 총합은 구매개수 * 1000")
    void test_that_it_returns_sum_of_price(int count){
        //given
        Lottos lottos = new Lottos(new ArrayList());

        //when
        for(int i = 0; i < count; i++) {
            lottos.addByAuto();
        }
        //then
        assertThat(lottos.getSumOfPriceLottos()).isEqualTo(count * 1000);

    }
}
