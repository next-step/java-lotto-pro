package camp.nextstep.edu.until;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CollectionHelperTest {

    @Test
    void 문자열_숫자_배열을_숫자_리스트로_변경_시_정상_동작해야_한다() {
        String[] source = new String[]{"1", "2", "3", "4"};
        List<Integer> dist = CollectionHelper.arrayStringToIntegerList(source);

        for (int i = 0; i < source.length; i++) {
            assertThat(Integer.parseInt(source[i])).isEqualTo(dist.get(i));
        }
    }

    @Test
    void 문자열_숫자가_아닌_배열을_숫자_리스트로_변경_시_예외가_발생해야_한다() {
        String[] source = new String[]{"1", "a", "!@#", "가"};

        assertThatIllegalArgumentException().isThrownBy(() -> CollectionHelper.arrayStringToIntegerList(source));
    }
}