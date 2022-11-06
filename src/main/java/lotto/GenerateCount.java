package lotto;

import java.util.Objects;

public class GenerateCount {

    private final long count;

    public GenerateCount(long count) {
        this(String.valueOf(count));
    }

    public GenerateCount(String count) {
        try {
            this.count = Long.parseLong(count);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("구매 수는 숫자여야 합니다. 입력값:" + count);
        }
    }

    public long getCount() {
        return count;
    }

    public GenerateCount minus(GenerateCount target) {
        return new GenerateCount(this.count - target.count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GenerateCount that = (GenerateCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    public void validGreaterThan(GenerateCount manualCount) {
        if (minus(manualCount).getCount() < 0) {
            throw new IllegalStateException(
                    "생성 가능한 갯수 보다 많이 입력했습니다. 생성 가능 갯수:" + count + " 수동 입력 갯수:" + manualCount.getCount());
        }
    }
}
