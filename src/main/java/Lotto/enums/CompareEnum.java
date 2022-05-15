package Lotto.enums;

public enum CompareEnum {
    First(6),
    Second(5),
    Third(4),
    Fourth(3),
    Fail(0);

    private long hitCount;

    CompareEnum(long hitCount) {
        this.hitCount = hitCount;
    }

    public static CompareEnum of(long hitCount) {
        if(hitCount == 6)
            return CompareEnum.First;

        if(hitCount == 5)
            return CompareEnum.Second;

        if(hitCount == 4)
            return CompareEnum.Third;

        if(hitCount == 3)
            return CompareEnum.Fourth;

        return CompareEnum.Fail;
    }
}
