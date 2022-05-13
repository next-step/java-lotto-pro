package lotto;

import lotto.controller.LottoController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        LottoController lottoController = new LottoController();
        lottoController.playing();
    }
}
