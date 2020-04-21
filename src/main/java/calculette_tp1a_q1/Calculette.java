package calculette_tp1a_q1;


public class Calculette
{
    /**
     * Sums the 2 parameters
     * @param d1 double
     * @param d2 double
     * @return double, the result of the addition of the two params
     */
	public static double add(double d1, double d2) { return d1+d2; }

    /**
     * Subtracts d2 to d1
     * @param d1 double
     * @param d2 double
     * @return double, the result of d2 subtracted to d1
     */
    public static double substract(double d1, double d2) { return d1-d2; }

    /**
     * Multiplies the 2 parameters
     * @param d1 double
     * @param d2 double
     * @return double, the result of the multiplication of the two params
     */
    public static double multiply(double d1, double d2) { return d1*d2; }

    /**
     * Divides d1 by d2
     * @param d1 double
     * @param d2 double
     * @return double, the result of the division of d1 by d2
     */
    public static double divide(double d1, double d2) { return d1/d2; }
}
