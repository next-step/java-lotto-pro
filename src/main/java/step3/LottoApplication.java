package step3;

import step3.controller.GameController;

public class LottoApplication {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
