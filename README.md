# java-calculator-precourse

## 🚀 주요 기능

- <b>숫자 합 계산</b> : 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 각 숫자의 합을 반환
- <b>커스텀 구분자 지정</b> : 쉼표와 콜론 외에 자신이 원하는 커스텀 구분자를 지정할 수 있다.


## ⚙️ 기능 목록 단위

1. 쉼표 또는 콜론을 구분자로 가지는 문자열로 전달하는 경우, 구분자를 기준으로 숫자 합 반환
2. 숫자합이 제대로 계산되는지 테스트
3. 예외 처리(IllegalArgumentException)
    - 숫자가 아닌 포맷 입력 시 예외처리
    - int가 넘어가는 값 넘어갈 시 예외처리
4. 예외 처리 테스트
5. 커스텀 구분자 적용 기능
6. 커스텀 구분자 적용 테스트
7. 커스텀 구분자에 숫자를 넣을 때 예외 처리
8. 커스텀 구분자에 숫자를 넣을 경우 테스트
9. 객체지향, DDD 구조에 맞게 구조 리팩토링

## 🎨 설계 패턴
본 과제는 MVC 아키텍처를 기반으로, DDD(도메인 주도 설계)의 계층적 책임 분리를 적용하였다.
또한 SRP(단일 책임 원칙)을 준수하여 유연하고 확장 가능한 구조를 목표로 설계하였다.


## 주요 컴포넌트 설명

### **InputView**

- 콘솔로부터 문자열 입력을 받아 `Input` 객체로 래핑
- 빈 입력도 그대로 전달 

### **OutputView**

- 계산 결과를 콘솔에 출력
- `System.out.println("결과 : " + result)` 형태로 출력

### **Input**

- 불변(`record`) 객체로, 원본 입력 문자열을 표현
- `null`이나 빈 문자열 허용 (0으로 처리됨)

### **CalculatorService**

- 애플리케이션 계층에서 흐름 제어 역할
- 입력이 비어 있으면 `0` 반환, 그렇지 않으면 `Calculator`에 위임

### **Calculator (추상 클래스)**

- 계산의 공통 인터페이스 정의
- 하위 클래스(`CustomCalculator`)가 실제 로직 구현

### **CustomCalculator**

- 커스텀 구분자(`//;\n` 형태)를 해석하고 덧셈 수행
- `CalculatorFactory`에서 전달받은 `ParsingPolicy`를 기반으로 로직 수행
- 음수, 잘못된 입력 형식, 구분자 숫자 사용 시 `IllegalArgumentException` 발생

### **CalculatorFactory**

- 입력 문자열에서 구분자 정책을 추출
- `"//{delimiter}\n"` 패턴 여부에 따라 `ParsingPolicy` 반환
- 상수 정의:
  - `CUSTOM_DELIMITER_START_INDEX = 5`
  - `DEFAULT_START_INDEX = 0`

### **ParserNumber**

- 문자열을 안전하게 정수로 변환
- **예외 상황:**

   * 음수 입력 시 `IllegalArgumentException`
   * 숫자 형식 오류 시(int 범위를 넘어간 경우도 포함) `IllegalArgumentException`

