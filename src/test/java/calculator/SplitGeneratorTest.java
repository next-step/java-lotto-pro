package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitGeneratorTest {
    @Test
    @DisplayName("쉼포 또는 콜론으로 문자열을 분리하여 반환한다.")
    public void split_test() {
        assertAll(
                () -> assertThat(SplitGenerator.splitWithDelimiter("1:2")).containsExactly("1", "2"),
                () -> assertThat(SplitGenerator.splitWithDelimiter("1,2")).containsExactly("1", "2")
        );
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열을 분리하여 반환한다.")
    public void custom_delimiter_split_test() {
        assertThat(SplitGenerator.splitWithDelimiter("//;\n1;2;3")).containsExactly("1", "2", "3");
    }
}
