package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private LottoMachine lottoMachine;
    private List<List<Integer>> lottos;
    private List<LottoResult> lottoResults;

    @BeforeEach
    public void setUp() {
        lottoMachine = new LottoMachine();

        lottos = new ArrayList<>();
        lottos.add(Arrays.asList(1,2,3,4,5,6));
        lottos.add(Arrays.asList(11,12,13,14,15,16));
        lottos.add(Arrays.asList(1,12,15,17,18,20));

        lottoResults = new ArrayList<>();
        lottoResults.add(new LottoResult(3, 1, 1000));
        lottoResults.add(new LottoResult(4, 0, 2000));
        lottoResults.add(new LottoResult(5, 0, 3000));
        lottoResults.add(new LottoResult(6, 0, 4000));
    }

    @ParameterizedTest
    @ValueSource(ints = {300, 500, 700})
    @DisplayName("로또 구매 돈과 로또 가격을 입력받을때 로또 가격보다 돈이 없을경우 에러")
    void givenLessMoney_whenGetBoughtLottoCount_thenThrow(int money) {
        assertThatThrownBy(() -> lottoMachine.getBoughtLottoCount(money))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("부족");
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,14", "16500,16", "4000,4"})
    @DisplayName("로또 구매 돈과 로또 가격을 입력받을때 로또 가격보다 돈이 클경우 구매한 로또 갯수를 리턴")
    void givenMoney_whenConstructLottoMachine_thenTicketCount(int money, int havingCount) {
        assertThat(lottoMachine.getBoughtLottoCount(money)).isEqualTo(havingCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,4", "5,5"})
    @DisplayName("무작위의 로또를 입력받을때 정렬된 로또 숫자를 리턴")
    void givenNumbers_whenAddLotto_thenSortedNumbers(int needCount, int expectedCount) {
        List<List<Integer>> lottos = lottoMachine.generateLotto(needCount);

        assertThat(lottos).hasSize(expectedCount);
    }

    @Test
    @DisplayName("receiveLuckLotto를 호출할때 널 리스트가 들어올경우 에러")
    void givenNullNumbers_whenReceiveLuckLotto_thenThrow() {
        assertThatThrownBy(() -> lottoMachine.getResultComparedToLuckyNumbers(null, lottos))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("receiveLuckLotto를 호출할때 증복된 수들이 들어올떄 에러")
    void givenDuplicatedNumbers_whenReceiveLuckLotto_thenThrow() {
        assertThatThrownBy(() -> lottoMachine.getResultComparedToLuckyNumbers("1, 1, 3, 5, 6, 8", lottos))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("receiveLuckLotto를 호출할때 초과된 수들이 들어올떄 에러")
    void givenExceedNumbers_whenReceiveLuckLotto_thenThrow() {
        assertThatThrownBy(() -> lottoMachine.getResultComparedToLuckyNumbers("86, 1, 3, 5, 6, 8", lottos))
                .isInstanceOf(RuntimeException.class);
    }
}
