package lotto.auto;

import lotto.LottoApplication;
import lotto.domain.CollectionsShuffler;
import lotto.state.FirstState;
import lotto.state.FirstStateView;
import lotto.state.State;

import java.util.Scanner;

public class AutoLottoApplication extends LottoApplication {
    public AutoLottoApplication(State state) {
        super(state);
    }

    public static void main(String[] args) {
        AutoLottoApplication application = new AutoLottoApplication(new FirstState(new FirstStateView(), new CollectionsShuffler()));
        application.play();
    }
}
