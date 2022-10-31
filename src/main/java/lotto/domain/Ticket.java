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
    private static final int SIX = 6;
    private static final String COMMA = ",";
    private static final String REGEX_1_TO_45_CHAR = "^.{1,45}$";
    private static final String ERR_SIX_NUMBERS = "여섯 개의 숫자를 입력해 주세요.";
    private static final String ERR_DUP_NUMBERS = "중복된 숫자는 허용되지 않습니다.";
    private static final String STR_LOTTO_NUM_LIST = "[%d, %d, %d, %d, %d, %d]\n";
    private static final int TICKET_MIN_IDX = 0;
    private static final int TICKET_MAX_IDX = 5;
    private static final int TICKET_MIN_LOTTO_NUM = 1;
    private static final int TICKET_MAX_LOTTO_NUM = 45;
    
    public List<Integer> lottoNumbers = new ArrayList<>();

    public Ticket() {
        generateTicket();
    }

    public Ticket(String winningTicketStr) {
        validateWinningTicketStr(winningTicketStr);
    }

    public String toString() {
        return String.format(STR_LOTTO_NUM_LIST, lottoNumbers.toArray());
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
                .rangeClosed(TICKET_MIN_LOTTO_NUM, TICKET_MAX_LOTTO_NUM).boxed()
                .collect(Collectors.toList());

        Collections.shuffle(candidateNumbers);

        IntStream.rangeClosed(TICKET_MIN_IDX, TICKET_MAX_IDX).forEach(i -> {
            this.lottoNumbers.add(candidateNumbers.get(i));
        });

        Collections.sort(this.lottoNumbers);
    }

    private void validateWinningTicketStr(String winningTicketStr) {
        if (StringUtil.isNullOrEmpty(winningTicketStr)) {
            throw new IllegalArgumentException(Constants.ERR_NULL_VALUE);
        }

        String[] winningTicketStrArray = winningTicketStr.split(COMMA);

        if (winningTicketStrArray.length != SIX) {
            throw new IllegalArgumentException(ERR_SIX_NUMBERS);
        }

        for (String s : winningTicketStrArray) {
            validateWinningTicketNum(s.trim());
        }

        Set<Integer> tmpLottoSet = new HashSet<>(this.lottoNumbers);

        if (tmpLottoSet.size() != this.lottoNumbers.size()) {
            throw new IllegalArgumentException(ERR_DUP_NUMBERS);
        }
    }

    private void validateWinningTicketNum(String numStr) {
        if (!RegexUtil.match(REGEX_1_TO_45_CHAR, numStr)) {
            throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
        }

        this.lottoNumbers.add(IntUtil.parseInt(numStr));
    }
}
