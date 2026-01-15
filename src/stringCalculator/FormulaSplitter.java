package stringCalculator;

public class FormulaSplitter {

    public String[] split(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException("계산식이 비어있거나 null입니다.");
        }
        return formula.split(" ");
    }
}
