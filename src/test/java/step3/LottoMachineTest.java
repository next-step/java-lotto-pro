package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void setUp() {
        lottoMachine = new LottoMachine(1000, 10000);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,200", "100,500", "400,1000"})
    @DisplayName("로또 구매 돈과 로또 가격을 입력받을때 로또 가격보다 돈이 없을경우 에러")
    void givenLessMoney_whenConstructLottoMachine_thenThrow(int money, int lottoPrice) {
        assertThatThrownBy(() -> new LottoMachine(lottoPrice, money))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("부족");
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,1000,14", "16500,1000,16", "4000,1000,4"})
    @DisplayName("로또 구매 돈과 로또 가격을 입력받을때 로또 가격보다 돈이 클경우 구매한 로또 갯수를 리턴")
    void givenMoney_whenConstructLottoMachine_thenTicketCount(int money, int lottoPrice, int havingCount) {
        LottoMachine lottoMachine = new LottoMachine(lottoPrice);

        assertThat(lottoMachine.receiveMoney(money)).isEqualTo(havingCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"48123,12348", "9581,1589"})
    @DisplayName("무작위의 로또를 입력받을때 정렬된 로또 숫자를 리턴")
    void givenNumbers_whenAddLotto_thenSortedNumbers(String randomLotto, String expectedSortedLotto) {
        List<Integer> randomLottoNumber = Arrays.stream(randomLotto.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        String sortedLotto = lottoMachine.addLotto(randomLottoNumber).stream()
                .map(Object::toString)
                .collect(Collectors.joining());

        assertThat(sortedLotto).isEqualTo(expectedSortedLotto);
    }
}
