package calculette_tp1a_q2.utils;

/**
 * Any class implementing Operation interface MUST have a char field named OPERATOR representing the operator of the operation
 */
public interface Operation {

    /**
     * Returns whether specified char is the good operator for the operation or not
     * @param operator the char to check
     * @return true if good operator, false otherwise
     */
    default public boolean matchOperator(char operator) { return  operator == getOperator(); }

    /**
     * Calculates the result of the operation
     * @param d1 double the first parameter
     * @param d2 double the second parameter
     * @return double the result of the operation
     */
    public double calculate(double d1, double d2);

    /**
     * @return char the operator of the operation
     */
    public char getOperator();
}
