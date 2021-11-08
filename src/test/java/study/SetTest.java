package study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName : study
 * fileName : SetTest
 * author : haedoang
 * date : 2021/11/01
 * description : Set 클래스 학습 테스트
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SetTest {
    private Set<Integer> numberSet;

    @BeforeEach
    void setUp() {
        this.numberSet = new HashSet<>();
        numberSet.add(1);
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);
    }

    //Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    @Test
    @Order(1)
    @DisplayName("요구사항1_size_메소드로_Set의_크기를_확인한다")
    public void setSizeTest() {
        //WHEN
        int result = numberSet.size();
        //THEN
        assertThat(result).isEqualTo(3);
    }

    //Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
    //구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
    //JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
    @Order(2)
    @DisplayName("요구사항2_contains_메소드로_값의_포함여부를_확인한다")
    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1})
    public void setContainsTest(int value) {
        //THEN
        assertThat(this.numberSet.contains(value)).isTrue();
    }

    //요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
    //예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
    @Order(3)
    @DisplayName("요구사항3_parameterizedTest2_실패_테스트_추가하기")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void setContainsTest2(int input, boolean result) {
        //THEN
        assertThat(this.numberSet.contains(input)).isEqualTo(result);
    }

}
