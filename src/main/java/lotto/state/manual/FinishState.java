package lotto.state.manual;

import lotto.state.State;

public class FinishState implements State {
    @Override
    public State next() {
        return null;
    }

    @Override
    public boolean isFinish() {
        return true;
    }
}
