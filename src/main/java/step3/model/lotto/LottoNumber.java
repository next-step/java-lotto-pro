package step3.model.lotto;

import java.util.Objects;
import step3.model.value.ErrMsg;
import step3.model.value.Rule;

public class LottoNumber implements Comparable<LottoNumber>{
    private final int number;
    public LottoNumber(final int input) {
        validateIntRange(input);
        this.number = input;
    }


    private void validateIntRange(int number) {
        if(number< Rule.MIN_LOTTO_NUM || number>Rule.MAX_LOTTO_NUM){
            throw new IllegalArgumentException(ErrMsg.WRONG_RANGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
       if(this.number>o.number){
           return 1;
       }
       if(this.number<o.number){
           return -1;
       }
       return 0;
    }
}
