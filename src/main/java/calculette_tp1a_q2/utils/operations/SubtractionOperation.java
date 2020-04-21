package calculette_tp1a_q2.utils.operations;

import calculette_tp1a_q2.utils.exceptions.Operation;

public class SubtractionOperation implements Operation {

    /**
     * Represents the operator of this subtraction operation
     */
    public static final char OPERATOR = '-';

    /**
     * Returns whether specified char is the good operator for the subtraction operation as defined with the constant or not
     * @param operator the char to check
     * @return true if good operator, false otherwise
     * @see #OPERATOR
     */
    public boolean matchOperator(char operator) {
        return operator == OPERATOR;
    }

    /**
     * Subtracts d2 to d1
     * @param d1 double
     * @param d2 double
     * @return double, the result of d2 subtracted to d1
     */
    public double calculate(double d1, double d2) {
        return d1-d2;
    }
}
