import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RanksTest {
    @Test
    void Ranks에_Rank를_추가할_수_있다() {
        Ranks ranks = new Ranks();
        assertDoesNotThrow(() -> {
            ranks.add(Prize.NONE);
        });
    }

    @Test
    void Ranks_의_크기를_알_수_있다() {
        assertThat(new Ranks().size()).isZero();
    }

}
