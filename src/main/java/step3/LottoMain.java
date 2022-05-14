package step3;

import step3.viewer.LottoViewer;

public class LottoMain {
    public static void main(String[] args) {
        try {
            startLotto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void startLotto() {
        final LottoViewer lottoViewer = new LottoViewer();
        final int price = lottoViewer.inputPrice();
    }
}
