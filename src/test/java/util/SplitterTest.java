package util;

import domain.Numbers;
import domain.SafeString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplitterTest {
    @Test
    @DisplayName("입력 문자열을 split하면 숫자를 가지고 있는 일급 컬렉션을 반환함")
    void test1() {

        Numbers numbers = Splitter.split(SafeString.of("1,2"));

        assertThat(numbers.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("콤마와 콜론으로 이루어진 문자열도 split이 되어 3개의 원소를 가진 일급 컬렉션을 반환")
    void test2() {

        Numbers numbers = Splitter.split(SafeString.of("1,2:3"));

        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("custom delimiter 를 사용해도 3개의 숫자를 가진 일급 컬렉션을 반환함")
    void test3() {
        Numbers numbers = Splitter.split(SafeString.of("//;\n1;2;3"));

        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("custom delimiter와 기본 delimiter 를 사용해도 3개의 숫자를 가진 일급 컬렉션을 반환함")
    void test4() {
        Numbers numbers = Splitter.split(SafeString.of("//;\n1,2;3:4"));

        assertThat(numbers.size()).isEqualTo(4);
    }
}