package lotto.auto;

import lotto.domain.CollectionsShuffler;

import java.util.Scanner;

public class AutoLottoApplication {
    private State state;

    public AutoLottoApplication(State state) {
        this.state = state;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (!state.isFinish()) {
            state.process(this, scanner);
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public static void main(String[] args) {
        AutoLottoApplication application = new AutoLottoApplication(new FirstState(new FirstStateView(), new CollectionsShuffler()));
        application.play();
    }
}
