package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.Constants;
import lotto.util.IntUtil;
import lotto.util.RegexUtil;
import lotto.util.StringUtil;

public class Ticket {
    public List<Integer> lottoNumbers = new ArrayList<>();

    public Ticket() {
        generateTicket();
    }

    public Ticket(String winningTicketStr) {
        validateWinningTicketStr(winningTicketStr);
    }

    public String toString() {
        return String.format(Constants.STR_LOTTO_NUM_LIST, lottoNumbers.toArray());
    }

    public int compareTicket(Ticket cmpTicket) {
        int cnt = 0;

        for (int i : cmpTicket.lottoNumbers) {
            cnt += countCorrectNumber(i);
        }

        return cnt;
    }

    private int countCorrectNumber(int num) {
        if (this.lottoNumbers.contains(num)) {
            return 1;
        }
        return 0;
    }

    private void generateTicket() {
        List<Integer> candidateNumbers = IntStream
                .rangeClosed(Constants.TICKET_MIN_LOTTO_NUM, Constants.TICKET_MAX_LOTTO_NUM).boxed()
                .collect(Collectors.toList());

        Collections.shuffle(candidateNumbers);

        IntStream.rangeClosed(Constants.TICKET_MIN_IDX, Constants.TICKET_MAX_IDX).forEach(i -> {
            this.lottoNumbers.add(candidateNumbers.get(i));
        });

        Collections.sort(this.lottoNumbers);
    }

    private void validateWinningTicketStr(String winningTicketStr) {
        if (StringUtil.isNullOrEmpty(winningTicketStr)) {
            throw new IllegalArgumentException(Constants.ERR_NULL_VALUE);
        }

        String[] winningTicketStrArray = winningTicketStr.split(Constants.COMMA);

        if (winningTicketStrArray.length != Constants.SIX) {
            throw new IllegalArgumentException(Constants.ERR_SIX_NUMBERS);
        }

        for (String s : winningTicketStrArray) {
            validateWinningTicketNum(s.trim());
        }

        Set<Integer> tmpLottoSet = new HashSet<>(this.lottoNumbers);

        if (tmpLottoSet.size() != this.lottoNumbers.size()) {
            throw new IllegalArgumentException(Constants.ERR_DUP_NUMBERS);
        }
    }

    private void validateWinningTicketNum(String numStr) {
        if (!RegexUtil.match(Constants.REGEX_1_TO_45_CHAR, numStr)) {
            throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
        }

        this.lottoNumbers.add(IntUtil.parseInt(numStr));
    }
}
