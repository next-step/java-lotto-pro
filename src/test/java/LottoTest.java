import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    public void issueLotto(){
        assertThat(new Lotto().getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void issueLottoUseString(){
        assertThat(new Lotto("1,2,3,4,5,6").getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void issueLottoRuntimeException(){
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5"))
                .isInstanceOf(RuntimeException.class);

    }



}
