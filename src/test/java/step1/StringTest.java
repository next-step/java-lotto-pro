package step1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    private static final String SPLIT_REGEX = ",";

    @DisplayName("\"1,2\"를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트_contains")
    @Test
    public void splitTest_contains() {
        // given
        String input = "1,2";
        String[] expected = {"1", "2"};

        // when
        String[] actual = input.split(SPLIT_REGEX);

        // then
        assertThat(actual).contains(expected);    // 순서 상관 없음
    }

    @DisplayName("\"1,2\"를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트_containsExactly")
    @Test
    public void splitTest_containsExactly() {
        // given
        String input = "1,2";
        String[] expected = {"1", "2"};

        // when
        String[] actual = input.split(SPLIT_REGEX);

        // then
        assertThat(actual).containsExactly(expected);    // containsExactly : 순서 상관 있음
    }

    @DisplayName("\"1,2\"를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트_containsExactlyInAnyOrder")
    @Test
    public void splitTest_containsExactlyInAnyOrder() {
        // given
        String input = "1,2";
        String[] expected = {"2", "1"};

        // when
        String[] actual = input.split(SPLIT_REGEX);

        // then
        assertThat(actual).containsExactlyInAnyOrder(expected);    // containsExactlyInAnyOrder : 순서 상관 없음
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트_contains")
    @Test
    public void splitTest2_contains() {
        // given
        String input = "1";
        String[] expected = {"1"};

        // when
        String[] actual = input.split(SPLIT_REGEX);

        // then
        assertThat(actual).contains(expected);
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트_containsExactly")
    @Test
    public void splitTest2_containsExactly() {
        // given
        String input = "1";
        String[] expected = {"1"};

        // when
        String[] actual = input.split(SPLIT_REGEX);

        // then
        assertThat(actual).containsExactly(expected);
    }
}