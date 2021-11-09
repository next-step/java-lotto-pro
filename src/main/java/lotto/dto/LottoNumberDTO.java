package lotto.dto;

public class LottoNumberDTO {
    private final int lottoNumber;

    public LottoNumberDTO(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
