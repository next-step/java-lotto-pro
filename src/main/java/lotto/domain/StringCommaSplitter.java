package lotto.domain;

public class StringCommaSplitter implements LottoStringSplitter {
    @Override
    public String[] split(String str) {
        return str.split(",");
    }
}
