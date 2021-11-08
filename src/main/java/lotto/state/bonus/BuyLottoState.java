package lotto.state.bonus;

import lotto.domain.Shuffleable;
import lotto.state.FirstState;
import lotto.state.FirstStateView;
import lotto.state.State;

public class BuyLottoState extends FirstState {

    public BuyLottoState(FirstStateView firstStateView, Shuffleable shuffler) {
        super(firstStateView, shuffler);
    }

    @Override
    public State next() {
        return new WinningNumberState(new WinningNumberStateView(), getLotteryTicket());
    }
}
