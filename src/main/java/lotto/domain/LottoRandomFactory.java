package lotto.domain;

public class LottoRandomFactory {
    private final RandomNumberMachine randomNumberMachine;

    public LottoRandomFactory(RandomNumberMachine randomNumberMachine) {
        this.randomNumberMachine = randomNumberMachine;
    }

    public Lotto create() {
        LottoNumber[] lottoNumberList = new LottoNumber[Lotto.SIZE];
        for (int index = 0; index < Lotto.SIZE; index++) {
            lottoNumberList[index] = randomNumberMachine.popRandomNumber();
        }
        randomNumberMachine.refill();

        return new Lotto(lottoNumberList);
    }
}
