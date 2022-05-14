import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ContainCountTest {
    @Test
    void ContainCount_는_LottoNumbers_최대_사이즈_이상이_될_수_없다() {
        assertThatThrownBy(() -> new ContainCount(7)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void ContainCount_는_음수가_될_수_없다() {
        assertThatThrownBy(() -> new ContainCount(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void ContainCount_는_값_객체이다() {
        assertThat(new ContainCount(1)).isEqualTo(new ContainCount(1));
    }

}
