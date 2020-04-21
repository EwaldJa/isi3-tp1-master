package calculette_tp1a_q2.utils.operations;

import calculette_tp1a_q2.utils.Operation;

public class MultiplicationOperation implements Operation {

    /**
     * Represents the operator of this multiplication operation
     */
    public static final char OPERATOR = '*';

    /**
     * Returns whether specified char is the good operator for the multiplication operation as defined with the constant or not
     * @param operator the char to check
     * @return true if good operator, false otherwise
     * @see #OPERATOR
     */
    public boolean matchOperator(char operator) {
        return operator == getOperator();
    }

    /**
     * Multiplies the 2 parameters
     * @param d1 double
     * @param d2 double
     * @return double, the result of the multiplication of the two params
     */
    public double calculate(double d1, double d2) {
        return d1*d2;
    }

    /**
     * @return char the operator of the multiplication operation
     */
    public char getOperator() { return OPERATOR; }
}
