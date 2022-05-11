package camp.nextstep.edu.until;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StringParserTest {

    @DisplayName("문자열 파싱 시 기본 구분자(:,)로 구분되어 정상적으로 구분되어야 한다")
    @Test
    void defaultParserTest() {
        String target = "a:b,c:d";

        List<String> result = StringParser.parseAndSplit(target);

        assertThat(result.size()).isEqualTo(4);
        for (String s: result) {
            assertThat(s).doesNotContain(":");
            assertThat(s).doesNotContain(",");
        }
    }

    @DisplayName("//XXX\n 형태의 문자가 시작되면 XXX 가 구분자로 문자가 정상적으로 구분되어야 한다")
    @Test
    void specialSeparatorParserTest() {
        String specialSeparator = "//#*^&\n";
        String target = specialSeparator + "3#*^&4#*^&abc";

        List<String> result = StringParser.parseAndSplit(target);

        assertThat(result.size()).isEqualTo(3);
        for (String s: result) {
            assertThat(s).doesNotContain(specialSeparator);
        }
    }

    @DisplayName("특수 구분자를 포함하고 있으나, 시작점에 없을 경우 예외가 발생해야 한다")
    @Test
    void somewhereOtherThanStartingSpecialSeparatorParserTest() {
        String specialSeparator = "//#\n";
        String target = "a" + specialSeparator + "3#4#abc";

        assertThatThrownBy(() -> StringParser.parseAndSplit(target)).isInstanceOf(RuntimeException.class);
    }
}
