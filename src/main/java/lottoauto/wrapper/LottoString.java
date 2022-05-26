package lottoauto.wrapper;

public enum LottoString {

    FIFTH_STR("3개 일치(5000원)-"),
    FOURTH_STR("4개 일치(50000원)-"),
    THIRD_STR("5개 일치(1500000원)-"),

    SECOND_STR("5개 일치(300000000), 보너스 볼 일치-"),
    FIRST_STR("6개 일치(2000000000원)-");

    private final String printValue;

    LottoString(String printValue) {
        this.printValue = printValue;
    }

    public String getPrintValue() {
        return this.printValue;
    }
}
