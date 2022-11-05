package lotto.application;

import lotto.application.io.Input;
import lotto.application.io.Output;
import lotto.domain.CreateLottoNumberPolicy.CreateShuffleLottoNumberPolicy;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.domain.WinningLotto;

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
        Lotto lotto = new Lotto(input.lottoNumbers());

        output.bonusNumber();
        LottoNumber bonusNumber = input.bonusNumber();

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Statistics statistics = lottos.contains(winningLotto);

        output.result(statistics);
    }

    @Override
    public void close() {
        input.close();
    }
}
