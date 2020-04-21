package calculette_tp1a_q2.utils.operations;

import calculette_tp1a_q2.utils.exceptions.Operation;

public class AdditionOperation implements Operation {

    /**
     * Represents the operator of this addition operation
     */
    public static final char OPERATOR = '+';

    /**
     * Returns whether specified char is the good operator for the addition operation as defined with the constant or not
     * @param operator the char to check
     * @return true if good operator, false otherwise
     * @see #OPERATOR
     */
    public boolean matchOperator(char operator) {
        return operator == OPERATOR;
    }

    /**
     * Sums the 2 parameters
     * @param d1 double
     * @param d2 double
     * @return double, the result of the addition of the two params
     */
    public double calculate(double d1, double d2) {
        return d1+d2;
    }
}
