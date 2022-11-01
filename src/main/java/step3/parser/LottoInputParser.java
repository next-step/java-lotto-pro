package step3.parser;

import step2.StringParser;
import step3.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoInputParser {

    public static List<LottoNumber> parseToLottoNumberArray(String readLine) {
        return StringParser.parseToIntegerArray(readLine)
                .stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

}
