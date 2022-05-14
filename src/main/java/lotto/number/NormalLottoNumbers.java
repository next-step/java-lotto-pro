package lotto.number;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.rank.LottoRank;

public class NormalLottoNumbers implements LottoNumbers {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private List<LottoNumber> lottoNumberList;

    public NormalLottoNumbers(List<LottoNumber> lottoNumberList){
        Collections.sort(lottoNumberList);
        this.lottoNumberList = Collections.unmodifiableList(lottoNumberList);
    }

    public List<LottoNumber> getLottoNumberList() {
        return Collections.unmodifiableList(lottoNumberList);
    }

    @Override
    public LottoRank matchWithWinNumbers(LottoNumbers winNumbers) {
        int matchCount=0;
        for(LottoNumber number : winNumbers.getLottoNumberList()){
            matchCount+=contains(number);
        }
        return LottoRank.getRank(matchCount);
    }

    private int contains(LottoNumber number) {
        if(lottoNumberList.contains(number)){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumberList.toArray());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NormalLottoNumbers that = (NormalLottoNumbers) o;
        return Objects.equals(lottoNumberList, that.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }

}
