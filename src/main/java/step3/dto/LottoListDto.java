package step3.dto;

import java.util.List;

public class LottoListDto {
    List<String> lottoList;

    public LottoListDto(List<String> lottoList) {
        this.lottoList = lottoList;
    }

    public List<String> getLottoList() {
        return lottoList;
    }
}
