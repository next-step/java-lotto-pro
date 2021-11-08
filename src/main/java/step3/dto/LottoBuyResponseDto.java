package step3.dto;

import java.util.ArrayList;
import java.util.List;

import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;

public class LottoBuyResponseDto {
    private final List<LottoNumbers> buyLottoList;

    public LottoBuyResponseDto(LottoNumbersBundle lottoNumbersBundle) {
        this.buyLottoList = lottoNumbersBundle.getLottoNumbersBundle();
    }

    public List<String> getBuyLottoList() {
        List<String> result = new ArrayList<>();
        for (LottoNumbers lottoNumbers : buyLottoList) {
            result.add(lottoNumbers.toString());
        }
        return result;
    }
}
