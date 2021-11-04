import org.assertj.core.internal.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void getSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    //https://www.baeldung.com/parameterized-tests-junit-5 참고
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3}) // six numbers
    public void containsTrue(int number) {
        assertTrue(numbers.contains(number));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void containsTrueFalse(int number, boolean expectResult){
        assertEquals(numbers.contains(number), expectResult);
    }


}
