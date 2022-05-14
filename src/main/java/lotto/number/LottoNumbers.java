package lotto.number;


import java.util.List;
import lotto.rank.LottoRank;

public interface LottoNumbers {
    LottoRank matchWithWinNumbers(LottoNumbers winNumbers);

    List<LottoNumber> getLottoNumberList();
}
