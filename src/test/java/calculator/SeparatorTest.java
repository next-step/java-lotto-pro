package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

class SeparatorTest {

    @ParameterizedTest(name = "기본 구분자 separate 메서드 테스트 성공 - " + DEFAULT_DISPLAY_NAME)
    @ValueSource(strings = { "1,2,3", "1:2:3", "1,2:3" })
    void separate(String operands) {
        //when:
        Separator separator = new Separator();
        List<Integer> separatedOperands = separator.separate(operands);
        //then:
        assertThat(separatedOperands).containsSequence(1, 2, 3);
    }

    @ParameterizedTest(name = "커스텀 구분자 separate 메서드 테스트 성공 - " + DEFAULT_DISPLAY_NAME)
    @ValueSource(strings = { "//!\\n1!2!3", "//@\\n1@2@3", "//#\\n1#2#3" })
    void separate(String operands) {
        //when:
        Separator separator = new Separator();
        List<Integer> separatedOperands = separator.separate(operands);
        //then:
        assertThat(separatedOperands).containsSequence(1, 2, 3);
    }
}
