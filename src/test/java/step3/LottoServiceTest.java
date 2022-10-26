package step3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    private LottoService lottoService = new LottoService();
    private View view = new View();


    @DisplayName("로또 구입금액에 따른 로또 개수 추출")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "3000:3"}, delimiter = ':')
    void calculateLottoCount(int input, int expected) {
        Assertions.assertEquals(expected, lottoService.calculateLottoCount(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void generateLottos(int input) {
        Assertions.assertEquals(input, lottoService.generateLottos(input).size());
    }

}