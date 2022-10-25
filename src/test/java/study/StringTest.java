package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    @DisplayName("문자열분리 문자 2개 이상")
    public void 문자열_분리_문자_2개_이상() {
        // given //  when
        String[] result = "1,2".split(",");
        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열분리 문자 1개 이상")
    public void 문자열_분리_문자_1개() {
        // given //  when
        String[] result = "1,".split(",");
        // then
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("양끝 문자열 제거")
    public void 문자열_제거() {
        // given
        String str = "(1,2)";
        //  when
        str = str.substring(1, str.length() - 1);
        // then
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열에서 특정 위치 문자 가져오기")
    public void 문자열_특정_위치_문자_GET_테스트() {
        // given // when
        char chr = "1,2".charAt(1);
        // then
        assertThat(chr).isEqualTo(',');
    }

    @Test
    @DisplayName("문자열 OutOfBound의 index로 문자 가져올 때 에러 발생 테스트")
    public void CharAt메서드_OutOfBound_테스트() {
        // given // when // then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "1,2".charAt(4));
    }
}
