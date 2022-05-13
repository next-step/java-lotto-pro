package study;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void init() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set_Size_확인하기")
    public void checkSetSize() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set에저장된값확인")
    public void setContains(int isExist) {
        assertThat(numbers).contains(isExist);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:false", "3:true", "1:true", "5:false", "6:false",
        "2:true"}, delimiter = ':')
    @DisplayName("CsvSource를 통해 중복코드를 제거해보자")
    public void setContainsDualCheck(int input, Boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
