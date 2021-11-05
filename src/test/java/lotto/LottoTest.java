package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void lottoIssueTest() {
        Lotto lotto = LottoMachine.issue();
        assertThat(lotto).isNotNull();
    }
}
