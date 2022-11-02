package step3.domain.lotto;

public enum LottoType {
    AUTOMATIC("자동"),
    MANUAL("수동")
    ;

    private final String type;

    LottoType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
