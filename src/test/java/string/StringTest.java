package string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @Test
    @DisplayName("2개 이상의 값으로 split 메소드를 호출 했을 때 잘 분리되는지 확인")
    void split1() {
        // when
        String[] results = "1,2".split(",");

        // then
        assertThat(results).contains("1", "2");
    }

    @Test
    @DisplayName("단일 값으로 split 메소드를 호출 했을 때 단일 값만을 포함하는 배열이 잘 반환되는지 확인")
    void split2() {
        // when
        String[] results = "1".split(",");

        // then
        assertThat(results).containsExactly("1");
    }

    @Test
    @DisplayName("(a,b) 값으로 substring 메소드를 호출 했을 때 ()을 제거하고 a,b가 반환되는지 확인)")
    void substring() {
        // when
        String results = "(1,2)".substring(1, 4);

        // then
        assertThat(results).isEqualTo("1,2");
    }
}