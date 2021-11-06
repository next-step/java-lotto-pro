package string;

import org.junit.jupiter.api.Test;
import string.Input;
import string.Numbers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @Test
    void isEmpty_true() {
        Input input = new Input("");
        assertThat(input.isEmpty()).isTrue();

        input = new Input(null);
        assertThat(input.isEmpty()).isTrue();
    }

    @Test
    void isEmpty_false() {
        Input input = new Input("2");
        assertThat(input.isEmpty()).isFalse();

        input = new Input("2,3,4");
        assertThat(input.isEmpty()).isFalse();
    }

    @Test
    void split_숫자하나() {
        Input input = new Input("2");
        assertThat(input.split())
                .isEqualTo(new Numbers("2"));
    }

    @Test
    void split_쉼표구분자() {
        Input input = new Input("1,2");
        assertThat(input.split())
                .isEqualTo(new Numbers("1", "2"));
    }

    @Test
    void split_쉼표_또는_콜론_구분자() {
        Input input = new Input("1,2:3");
        assertThat(input.split())
                .isEqualTo(new Numbers("1", "2", "3"));
    }

    @Test
    void split_custom_구분자() {
        Input input = new Input("//;\n1;2;3");
        assertThat(input.split())
                .isEqualTo(new Numbers("1", "2", "3"));
    }

    @Test
    void split_negative() {
        Input input = new Input("-1,2,3");
        assertThatThrownBy(input::split)
                .isInstanceOf(RuntimeException.class);
    }
}
