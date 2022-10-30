package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import lotto.util.Constants;
import lotto.util.IntUtil;
import lotto.util.RegexUtil;
import lotto.util.StringUtil;

public class WinningTicket {
    public List<Integer> lottoNumbers = new ArrayList<>();

    private static final int SIX = 6;
    
    public WinningTicket(String winningTicketStr) {
        validateWinningTicketStr(winningTicketStr);
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
