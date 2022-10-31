package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("구분자")
class DelimitersTest {

    @DisplayName("구분자 생성 시 기본 구분자를 포함한다.")
    @Test
    void constructor() {
        Delimiters delimiters = new Delimiters();
        assertThat(delimiters.getDelimiters()).containsExactly(":", ",");
    }

    @DisplayName("구분자를 추가한다.")
    @Test
    void add() {
        Delimiters delimiters = new Delimiters();
        delimiters.add(";");
        assertThat(delimiters.getDelimiters()).containsExactly(":", ";", ",");
    }
}
