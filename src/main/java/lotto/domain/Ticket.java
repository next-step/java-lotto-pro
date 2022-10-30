package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.Constants;

public class Ticket {
    public List<Integer> lottoNumbers = new ArrayList<>();

    private static final int ZERO = 0;

    public Ticket() {
        generateTicket();
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
}
