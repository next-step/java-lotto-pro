package step3;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new ResultView());
        lottoController.start();
    }
}
