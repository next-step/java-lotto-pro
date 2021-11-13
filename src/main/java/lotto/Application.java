package lotto;

import lotto.ui.Driver;

public class Application {

    public static void main(String[] args) {
        try {
            Driver.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
