package learning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("size() 메소드를 호출하면 set의 크기를 반환한다")
    @Test
    public void size() {
        // when and then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("numbers에 1, 2, 3의 값이 존재하는지 확인한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void contains(int input) {
        // when
        boolean contains = numbers.contains(input);
        // then
        assertThat(contains).isTrue();
    }

    @DisplayName("numbers에 입력한 값이 존재하는지 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void contains(int input, boolean flag) {
        // when
        boolean contains = numbers.contains(input);
        // then
        assertThat(contains).isEqualTo(flag);
    }

}
