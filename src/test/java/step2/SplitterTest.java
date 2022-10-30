package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitterTest {

    @DisplayName("쉼표 구분자를 가진 문자열을 전달하면 쉼표 구분자로 분리되서 계산되는지 확인")
    @Test
    void comma_split() {
        SplitNumbers splitNumbers = Splitter.split("1,2");

        assertThat(splitNumbers.sum()).isEqualTo(3);
    }

    @DisplayName("쉼표, 콜론 구분자를 가진 문자열을 전달하면 쉼표, 콜론 구분자로 분리되서 계산되는지 확인")
    @Test
    void comma_or_colon_split() {
        SplitNumbers splitNumbers = Splitter.split("1,2:3");

        assertThat(splitNumbers.sum()).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자를 가진 문자열을 전달하면 커스텀 구분자로 분리되서 계산되는지 확인")
    @Test
    void custom_slpit() {
        SplitNumbers splitNumbers = Splitter.split("//;\n1;2;3");

        assertThat(splitNumbers.sum()).isEqualTo(6);
    }
}
