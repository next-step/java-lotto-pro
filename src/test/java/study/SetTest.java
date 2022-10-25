package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SetTest {

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
    @DisplayName("size메소드는 Set의 원소개수를 리턴")
    void returns_size_of_set(){
        assertThat(numbers.size()).isEqualTo(3);
    }


    @Nested
    @DisplayName("contains메소드는")
    class Contains {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("Set이 원소를 포함하면 true를 리턴")
        void returns_true_if_set_contains_elements(int number){
            assertThat(numbers.contains(number)).isTrue();
        }

        @ParameterizedTest
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        @DisplayName("Set이 원소를 포함하는지 여부를 리턴")
        void returns_whether_set_contains_elements(int number,boolean isContains){
            assertThat(numbers.contains(number)).isEqualTo(isContains);
        }

    }


}
