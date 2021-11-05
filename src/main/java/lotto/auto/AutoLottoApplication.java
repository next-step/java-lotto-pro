package lotto.auto;

import lotto.domain.CollectionsShuffler;

import java.util.Scanner;

public class AutoLottoApplication {
    FirstState state;

    public AutoLottoApplication(FirstState state) {
        this.state = state;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        state.printQuestion(System.out);
        try {
            String input = scanner.next();
            state.printResult(input, System.out);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        AutoLottoApplication application = new AutoLottoApplication(new FirstState(new FirstStateView(), new CollectionsShuffler()));
        application.play();
    }
}
