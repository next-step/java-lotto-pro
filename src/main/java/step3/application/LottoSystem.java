package step3.application;

import step3.application.io.Input;
import step3.application.io.Output;
import step3.domain.CreateLottoNumberPolicy.CreateShuffleLottoNumberPolicy;
import step3.domain.Lotto;
import step3.domain.LottoMachine;
import step3.domain.Lottos;
import step3.domain.Statistics;

public class LottoSystem implements AutoCloseable {

    private final Input input;
    private final Output output;
    private final LottoMachine lottoMachine;

    private LottoSystem(Input input, Output output, LottoMachine lottoMachine) {
        this.input = input;
        this.output = output;
        this.lottoMachine = lottoMachine;
    }

    public static LottoSystem asDefault() {
        return new LottoSystem(
            new Input(),
            new Output(),
            new LottoMachine(1_000, new CreateShuffleLottoNumberPolicy())
        );
    }

    public void run() {
        output.inputMoney();
        int money = input.money();

        Lottos lottos = lottoMachine.issue(money);
        output.lottos(lottos);

        output.inputWinningLottoNumbers();
        Lotto winningLotto = new Lotto(input.lottoNumbers());
        Statistics statistics = lottos.contains(winningLotto);

        output.result(statistics);
    }

    @Override
    public void close() {
        input.close();
    }
}
