package calculette_tp1a_q2.utils.exceptions;

import calculette_tp1a_q2.utils.operations.AdditionOperation;
import calculette_tp1a_q2.utils.operations.DivisionOperation;
import calculette_tp1a_q2.utils.operations.MultiplicationOperation;
import calculette_tp1a_q2.utils.operations.SubtractionOperation;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class OperationFactory {

    public static enum SupportedOperations {
        ADDITION('+'),
        SUBTRACTION('-'),
        MULTIPLICATION('*'),
        DIVISION('/');
        private char operator;

        SupportedOperations(char operator) {
            this.operator = operator;
        }

        public char operator() {
            return operator;
        }
    }



    public static Operation getOperation(String operator) throws IncorrectOperatorException, java.lang.UnsupportedOperationException {
        if (operator.length() > 1) {
            throw new IncorrectOperatorException("The operator input is too long, expected length of 1 char ("+operator.length()+" instead) : " + operator); }
        else if (operator.length() == 0) {
            throw new IncorrectOperatorException("The operator input is empty, expected length of 1 char : " + operator); }
        else {
            SupportedOperations operation;
            try {
                operation = SupportedOperations.valueOf(operator); }
            catch (IllegalArgumentException e) {
                throw new IncorrectOperatorException("Provided operator does not corresponds to any supported operation : " + operator, e); }
            switch (operation) {
                case ADDITION:
                    return new AdditionOperation();
                case SUBTRACTION:
                    return new SubtractionOperation();
                case MULTIPLICATION:
                    return new MultiplicationOperation();
                case DIVISION:
                    return new DivisionOperation();
                default:
                    /*Ne devrait jamais arriver, mais ne sait-on jamais*/
                    throw new java.lang.UnsupportedOperationException("This operation is currently unimplemented : " + operator); } } }
}
