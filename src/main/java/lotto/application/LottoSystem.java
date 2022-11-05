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
        int money = inputMoney();
        int selfLottoCount = inputSelfLottoCount();

        Lottos manualLottos = inputManaulLottos(selfLottoCount);
        Lottos buyLottos = lottoMachine.issue(money, manualLottos);
        output.lottos(buyLottos);

        WinningLotto winningLotto = createWinningLotto();
        Statistics statistics = buyLottos.contains(winningLotto);

        output.result(statistics);
    }

    private Lottos inputManaulLottos(int selfLottoCount) {
        if(selfLottoCount == 0) {
            return Lottos.empty();
        }
        return input.manualLottos(selfLottoCount);
    }

    private int inputSelfLottoCount() {
        output.inputSelfLottoCount();
        return input.selfLottoCount();
    }

    private int inputMoney() {
        output.inputMoney();
        return input.money();
    }

    private WinningLotto createWinningLotto() {
        output.inputWinningLottoNumbers();
        Lotto lotto = Lotto.manual(input.lottoNumbers());

        output.bonusNumber();
        LottoNumber bonusNumber = input.bonusNumber();

        return new WinningLotto(lotto, bonusNumber);
    }

    @Override
    public void close() {
        input.close();
    }
}
