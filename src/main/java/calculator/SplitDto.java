package calculator;

class SplitDto {

    public static final String DEFAULT_DELIMITER = ",|:";

    private String text;
    private String delimiter;

    public static SplitDto of(String text) {
        return SplitDto.of(text, DEFAULT_DELIMITER);
    }

    public static SplitDto of(String text, String delimiter) {
        SplitDto dto = new SplitDto();
        dto.text = text;
        dto.delimiter = delimiter;
        return dto;
    }

    public String[] split() {
        return text.split(delimiter);
    }
}