package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void 괄호제거(){
        String result = "(1,2)".replaceAll("\\(","");
        result=result.replaceAll("\\)","");
        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("charAt()로 특정 위치의 문자를 가져오는 학습 테스트 구현")
    void 특정위치문자테스트(){
        String str = "abc";
        assertThat(str.charAt(1)).isSameAs('b');

    }

    @Test
    @DisplayName("charAt()로 특정 위치의 문자를 가져오는 학습 테스트 구현 - 자리수 예외처리 테스트")
    void 특정위치문자테스트_예외처리(){
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(-1))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("위치를 잘못 입력하셨습니다.");

    }
}
