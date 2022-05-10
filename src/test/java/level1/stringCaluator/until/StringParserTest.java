package level1.stringCaluator.until;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    @DisplayName("문자열 파싱 시 기본 구분자(:,)로 구분되어 정상적으로 구분되어야 한다")
    @Test
    void defaultParserTest() {
        String target = "a:b,c:d";

        String[] result = StringParser.parseAndSplit(target);

        assertThat(result.length).isEqualTo(4);
        for (String s: result) {
            assertThat(s).doesNotContain(":");
            assertThat(s).doesNotContain(",");
        }
    }

    @DisplayName("//XXX\n 형태의 문자가 시작되면 XXX 가 구분자로 문자가 정상적으로 구분되어야 한다")
    @Test
    void specialSeparatorParserTest() {
        String specialSeparator = "//#\n";
        String target = specialSeparator + "3#4#abc";

        String[] result = StringParser.parseAndSplit(target);

        assertThat(result.length).isEqualTo(3);
        for (String s: result) {
            assertThat(s).doesNotContain(specialSeparator);
        }
    }
}
