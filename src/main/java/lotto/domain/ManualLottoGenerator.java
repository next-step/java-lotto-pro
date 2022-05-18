package lotto.domain;

public class ManualLottoGenerator {

    private final ManualLottoNumbers lottoNumbers;

    public ManualLottoGenerator(ManualLottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lottos generate() {
        return lottoNumbers.convertLottos();
    }
}
