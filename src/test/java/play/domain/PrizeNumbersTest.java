package play.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeNumbersTest {
    @Test
    @DisplayName("상금로또번호 입력시 6자리인지 테스트")
    void check_winner_number_size(){
        PrizeNumbers prizeNumbers = new PrizeNumbers("1,2,3,4,5,6");
        String str = "1,2,3,4,5";
        String[] splitNumbers = str.split(",");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> prizeNumbers.validSplitNumbersSize(splitNumbers))
                .withMessage("올바른 형식의 지난 당첨 번호를 입력해주세요.");
    }
}
