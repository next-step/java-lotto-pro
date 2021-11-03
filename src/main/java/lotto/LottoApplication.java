package lotto;

import lotto.controller.LottoController;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        try {
            lottoController.run();

        } catch (RuntimeException e) {
            System.out.println("=====> Error Message : " + e.getMessage());
        }
    }
}

