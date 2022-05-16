package lotto.controller.dto;

import java.util.List;

public class LottoNumbersDTO {

    private List<Integer> lottoNumbers;

    public LottoNumbersDTO(List<Integer> lottoNumber) {
        this.lottoNumbers = lottoNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void setLottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}
