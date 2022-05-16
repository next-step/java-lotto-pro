package step3.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoElement> lottoElements = new ArrayList();
    private final int LOTTO_ELEMENTS_SIZE = 6;
    private static final String LOTTO_DELIMITER = ",";
    private final String CREATE_TICKET_EXCEPTION_MSG = "로또는 중복되지 않은 %s 개의 숫자로 이루어져있습니다";
    private final String PARSE_INT_EXCEPTION_MSG = "로또는 숫자로 이루어져 있어야 합니다";

    public LottoTicket(List<String> lottoNumbers) {
        List<Integer> lottoSource = validInnerSource(lottoNumbers);
        for (Integer lottoElement : lottoSource) {
            lottoElements.add(new LottoElement(lottoElement));
        }
        Collections.sort(lottoElements);
    }

    public LottoTicket(String lottoElementsSource) {
        this(Arrays.asList(lottoElementsSource.split(LOTTO_DELIMITER)));
    }

    private List<Integer> validInnerSource(List<String> lottoElementsSource) {
        if (new HashSet<>(lottoElementsSource).size() != LOTTO_ELEMENTS_SIZE) {
            throw new IllegalArgumentException(String.format(CREATE_TICKET_EXCEPTION_MSG, LOTTO_ELEMENTS_SIZE));
        }
        try {
            return lottoElementsSource.stream().map(Integer::parseInt).collect(Collectors.toList());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(PARSE_INT_EXCEPTION_MSG);
        }
    }


    public int getMatchCountWithMyTicket(LottoTicket lottoTicket) {
        return lottoTicket.getMatchCountWithWinnerTicket(lottoElements);
    }

    public int getMatchCountWithWinnerTicket(List<LottoElement> compareLottoElements) {
        int matchCount = 0;
        for (int i = 0; i < LOTTO_ELEMENTS_SIZE; i++) {
            matchCount = matchCount + isMatch(compareLottoElements.get(i));
        }
        return matchCount;
    }

    private int isMatch(LottoElement lottoElement) {
        if (lottoElements.contains(lottoElement)) {
            return 1;
        }
        return 0;
    }

    public List<Integer> getLottoNumbers() {
        return lottoElements.stream().map(LottoElement::getElement)
            .collect(Collectors.toList());
    }
}
