package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.Lotto;
import step3.model.LottoFactory;
import step3.model.LottoMoney;
import step3.model.LottoNumber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    @ParameterizedTest
    @CsvSource(value = {"12000:9", "13000:10", "4000:1"}, delimiter = ':')
    @DisplayName("입력한 돈만큼 자동로또개수를 반환")
    void test_that_returns_size_of_money(int money,int count){
        //given,when
        List<Lotto> lottos = LottoFactory.createLottosByAuto(new LottoMoney(money,3));

        //then
        assertThat(lottos).hasSize(count);
    }

    @Test
    @DisplayName("입력한 숫자를 가지는 로또를 반환")
    void test_that_returns_lotto_at_input_number(){
        List<String> numbers = new ArrayList<>();
        numbers.add("25,6,17,8,19,10");

        //given,when
        List<Lotto> lottos = LottoFactory.createLottosByManual(numbers);

        //then
        assertThat(lottos.get(0).getNumbers())
                .containsExactly(
                        LottoNumber.valueOf(25),
                        LottoNumber.valueOf(6),
                        LottoNumber.valueOf(17),
                        LottoNumber.valueOf(8),
                        LottoNumber.valueOf(19),
                        LottoNumber.valueOf(10));
    }

    @Test
    @DisplayName("입력한 숫자만큼를 가지는 로또개수를 반환")
    void test_that_returns_lotto_size_at_input_number_size(){
        List<String> numbers = new ArrayList<>();
        numbers.add("25,6,17,8,19,10");
        numbers.add("1,6,2,8,9,10");

        //given,when
        List<Lotto> lottos = LottoFactory.createLottosByManual(numbers);

        //then
        assertThat(lottos).hasSize(2);
    }
}
