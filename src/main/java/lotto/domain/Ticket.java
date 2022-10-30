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

    private static final int SIX = 6;
    private static final int ZERO = 0;

    public Ticket() {
        generateTicket();
    }
    
    public Ticket(String winningTicketStr) {
        validateWinningTicketStr(winningTicketStr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        IntStream.rangeClosed(Constants.TICKET_MIN_IDX, Constants.TICKET_MAX_IDX).forEach(i -> {
            sb.append(String.valueOf(this.lottoNumbers.get(i)));
            sb.append(Constants.COMMA);
            sb.append(Constants.BLANK);
        });

        return removeLastComma(sb.toString());
    }

    private void generateTicket() {
        List<Integer> candidateNumbers =
                IntStream.rangeClosed(Constants.TICKET_MIN_LOTTO_NUM, Constants.TICKET_MAX_LOTTO_NUM)
                .boxed()
                .collect(Collectors.toList());
        
        Collections.shuffle(candidateNumbers);
        
        IntStream.rangeClosed(Constants.TICKET_MIN_IDX, Constants.TICKET_MAX_IDX).forEach(i -> {
            this.lottoNumbers.add(candidateNumbers.get(i));
        });
        
        Collections.sort(this.lottoNumbers);
    }

    private String removeLastComma(String str) {
        int lastCommaIndex = str.lastIndexOf(Constants.COMMA);
        return str.substring(ZERO, lastCommaIndex);
    }

    private void validateWinningTicketStr(String winningTicketStr) {
        if(StringUtil.isNullOrEmpty(winningTicketStr)) {
            throw new IllegalArgumentException(Constants.ERR_NULL_VALUE);
        }
        
        String[] winningTicketStrArray = winningTicketStr.split(Constants.COMMA);
        
        if(winningTicketStrArray.length != SIX) {
            throw new IllegalArgumentException(Constants.ERR_SIX_NUMBERS);
        }
        
        IntStream.rangeClosed(Constants.TICKET_MIN_IDX, Constants.TICKET_MAX_IDX).forEach(i -> {
            validateWinningTicketNum(winningTicketStrArray[i].trim());
        });
        
        Set<Integer> tmpLottoSet = new HashSet<>(this.lottoNumbers);
        
        if(tmpLottoSet.size() != this.lottoNumbers.size()) {
            throw new IllegalArgumentException(Constants.ERR_DUP_NUMBERS);
        }
    }
    
    private void validateWinningTicketNum(String numStr) {
        if(!RegexUtil.match(Constants.REGEX_1_TO_45_CHAR, numStr)) {
            throw new IllegalArgumentException(Constants.ERR_VALUE_NOT_VALID);
        }
        
        this.lottoNumbers.add(IntUtil.parseInt(numStr));
    }
}
