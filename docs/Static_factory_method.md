# 정적 팩토리 메소드

## 정적 팩토리 메소드를 사용하면 얻는 장점

- 생성 목적을 메소드명에 표현 가능

- 객체 생성 관리 가능
  - 필요에 따라 항상 새로운 객체를 생성해서 반환할 수도,
    하나의 객체만 계속 반환할 수도 있음

  - 불필요한 객체 생성을 막을 수 있음
  ```java
  class Singleton {
      private static Singleton singleton = null;
    
      private Singleton() {}
    
      static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
      }
  }
  ```

- 하위 자료형 객체 반환 가능
  ( A -> A’, A’’ )
  - 구현체(하위 자료형)의 은닉 (외부노출x)
  - 인터페이스의 구현체를 몰라도 정적 팩토리 메소드를 사용하여
      경우에 따라 적절한 구현체를 반환할 수 있음
  - 구현체에 대한 의존성을 제거해줌
  ```java
  public class Application {
      public static void main(String[] args) {
          System.out.println(GradeCalculator.of(88).toText());
          System.out.println(GradeCalculator.of(50).toText());
      }
  }
  
  class GradeCalculator {
      static Grade of(int score) {
          if (score >= 90) {
              return new A();
          }
          if (score >= 80) {
              return new B();
          }
          return new F();
      }
  }
  
  interface Grade {
      String toText();
  }
  
  class A implements Grade {
      @Override
      public String toText() {
          return "A";
      }
  }
  
  class B implements Grade {
      @Override
      public String toText() {
          return "B";
      }
  }
  
  class F implements Grade {
      @Override
      public String toText() {
          return "F";
      }
  }
  ```
  (코드 출처 : https://7942yongdae.tistory.com/147)

- 객체 생성 캡슐화
  - 생성자를 private으로 선언하는 경우
    <br>DTO <-> VO 간의 형 변환 시 내부구현 모르더라도 변환 가능

<br>

---

## 활용 참고 사항
- 객체 생성 역할이 중요한 경우 정적 팩토리 메소드를 담은 클래스를 분리하는 것도 하나의 방법
- 생성자를 private으로 선언하면 상속 불가 ( >> 확장 불가 )

<br>

---

## 네이밍 컨벤션
- from : 하나의 매개 변수를 받아서 객체 생성
- of : 여러 개의 매개 변수를 받아서 객체 생성
- getInstance , instance : 인스턴스 생성 (이전에 반환했던 것과 같을 수 있음)
- newInstance, create : 새로운 인스턴스 생성
- get[OtherType] : 다른 타입의 인스턴스 생성 (이전에 반환했던 것과 같을 수 있음)
- new[OtherType] : 다른 타입의 새로운 인스턴스를 생성

<br>

---

### ※ 생성자를 private으로 선언, 활용

- 객체 생성 제한
  > 불필요하게 객체를 생성하는 것을 막을 수 있음
  > <br>예를 들어 모든 메소드가 static이고 객체 생성이 불필요한 클래스의 경우
  > <br>생성자를 private으로 선언하면 객체 생성이 불가해짐
- 객체 생성 관리
  > 정적 팩토리 메소드 장점 내용 참고
- 인자 제한, 생성 위임
  > 객체 생성 시 값이 지정 되어야 하는 인스턴스 필드들 중 일부의 값만 받아서 생성하고 싶을 때
  > <br>모든 인스턴스 필드의 값을 인자로 받는 생성자를 정의하되, private으로 선언하고
  > <br>일부 인자만 받는 public 생성자를 정의.
  > <br>이때 public 생성자에서 private 생성자 호출 (생성 위임)
  ```java
  public class ValueTypeClass {

      private final String value;
      private final String type;

      public ValueTypeClass(int x) {
          this(Integer.toString(x), "int");
      }

      public ValueTypeClass(boolean x) {
          this(Boolean.toString(x), "boolean");
      }

      private ValueTypeClass(String value, String type) {
          this.value = value;
          this.type = type;
      }
  }
  ```
  (코드 출처 : https://codechacha.com/ko/java-private-constructor/)