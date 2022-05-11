package camp.nextstep.edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest  {

    @DisplayName("String 의 split 를 이용 하여 분리 작업")
    @Test
    void splitTest() {
        final String[] splittingStrArray = "1,2".split(",");
        assertThat(splittingStrArray).hasSize(2)
                .contains("1","2").containsExactly("1","2");

        final String[] splittingCommaFreeStrArray = "1".split(",");
        assertThat(splittingCommaFreeStrArray).hasSize(1).contains("1");
    }
}
