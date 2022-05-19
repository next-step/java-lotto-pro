package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.LottoUser;

public class LottoUserTest {

    LottoUser user;

    @BeforeEach
    public void init() {
        user = new LottoUser();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:true", "a:false", "999:true", "-1:false"}, delimiter = ':')
    public void setMoneyTest(String money, boolean expected) {
        Assertions.assertThat(user.setMoney(money)).isEqualTo(expected);
    }

}
