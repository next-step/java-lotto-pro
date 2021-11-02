package stringcalcurator;

public class CalcuratorNumber {
  private final Integer item;
  
  public CalcuratorNumber(String value) {
    if (isInvalid(value)) {
      throw new RuntimeException("유요하지 않은 계산 숫자입니다.");
    }

    item = Integer.valueOf(value);
  }

  public Integer value() {
    return item;
  }

  private boolean isInvalid(String value) {
    try {
      if (Integer.parseInt(value) < 0) {
        return true;
      }
    } catch (Exception exception) {
      return true;
    }
    
    return false;
  }
}
