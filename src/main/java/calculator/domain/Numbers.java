package calculator.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private List<Number> numberList;

    public Numbers(List<String> numberList){
        this.numberList = numberList.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getNumberList(){
        return numberList;
    }
}
