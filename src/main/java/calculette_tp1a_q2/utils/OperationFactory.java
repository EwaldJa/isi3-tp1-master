package calculette_tp1a_q2.utils;

import calculette_tp1a_q2.utils.exceptions.IncorrectOperatorException;
import calculette_tp1a_q2.utils.exceptions.UnsupportedOperationException;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class OperationFactory {

    /**
     * Runs through all classes implementing Operation interface to get their operator
     * @return char[] containing all the supported operators
     * @see Operation
     */
    public static char[] getSupportedOperators() {
        Reflections reflections = new Reflections("calculette_tp1a_q2.utils.operations"); /*Gets the specified package*/
        ArrayList<Class<? extends Operation>> classes = new ArrayList<>(reflections.getSubTypesOf(Operation.class)); /*Gets the classes of the specified package implementing Operation interface */
        char[] supportedOperators = new char[classes.size()];
        int i = 0;
        for(Class operation:classes) {
            try {
                supportedOperators[i] = (char) operation.getDeclaredField("OPERATOR").get(new Object()); /*Récupère le champ OPERATOR*/
                i++; }
            catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace(); } }
        return supportedOperators;
    }

    /**
     * Instantiate a returns an Operation of a class implementing Operation interface
     * Is idiot-proof
     * @param input String supposed to contain only one character representing a valid operator as of getSupportedOperators() method
     * @return an Operation instance of the operation matching specified operator in the input
     * @throws IncorrectOperatorException if the input is not valid (length or null) or if the operator specified does not match any valid implemented operation
     * @throws UnsupportedOperationException if the requested operation is currently getting implemented or if an unknown error occurs, see exception.getMessage() for more info
     * @see #getSupportedOperators()
     */
    public static Operation getOperation(String input) throws IncorrectOperatorException, UnsupportedOperationException {
        if (input.length() > 1) {
            throw new IncorrectOperatorException("The operator input is too long, expected length of 1 char ("+input.length()+" instead) : " + input); }
        else if (input.length() == 0) {
            throw new IncorrectOperatorException("The operator input is empty, expected length of 1 char : " + input); }
        else {
            char operator = input.charAt(0);
            Reflections reflections = new Reflections("calculette_tp1a_q2.utils.operations"); /*Gets the specified package*/
            ArrayList<Class<? extends Operation>> classes = new ArrayList<>(reflections.getSubTypesOf(Operation.class)); /*Gets the classes of the specified package implementing Operation interface */
            for(Class operation:classes) {
                try {
                    Constructor<?> cons = operation.getConstructor(null);
                    Operation op = (Operation) cons.newInstance();
                    if (op.matchOperator(operator)) { return op; } }
                catch (Exception e) {
                    throw new UnsupportedOperationException("This operation is not supported currently : " + operator, e); } }
            throw new IncorrectOperatorException("The operator input does not match any implemented operation : " + operator); }
    }

    /**
     * Prints the classes representing operations as of Question 2 of TP1A
     */
    public static void printImplementations() {
        Reflections reflections = new Reflections("calculette_tp1a_q2.utils.operations");
        ArrayList<Class<? extends Operation>> classes = new ArrayList<>(reflections.getSubTypesOf(Operation.class));
        classes.forEach(System.out::println);
    }

}
