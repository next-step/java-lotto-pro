package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SplitFactoryTest {
    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        String[] result = SplitFactory.splitNumber("1,2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        String[] result = SplitFactory.splitNumber("1,2:3");
        assertThat(result).containsExactly("1","2","3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//a\n1a2a3a", "//#\n1#2#3"})
    public void splitAndSum_custom_구분자(String delimiter) throws Exception {
        String[] result = SplitFactory.splitNumber(delimiter);
        assertThat(result).containsExactly("1","2","3");
    }
}