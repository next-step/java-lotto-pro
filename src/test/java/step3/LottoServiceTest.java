package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.LottoService;
import step3.model.Lottos;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {


    @ParameterizedTest
    @CsvSource(value = {"1000:1", "6000:6", "5000:5", "12000:12"}, delimiter = ':')
    @DisplayName("로또를 구매하면 구매가격만큼 컬렉션에서 로또개수를 조회")
    void test_that_throw_exception_when_number_is_outofrange(int price,int count){
        //given
        Lottos lottos = new Lottos(new ArrayList());
        LottoService lottoService = new LottoService(price,lottos);

        //when
        lottoService.purchaseByAuto();

        //then
        assertThat(lottos.getNumbersOfLottos()).hasSize(count);

    }

}
