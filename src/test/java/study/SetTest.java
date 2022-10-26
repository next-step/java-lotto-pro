package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 검증")
    public void size(){
        //then
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 검증")
    public void contains(){
        //then
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
        assertThat(numbers.contains(4)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("ParameterizedTest를 활용해 중복 코드 제거 검증")
    public void containsUseValueSource(int given){
        //when&then
        assertThat(numbers).contains(given);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("1,2,3 값은 contains true 반환하고 4,5 값은 false 반환 검증")
    public void containsUseCvsSource(int given, boolean expected){
        //when&then
        assertThat(numbers.contains(given)).isEqualTo(expected);
    }

}
