package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();
    FormulaSplitter splitter = new FormulaSplitter();

    @DisplayName("입력 순서대로 연산 테스트")
    @Test
    void inputOrderOperationTest() {
        String[] input = {"2","+","3","*","4","/","5"};
        int result = calculator.calculate(input);
        assertEquals(4,result);
    }

    @DisplayName("입력값이 null")
    @Test
    void inputNullTest() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> splitter.split(null));

        assertTrue(exception.getMessage().contains("계산식이 비어있거나 null"));
    }

    @DisplayName("입력값이 공백")
    @Test
    void testBlankInput() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> splitter.split(" "));
        assertTrue(exception.getMessage().contains("계산식이 비어있거나 null"));
    }

    @DisplayName("0으로 나누기")
    @Test
    void zeroDivideTest() {
        String[] input = {"10", "/", "0"};

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(input));

        assertTrue(exception.getMessage().contains("0으로 나눌 수 없습니다."));
    }

    @DisplayName("숫자가 아닌 문자열 입력")
    @Test
    void invalidNumberTest() {
        String[] input = {"abc"};

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(input));

        assertTrue(exception.getMessage().contains("숫자가 아닌 값"));
    }

    @DisplayName("지원하지 않는 연산자 입력")
    @Test
    void unsupportedOperatorTest() {
        String[] input = {"2", "&", "3"};

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(input));

        assertTrue(exception.getMessage().contains("지원하지 않는 연산자"));
    }

    @DisplayName("연산자 뒤에 숫자를 입력하지 않았을 때")
    @Test
    void operatorWithoutNumberTest() {
        String[] input = {"2", "+"};

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(input));

        assertTrue(exception.getMessage().contains("잘못된 계산식"));
    }


}
