package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TextFactoryTest {

    @Test
    @DisplayName("입력 패턴에 따른 클래스 생성 테스트")
    void createText () {
        assertThat(TextFactory.createText("1,2,3")).isInstanceOf(Text.class);
        assertThat(TextFactory.createText("//;\n1;2;3")).isInstanceOf(CustomedText.class);
    }

}