package lotto.controller.dto;

import java.util.List;

public class WinningLottoDTO {
    private List<Integer> lottoNumbers;
    private int bonusNumber;

    public WinningLottoDTO(List<Integer> answer, int bonusNumber) {
        this.lottoNumbers = answer;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void setLottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
