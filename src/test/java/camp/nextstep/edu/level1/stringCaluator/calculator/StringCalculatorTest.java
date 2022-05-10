package camp.nextstep.edu.level1.stringCaluator.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void 특수_구분자가_없는_문자열을_이용하여_계산하면_정상_계산되어야_한다() {
        String input = "1:2,3,4:5";

        StringCalculator calculator = new StringCalculator(input);

        assertThat(calculator.sum()).isEqualTo(15);
    }

    @Test
    void 특정_구분자를_포함한_문자열을_문자열_계산기에_입력하면_정상_계산되어야_한다() {
        String input = "//$^\n1$^7$^3$^10$^100";

        StringCalculator calculator = new StringCalculator(input);

        assertThat(calculator.sum()).isEqualTo(121);
    }

    @Test
    void 문자열_계산기에_null_또는_빈_문자열을_입력_할_경우_계산_결과가_0_이어야_한다() {
        String inputEmpty = "";
        String inputNull = null;

        StringCalculator emptyCalculator = new StringCalculator(inputEmpty);
        StringCalculator nullCalculator = new StringCalculator(inputNull);

        assertThat(emptyCalculator.sum()).isEqualTo(0);
        assertThat(nullCalculator.sum()).isEqualTo(0);
    }

    @Test
    void 음수가_포함된_문자열을_문자열_계산기에_입력하면_예외가_발생해야_한다() {
        String inputDefault = "1:2,-10:3,-7";
        String inputSpecialDelimiter = "//&!\n1&!-7&!10";

        assertThatThrownBy(() -> new StringCalculator(inputDefault)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new StringCalculator(inputSpecialDelimiter)).isInstanceOf(RuntimeException.class);
    }
}