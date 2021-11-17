package lotto.domain;

import lotto.domain.common.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class AutoLottoPurchaseMachine {

    private static final List<Integer> lottoNumber =
            IntStream.rangeClosed(Constant.LOTTO_MIN, Constant.LOTTO_MAX)
                    .boxed()
                    .collect(Collectors.toList());

    public List<Lotto> generateLottoNumbers(final int autoLottoCount) {
        List<Lotto> lottosList = new ArrayList<>();
        for( int i = 0; i < autoLottoCount; i++ ) {
            Collections.shuffle(lottoNumber);
            List<Integer> lottoNumberSubList = new ArrayList<>(lottoNumber.subList(0, 6));
            Collections.sort(lottoNumberSubList);
            lottosList.add(Lotto.from(lottoNumberSubList));
        }

        return lottosList;
    }
}
