package step3;

import java.util.HashMap;
import step3.controller.LottoController;
import step3.utils.CriteriaProvider;
import step3.domain.LottoStore;
import step3.io.InputView;
import step3.io.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoStore lottoStore = new LottoStore();
        CriteriaProvider provider = () -> {
            return new HashMap<Integer, Long>() {
                {
                    put(3, 5000L);
                    put(4, 50000L);
                    put(5, 1500000L);
                    put(6, 2000000000L);
                }
            };
        };

        LottoController controller = new LottoController(inputView, outputView, lottoStore, provider);
        controller.start();
    }
}
