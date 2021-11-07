package lotto.bonus;

import lotto.LottoApplication;
import lotto.domain.CollectionsShuffler;
import lotto.state.FirstStateView;
import lotto.state.State;
import lotto.state.bonus.BuyLottoState;

public class BonusLottoApplication extends LottoApplication {
    public BonusLottoApplication(State state) {
        super(state);
    }

    public static void main(String[] args) {
        BonusLottoApplication application = new BonusLottoApplication(new BuyLottoState(new FirstStateView(), new CollectionsShuffler()));
        application.play();
    }
}
