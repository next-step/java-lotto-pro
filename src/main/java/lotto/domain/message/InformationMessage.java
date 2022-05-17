package lotto.domain.message;

public enum InformationMessage {
    RESULT(System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---------"),
    WIN("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)"),
    LOSE("(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
    ;

    private final String message;

    InformationMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
