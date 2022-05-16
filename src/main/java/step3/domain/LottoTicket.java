package step3.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final ArrayList<LottoElement> lottoElements = new ArrayList();
    private final int LOTTO_ELEMENTS_SIZE = 6;
    private static final String LOTTO_DELIMITER = ",";

    public LottoTicket(List<String> lottoNumbers) {
        validInnerSource(lottoNumbers);
        for (int i = 0; i < LOTTO_ELEMENTS_SIZE; i++) {
            lottoElements.add(new LottoElement(lottoNumbers.get(i)));
        }
        Collections.sort(lottoElements);
    }

    public LottoTicket(String lottoElementsSource) {
        this(Arrays.asList(lottoElementsSource.split(LOTTO_DELIMITER)));
    }

    private void validInnerSource(List<String> lottoElementsSource) {
        if (new HashSet<>(lottoElementsSource).size() != LOTTO_ELEMENTS_SIZE) {
            throw new IllegalArgumentException("로또는 중복되지 않은 " + LOTTO_ELEMENTS_SIZE + "개의 숫자로 이루어져있습니다");
        }
    }


    public int getMatchCountWith(LottoTicket lottoTicket) {
        return lottoTicket.match(lottoElements);
    }

    public int match(ArrayList<LottoElement> compareLottoElements) {
        int matchCount = 0;
        for (int i = 0; i < LOTTO_ELEMENTS_SIZE; i++) {
            matchCount = matchCount + compare(compareLottoElements.get(i));
        }
        return matchCount;
    }

    private int compare(LottoElement lottoElement) {
        if (lottoElements.contains(lottoElement)) {
            return 1;
        }
        return 0;
    }

    public List<String> getLottoNumbers() {
        return lottoElements.stream().map(LottoElement::getElement)
            .collect(Collectors.toList());
    }
}
