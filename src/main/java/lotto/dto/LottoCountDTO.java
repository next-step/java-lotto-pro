package lotto.dto;

public class LottoCountDTO {

    private final int lottoCount;

    public LottoCountDTO(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    @Override
    public String toString() {
        return Integer.toString(lottoCount);
    }
}
