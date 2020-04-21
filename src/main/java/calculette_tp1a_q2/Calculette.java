package calculette_tp1a_q2;


import calculette_tp1a_q2.utils.Operation;
import calculette_tp1a_q2.utils.OperationFactory;
import calculette_tp1a_q2.utils.exceptions.IncorrectOperatorException;
import calculette_tp1a_q2.utils.exceptions.UnsupportedOperationException;

public class Calculette
{
    public static String supportedOperationsToString() {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        char[] operators = OperationFactory.getSupportedOperators();
        for (int i = 0; i < operators.length - 1; i++) {
            sb.append(operators[i]);
            sb.append(',');
        }
        if (operators.length >=1) {
            sb.append(operators[operators.length - 1]);
        }
        sb.append(']');
        return sb.toString();
    }

    public static double calculate(String operator, double d1, double d2) throws IncorrectOperatorException, UnsupportedOperationException {
        return calculate(OperationFactory.getOperation(operator), d1, d2);
    }

    public static double calculate(Operation operation, double d1, double d2) {
        return operation.calculate(d1, d2);
    }
}
