package step3.model.machine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchTest {

    @Test
    void 보너스_번호는_보너스카운트도_비교한다() {
        Match match1 = new Match(5,1);
        Match match2 = new Match(5,0);
        assertFalse(match1.equals(match2));
    }

    @Test
    void 보너스_번호가_아니면_매치카운트만_비교한다() {
        Match match1 = new Match(4,1);
        Match match2 = new Match(4,0);
        assertTrue(match1.equals(match2));
    }
}