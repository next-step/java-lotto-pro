package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    Set<Integer> numbers;

    @BeforeEach
    void beforeEach(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    @DisplayName("Set Collection 에 대한 학습테스트 요구사항 1 : set 길이 테스트")
    void sizeTest(){
        assertThat(numbers.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("Set Collection 에 대한 학습테스트 요구사항 2 : value 존재 확인 테스트")
    void containTestForResultTrue(int value){
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","5:false","6:false"}, delimiterString = ":")
    @DisplayName("Set Collection 에 대한 학습테스트 요구사항 3 : value 가 존재하는지 안하는지 확인 테스트")
    void containTest(int value, boolean result){
        assertThat(numbers.contains(value)).isEqualTo(result);
    }
}
