package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("Set 자료구조는 중복된 데이터를 제거하고, size()는 Collection 의 크기를 반환한다")
    @Test
    void sizeTest() throws Exception {
        //when
        int size = numbers.size();
        //then
        assertThat(size).isEqualTo(3);
    }
}