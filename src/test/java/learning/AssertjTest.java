package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class AssertjTest {


    @DisplayName("Iterable 가능한 인스턴스는 hasSize() 메서드를 통해 size를 비교할 수 있다")
    @Test
    void hasSize() {
        // when and then
        assertThat(Arrays.asList(1, 2)).hasSize(2);
    }
}
