package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private static final int SET_SIZE = 3;

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set Collection size 테스")
    public void sizeTest(){
        assertThat(numbers.size()).isEqualTo(SET_SIZE);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,true", "2,true", "3,true",
            "4,false","5,false"
    },delimiter = ',')
    @DisplayName("contains 검증")
    public void containsTest(int number, boolean result){
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

}
