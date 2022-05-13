package calculator.domain;

/**
 * @author : choi-ys
 * @date : 2022/05/13 4:05 오후
 */
public enum DelimiterType {
    NORMAL, CUSTOM;

    public boolean isNormal() {
        return this == NORMAL;
    }

    public boolean isCustom() {
        return this == CUSTOM;
    }
}
