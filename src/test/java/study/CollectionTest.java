package study;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

public class CollectionTest {
    private static HashSet<Object> numbers;

    @BeforeAll
    static void beforeAll() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set Size 확인")
    public void set_size_test() {
        assertEquals(3, numbers.size());
    }

    @Test
    @DisplayName("Set Contains 확인")
    public void set_contains_test() {
        assertTrue(numbers.contains(1));
        assertTrue(numbers.contains(2));
        assertTrue(numbers.contains(3));
        assertFalse(numbers.contains(4));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("Parameterized 사용하여 Sec Contains 확인")
    public void set_parameterized_contains_test(String input) {
        assertTrue(numbers.contains(Integer.parseInt(input)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "5"})
    @DisplayName("Parameterized 사용하여  Set Contains 실패 확인")
    public void set_parameterized_contains_fail_test(String input) {
        assertFalse(numbers.contains(Integer.parseInt(input)));
        assertFalse(numbers.contains(Integer.parseInt(input)));
    }
}
