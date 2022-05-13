package stringaddcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitStringTest {

    @Test
    void 커스텀_구분자가_있으면_커스텀_구분자로_구분한다() {
        SplitString splitString = new SplitString("//;\n1;2;3");
        assertThat(splitString.getSplitString()).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자가_없으면_일반_구분자로_구분한다() {
        SplitString splitString = new SplitString("1,2,3");
        assertThat(splitString.getSplitString()).containsExactly("1", "2", "3");
    }
}
