package step3.domain;

import static java.util.Collections.sort;
import static step3.LottoConstant.LottoElementSize;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoElement> lottoElements = new ArrayList();


    protected LottoTicket(List<Integer> lottoElementsSource) {
        for (int i = 0; i < LottoElementSize; i++) {
            lottoElements.add(LottoElement.create(lottoElementsSource.get(i)));
        }
    }

    public static LottoTicket create(List<String> lottoElementsSource) {
        validElements(lottoElementsSource);
        return new LottoTicket(parseElements(lottoElementsSource));
    }

    private static void validElements(List<String> lottoElementsSource) {
        if (lottoElementsSource.size() != LottoElementSize) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 이루어져있습니다");
        }
        if (new HashSet<>(lottoElementsSource).size() != LottoElementSize) {
            throw new IllegalArgumentException("로또는 중복되지 않은 6개의 숫자로 이루어져있습니다");
        }
    }

    private static List<Integer> parseElements(List<String> lottoElementsSource) {
        try {
            List<Integer> sourceToInt = lottoElementsSource.stream().mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
            sort(sourceToInt);
            return sourceToInt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또는 숫자로만 이루어져 있습니다");
        }
    }

}
