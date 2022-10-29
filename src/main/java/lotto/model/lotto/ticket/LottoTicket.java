package lotto.model.lotto.ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동 생성한 6 개의 로또 번호 한 줄을 저장하고 관리하는 객체이다.
 */
public class LottoTicket {
    private static final int SIZE_OF_FULL_CANDIDATE_LIST = 45;
    private static final int COUNT_OF_NUMBERS_IN_SINGLE_LOTTO_TICKET = 6;
    protected final List<Integer> numbers;

    public LottoTicket() {
        this.numbers = new ArrayList<>(COUNT_OF_NUMBERS_IN_SINGLE_LOTTO_TICKET);
        final List<Integer> candidates = intsFromOneToFortyFive();
        for (int i = 0; i < COUNT_OF_NUMBERS_IN_SINGLE_LOTTO_TICKET; ++i) {
            final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
            final int generatedRandomNumber = lottoNumberGenerator.generate();
            numbers.add(generatedRandomNumber);
            candidates.remove((Integer) generatedRandomNumber);
        }
    }

    private List<Integer> intsFromOneToFortyFive() {
        final List<Integer> fullCandidateList = new ArrayList<>(SIZE_OF_FULL_CANDIDATE_LIST);
        for (int i = 1; i <= SIZE_OF_FULL_CANDIDATE_LIST; ++i) {
            fullCandidateList.add(i);
        }
        return fullCandidateList;
    }
}
