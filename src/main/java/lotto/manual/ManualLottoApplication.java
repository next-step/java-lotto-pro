package lotto.manual;

import lotto.LottoApplication;
import lotto.state.State;
import lotto.state.manual.ManualStartState;
import lotto.state.manual.ManualStartStateView;

public class ManualLottoApplication extends LottoApplication {
    public ManualLottoApplication(State state) {
        super(state);
    }

    public static void main(String[] args) {
        ManualLottoApplication application = new ManualLottoApplication(new ManualStartState(new ManualStartStateView()));
        application.play();
    }
}
