package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomNumberUtilsTest {

    @DisplayName("랜덤 번호를 주어진 개수만큼 List 형태로 생성")
    @ParameterizedTest(name = "{0}~{1} 사이, {2}개")
    @CsvSource(value = {"1:45:6", "13:100:9", "7:77:10"}, delimiter = ':')
    void generateRandomNumberToList(int low, int max, int count) {
        List<Integer> randomNumberToList = RandomNumberUtils.generateRandomNumbers(low, max, count);

        assertThat(randomNumberToList).hasSize(count);
        for (int randomNumber : randomNumberToList) {
            assertThat(randomNumber).isGreaterThanOrEqualTo(low);
            assertThat(randomNumber).isLessThanOrEqualTo(max);
        }
    }


}
