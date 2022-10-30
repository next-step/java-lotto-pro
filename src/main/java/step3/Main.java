package step3;

import step3.application.LottoSystem;

public class Main {

    public static void main(String[] args) {
        try (LottoSystem lottoSystem = LottoSystem.asDefault()) {
            lottoSystem.run();
        }
    }
}
