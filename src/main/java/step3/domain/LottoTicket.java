package step3.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import step3.model.LottoGenerator;
import step3.model.LottoWinChecker;
import step3.utls.NumberUtil;

public class LottoTicket {

    private final List<LottoElement> lottoElements = new ArrayList();
    private static final String LOTTO_DELIMITER = ",";
    private static final String CREATE_TICKET_EXCEPTION_MSG = "로또는 중복되지 않은 %s 개의 숫자로 이루어져있습니다";

    public LottoTicket(List<String> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        List<Integer> lottoSource = elementsSourceToInt(lottoNumbers);
        for (Integer lottoElement : lottoSource) {
            lottoElements.add(new LottoElement(lottoElement));
        }
        Collections.sort(lottoElements);
    }

    public LottoTicket(String lottoElementsSource) {
        this(Arrays.asList(lottoElementsSource.split(LOTTO_DELIMITER)));
    }

    private void validateLottoNumbers(List<String> lottoElementsSource) {
        if (new HashSet<>(lottoElementsSource).size() != LottoGenerator.LOTTO_ELEMENTS_SIZE) {
            throw new IllegalArgumentException(
                String.format(LottoTicket.CREATE_TICKET_EXCEPTION_MSG, LottoGenerator.LOTTO_ELEMENTS_SIZE));
        }
    }

    private List<Integer> elementsSourceToInt(List<String> lottoElementsSource) {
        return lottoElementsSource.stream().map(NumberUtil::parseInt).collect(Collectors.toList());
    }

    public int getMatchCountWith(List<LottoElement> winnerLottoElements) {
        int matchCount = 0;
        for (LottoElement winnerLottoElement : winnerLottoElements) {
            matchCount = matchCount + isMatch(winnerLottoElement);
        }
        return matchCount;
    }

    private int isMatch(LottoElement lottoElement) {
        if (lottoElements.contains(lottoElement)) {
            return LottoWinChecker.MATCH;
        }
        return LottoWinChecker.NOT_MATCH;
    }

    public List<LottoElement> getLottoNumbers() {
        ArrayList<LottoElement> cloneLottoElement = new ArrayList<>();
        for (LottoElement lottoElement : lottoElements) {
            cloneLottoElement.add(lottoElement.clone());
        }
        return cloneLottoElement;
    }
}
