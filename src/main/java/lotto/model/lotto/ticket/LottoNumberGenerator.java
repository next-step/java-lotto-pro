package lotto.model.lotto.ticket;

import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    protected static final int NUMBER_COUNT_IN_SINGLE_LOTTO_TICKET = 6;

    public List<LottoNumber> generate() {
        List<LottoNumber> fullCandidateList = LottoNumber.fullCandidateList();
        Collections.shuffle(fullCandidateList);
        return fullCandidateList.subList(0, NUMBER_COUNT_IN_SINGLE_LOTTO_TICKET);
    }
}
