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
            state.printQuestion(System.out);
            processResult(scanner);
        }
    }

    private void processResult(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            state.printResult(input, System.out);
            state = state.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        AutoLottoApplication application = new AutoLottoApplication(new FirstState(new FirstStateView(), new CollectionsShuffler()));
        application.play();
    }
}
