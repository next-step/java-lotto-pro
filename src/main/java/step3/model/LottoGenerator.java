package step3.model;

public class LottoGenerator {

    public Lottos generateLottos(int price, int manualCount) {
        Lottos lottos = new Lottos();
        lottos.generate(getGeneratorCount(price, manualCount));
        return lottos;
    }

    public Lotto generateLotto(String numbers) {
        return new Lotto(numbers);
    }

    public LottoNumber generateLottoNumber(String number) {
        return new LottoNumber(number);
    }

    public int getGeneratorCount(int price, int manual) {
        return (price / 1000) - manual;
    }

}
