package lotto.controller.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersDTO {

    private Set<Integer> lottoNumbers;

    public LottoNumbersDTO(List<Integer> lottoNumber) {
        this.lottoNumbers = new HashSet<>(lottoNumber);
    }

    public List<Integer> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    public void setLottoNumbers(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}
