package step4;

import step4.controller.GameController;

public class LottoApplication {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
