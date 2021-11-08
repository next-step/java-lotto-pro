import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    public void hasMoney(){
        User user = new User(new BigInteger("1000"));
        assertThat(user.hasMoney()).isTrue();
    }

    @Test
    public void hasNoMoney(){
        User user = new User(new BigInteger("900"));
        assertThat(user.hasMoney()).isFalse();
    }

    @Test
    public void buy(){
        User user = new User(new BigInteger("14000"));
        user.buyLotto();
        assertThat(user.getMoney()).isEqualTo(13000);
    }

    @Test
    public void getProfitRateTest() {


    }
}
