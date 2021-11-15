package lotto.consts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberConst {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final List<Integer> lottoNumbers = IntStream.rangeClosed(LottoNumberConst.START_NUMBER, LottoNumberConst.END_NUMBER).boxed().collect(Collectors.toList());
}
