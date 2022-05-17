package lotto.domain;

public class LottoRandomFactory {
    private final RandomNumberMachine randomNumberMachine;
    private final int numberSize;

    public LottoRandomFactory(RandomNumberMachine randomNumberMachine, int numberSize) {
        this.randomNumberMachine = randomNumberMachine;
        this.numberSize = numberSize;
    }

    public Lotto create() {
        LottoNumber[] lottoNumberList = new LottoNumber[numberSize];
        for (int index = 0; index < numberSize; index++) {
            lottoNumberList[index] = randomNumberMachine.popRandomNumber();
        }
        randomNumberMachine.refill();

        return new Lotto(lottoNumberList);
    }
}
