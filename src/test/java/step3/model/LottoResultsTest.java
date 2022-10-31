package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.constant.StringConstant;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultsTest {

    private LottoResults lottoResults;

    @BeforeEach
    public void setUp() {
        this.lottoResults = new LottoResults(Arrays.asList(
                new LottoResult(3, 1, 5000),
                new LottoResult(4, 0, 50000),
                new LottoResult(5, 0, 500000)));
    }

    @Test
    @DisplayName("count 사용할때 내부 리스트 갯수를 리턴")
    void whenCount_thenNumber() {
        LottoResults emptyLottoResults = new LottoResults(Collections.emptyList());

        assertThat(emptyLottoResults.count()).isZero();
        assertThat(this.lottoResults.count()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    @DisplayName("getResultByIndex 사용할때 정상적인 인덱스가 아닐경우 에러")
    void givenOutOfIndex_whenGetResultByIndex_thenThrow(int index) {
        assertThatThrownBy(() -> this.lottoResults.getResultByIndex(index))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("존재하지않습니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("getResultByIndex 사용할때 정상적인 인덱스인경우 lottoResult 리턴")
    void givenValidIndex_whenGetResultByIndex_thenLottoResult(int index) {
        LottoResult lottoResult = this.lottoResults.getResultByIndex(index);

        assertThat(lottoResult).isNotNull();
    }

    @ParameterizedTest
    @CsvSource(value = {"3,1,5000!4,3,50000!5,0,100000:155000", "3,0,5000!4,0,50000!5,0,100000:0"}, delimiter = ':')
    @DisplayName("getTotalMoney 사용할때 맞춘 갯수와 머니를 곱셈하여 총 상금을 리턴")
    void givenData_whenGetTotalMoney_thenRate(String text, double expectedTotalMoney) {
        LottoResults simpleLottoResults = new LottoResults();
        Arrays.stream(text.split("!")).forEach(arguments -> {
            String[] values = arguments.split(StringConstant.COMMA);
            int score = Integer.parseInt(values[0]);
            int matchedScoreCount = Integer.parseInt(values[1]);
            int money = Integer.parseInt(values[2]);
            simpleLottoResults.add(new LottoResult(score, matchedScoreCount, money));
        });

        assertThat(simpleLottoResults.getTotalMoney()).isEqualTo(expectedTotalMoney);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,5", "3000,1.66", "15000,0.33"})
    @DisplayName("showRate 사용할때 사용한 금액을 인자로 받을경우 수익률 리턴")
    void givenMoney_whenShowRate_thenRate(int money, double expectedRate) {
        double rate = this.lottoResults.showRate(money);

        assertThat(rate).isEqualTo(expectedRate);
    }
}