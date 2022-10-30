package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoCalculatorTest {
    private LottoCalculator lottoCalculator = new LottoCalculator();

    @BeforeEach
    void setUp() {
        lottoCalculator = new LottoCalculator(testLastWeek());
    }

    @Test
    @DisplayName("지난주 우승 번호 유효성 테스트")
    void 지난주_우승_번호_유효성_테스트() {
        assertThatThrownBy(() -> lottoCalculator.validateLastWeekWinner("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수익률_테스트")
    @ParameterizedTest
    @CsvSource(value = {"8-21-23-41-42-43," +
            "3-5-11-16-32-38," +
            "7-11-16-35-36-44," +
            "1-8-11-31-41-42," +
            "13-14-16-38-42-45," +
            "7-11-30-40-42-43," +
            "2-13-22-32-38-45," +
            "23-25-33-36-39-41," +
            "1-3-5-14-22-45," +
            "5-9-38-41-43-44," +
            "2-8-9-18-19-21," +
            "13-14-18-21-23-35," +
            "17-21-29-37-42-45," +
            "3-8-27-30-35-44" +
            ":0.35"}, delimiter = ':')
    void 수익률_테스트(String input, String expected) {
        String[] inputArr = input.split(":")[0].split(",");
        Lottos lottos = new Lottos(createTestLottos(inputArr));

        lottoCalculator.calculateWinnerStatistics(lottos);
        double result = lottoCalculator.calculateProfitRate();
        assertEquals(expected, Double.toString(result));
    }

    @DisplayName("수익률_이득_테스트")
    @ParameterizedTest
    @CsvSource(value = {"1-2-3-4-5-6:2000000.0", "1-2-3-4-9-10,1-2-3-10-11-23:27.5"}, delimiter = ':')
    void 수익률_이득_테스트(String input, String expected) {
        String[] inputArr = input.split(":")[0].split(",");
        Lottos lottos = new Lottos(createTestLottos(inputArr));

        lottoCalculator.calculateWinnerStatistics(lottos);
        double result = lottoCalculator.calculateProfitRate();
        assertEquals(expected, Double.toString(result));
    }

    private List<Lotto> createTestLottos(String[] inputArr) {
        List<Lotto> testLottos = new ArrayList<>();
        for (String lottoNumbers : inputArr) {
            makeTestLottos(testLottos, lottoNumbers);
        }
        return testLottos;
    }

    private List<Lotto> makeTestLottos(List<Lotto> lottos, String lottoNumbers) {
        lottos.add(new Lotto(lottoNumbers.split("-")));
        return lottos;
    }

    private List<LottoNumber> testLastWeek() {
        List<LottoNumber> result = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            result.add(new LottoNumber(i));
        }
        return result;
    }
}
