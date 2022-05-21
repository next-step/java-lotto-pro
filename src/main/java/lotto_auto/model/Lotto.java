package lotto_auto.model;

public class Lotto {
    private final LottoNumbers lottoNumbers;
    public Lotto(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public boolean isContain(LottoNumber number) {
        return lottoNumbers.isContain(number);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public int countSameLottoNumber(Lotto other) {
        return (int) this.lottoNumbers.getLottoNumberSet()
                .stream()
                .filter(other::isContain).count();
    }

}
