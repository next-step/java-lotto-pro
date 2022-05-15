package camp.nextstep.edu.step3;

public class Application {
    public static void main(String[] args) {
        Presenter presenter = new Presenter();
       new LottoService(presenter).task();
    }
}
