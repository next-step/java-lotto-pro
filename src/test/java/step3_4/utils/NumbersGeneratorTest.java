package step3_4.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3_4.domain.UniqueNumbers;

public class NumbersGeneratorTest {

    @Test
    @DisplayName("랜덤 번호 생성")
    public void testRandom() {
        UniqueNumbers lottoNumbers = NumbersGenerator.random();
        assertThat(lottoNumbers).isNotNull();
    }
}
