package lotto.model;

import java.util.List;
import lotto.constant.LottoRoleConst;
import lotto.utils.RandomNumberUtils;
import lotto.vo.Lotto;

public class LottoGeneratorService {

    public Lotto generateLotto() {
        List<Integer> randomNumberToList = RandomNumberUtils
                .generateRandomNumberToList(LottoRoleConst.LOW_NUMBER, LottoRoleConst.MAX_NUMBER,
                        LottoRoleConst.LOTTO_NUMBER_LIST_SIZE);
        return new Lotto(randomNumberToList);
    }
}
