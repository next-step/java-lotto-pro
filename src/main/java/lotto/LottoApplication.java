package lotto;

import lotto.state.State;

import java.util.Scanner;

public abstract class LottoApplication {
    private State state;

    public LottoApplication(State state) {
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
}
