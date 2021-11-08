package step1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("학습테스트 - String")
public class StringTest {

    private final static String DELIMITER = ",";

    @Test
    @DisplayName("1,2을 `,`로 split 했을 때 1과 2로 잘 분리되는가?")
    void _1과2를_콤마로_split_했을_때_1과_2로_분리되는가() {
        //given
        final String csv = "1,2";

        //when
        final String[] dividedValues = csv.split(DELIMITER);

        //then
        assertThat(dividedValues)
            .as("`,`로 split 했을 때 1과 2로 잘 분리 되는가?")
            .contains("1", "2");
    }

    @Test
    @DisplayName("1을 `,`로 split 했을 때 1만을 포함하는 배열을 반환하는가?")
    void _1을_콤마로_split_했을_때_1만_포함하는_배열이_반환되는가() {
        //given
        final String csv = "1";

        //when
        final String[] dividedValues = csv.split(DELIMITER);

        //then
        assertThat(dividedValues)
            .as("`,`로 split 했을 때 1만 포함하는가?")
            .containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)값이 주어졌을 때 1,2을 반환하는가?")
    void 소괄호가_포함_된_CSV값에서_소괄호를_제외_한_플레인한_CSV를_반환하는가() {
        //given
        final String csv = "(1,2)";
        final int beginIndex = 1;
        final int endIndex = csv.length() - 1;

        //when
        final String substring = csv.substring(beginIndex, endIndex);

        //then
        assertThat(substring)
            .as("`()`을 제거하고 1,2를 반환하는가?")
            .isEqualTo("1,2");
    }

}
