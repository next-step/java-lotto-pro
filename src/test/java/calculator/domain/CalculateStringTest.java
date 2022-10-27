package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateStringTest {

    @Test
    @DisplayName("계산식이 null 인지 확인한다.")
    void isNullTest(){
        assertAll(
                () -> assertTrue(CalculateString.create(null).isNull(), "null 계산식 검증 실패"),
                () -> assertFalse(CalculateString.create("1;2;3").isNull(), "null 계산식이 아닌데 null 로 판단함")
        );
    }

    @Test
    @DisplayName("게산식이 비어있는지 확인한다.")
    void isEmptyTest(){
        assertAll(
                () -> assertTrue(CalculateString.create("").isEmpty(), "비어있는 계산식 검증 실패"),
                () -> assertFalse(CalculateString.create("1;2;3").isEmpty(), "비어있지 않은 계산식을 비어있다고 판단함")
        );
    }
}
