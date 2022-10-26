package lotto.match;

import lotto.machine.Result;
import lotto.system.OutputView;
import org.junit.jupiter.api.Test;

public class MatchTest {

    @Test
    void 일치한_갯수를_출력한다(){
        OutputView.printResult(new Result());
    }

}
