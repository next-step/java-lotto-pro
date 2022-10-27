package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @DisplayName("splitAndSum_쉼표구분자_파싱_성공")
    @Test
    public void splitAndSum_01() {
        String[] result = StringUtil.parseText("1,2");
        assertThat(result).isEqualTo(new String[]{"1", "2"});
    }

    @DisplayName("splitAndSum_쉼표_또는_콜론_구분자_파싱_성공")
    @Test
    public void splitAndSum_02() {
        String[] result = StringUtil.parseText("1,2:3");
        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }

    @DisplayName("splitAndSum_custom_구분자_파싱_성공")
    @Test
    public void splitAndSum_03() {
        String[] result = StringUtil.parseText("//;\n1;2;3");
        assertThat(result).isEqualTo(new String[]{"1", "2", "3"});
    }

    @DisplayName("splitAndSum_custom_구분자_없을경우_기본_구분자_파싱")
    @Test
    public void splitAndSum_04() {
        String[] result = StringUtil.parseText("//\n1:2:3");
        assertThat(result).isEqualTo(new String[]{"//\n1", "2", "3"});
    }

    @DisplayName("splitAndSum_custom_구분자_기본_구분자_모두_없을_때_파싱_안됨")
    @Test
    public void splitAndSum_05() {
        String[] result = StringUtil.parseText("//\n1;2;3");
        assertThat(result).isEqualTo(new String[]{"//\n1;2;3"});
    }
}
