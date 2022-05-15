package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class LottoElementTest {

    @Test
    public void createLottoElementByNumber() {
        assertAll(
            () -> assertThatThrownBy(() -> new LottoElement("-1")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new LottoElement("a")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new LottoElement("0")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void createLottoElementWithSpace() {
        LottoElement expected = new LottoElement("2");
        assertThat(new LottoElement(" 2")).isEqualTo(expected);
        assertThat(new LottoElement(" 2 ")).isEqualTo(expected);
        assertThat(new LottoElement(" 2       ")).isEqualTo(expected);
        assertThat(new LottoElement("         2       ")).isEqualTo(expected);
    }
}
