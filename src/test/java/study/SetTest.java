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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size()메소드를 활용해 Set의 크기를 확인")
    public void setSizeTest(){
        //given
        final int given = numbers.size();
        final int expected = 3;

        //when & then
        assertThat(given).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("Set의 contains() 메소드 활용해 1,2,3의 값이 존재하는지 확인")
    public void setContainsTest(int givenNumber){
        //when & then
        assertTrue(numbers.contains(givenNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("1,2,3 값은 contains true 반환하고 4,5 값은 false 반환되는 테스트")
    public void setContainsUsingCsvSourcse(int givenNumber, boolean expected){
        //when & then
        assertEquals(numbers.contains(givenNumber), expected);
    }
}
