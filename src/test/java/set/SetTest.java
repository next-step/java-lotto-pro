package set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인한다.")
    @Test
    public void setSize() {
        assertEquals(3, numbers.size());
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다.")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    public void setContains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3, 4, 5의 값이 존재하는지를 확인한다.")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @ParameterizedTest
    public void setContains_includeFail(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
