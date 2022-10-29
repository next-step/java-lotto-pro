package step3.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Numbers;

public class NumbersGeneratorTest {

    @Test
    @DisplayName("랜덤 번호 생성")
    public void testRandom() {
        Numbers lottoNumbers = NumbersGenerator.random();
        assertThat(lottoNumbers).isNotNull();
    }
}
