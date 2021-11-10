package study.lotto.auto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_COUNT = 0;
    private static final int MAX_LOTTO_COUNT = 6;

    private final List<LottoNumber> list;

    public LottoNumbers() {
        List<LottoNumber> totalLottoNumber = generateTotalLottoNumber();
        Collections.shuffle(totalLottoNumber);
        List<LottoNumber> lottoNumbers = totalLottoNumber.subList(MIN_LOTTO_COUNT, MAX_LOTTO_COUNT);
        Collections.sort(lottoNumbers);
        this.list = lottoNumbers;
    }

    public LottoNumbers(String readLastLottoNumbers) {
        String[] split = readLastLottoNumbers.split(",");
        list = new ArrayList<>();
        for(String s : split) {
            list.add(new LottoNumber(Integer.parseInt(s)));
        }
    }

    private List<LottoNumber> generateTotalLottoNumber() {
        return IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public String makeLottoNumberPrintFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(LottoNumber lottoNumber : list) {
            sb.append(lottoNumber.getNumber() +", ");
        }
        sb.delete(sb.lastIndexOf(","), sb.length());
        sb.append(']');
        return sb.toString();
    }

    public int getMatchCount(LottoNumbers group) {
        int count = 0;
        for(LottoNumber lottoNumber : group.getLottoNumbers()){
            if(list.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    protected List<LottoNumber> getLottoNumbers() {
        return this.list;
    }
}
