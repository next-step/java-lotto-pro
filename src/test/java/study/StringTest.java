package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("split 메서드를 호출한다.")
    void split1() {
        // when
        String[] values = "1,2".split(",");

        // then
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    @DisplayName("split 메서드를 단일 값으로 호출한다.")
    void split2() {
        // when
        String[] values = "1".split(",");

        // then
        assertThat(values).contains("1");
    }
}
