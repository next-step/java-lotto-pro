package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.utils.RandomUtils.createRandomNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {

    @Test
    @DisplayName("입력된 범위와 사이즈에 따라 랜덤 숫자 리스트를 생성한다.")
    void createRandomNumbers_랜덤숫자_리스트() {
        int from = 1, to = 10, size = 5;

        assertThat(createRandomNumbers(from, to, size))
                .hasSize(size)
                .hasOnlyElementsOfType(Integer.class)
                .isInstanceOf(List.class)
                .allSatisfy(number -> assertThat(number).isBetween(from, to));
    }
}