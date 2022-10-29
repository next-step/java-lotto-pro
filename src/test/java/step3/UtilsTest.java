package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.utils.Utils;

class UtilsTest {

    private Utils utils = new Utils();

    @DisplayName("로또 구입금액에 따른 로또 개수 추출")
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "3000:3"}, delimiter = ':')
    void calculateLottoCount(int input, int expected) {
        Assertions.assertEquals(expected, utils.calculateLottoCount(input));
    }


}
