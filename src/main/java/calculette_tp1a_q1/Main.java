package calculette_tp1a_q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez l'operateur [+,-,*,/]");
		String c = sc.nextLine();
		System.out.println("Saisissez le 1er nombre (incluez une virgule, si c'est un entier saisissez 5,0 par exemple)");//saisir avec , et pas .
		Float c1 = sc.nextFloat();
		System.out.println("Saisissez le 2nd nombre (incluez une virgule, si c'est un entier saisissez 5,0 par exemple)");
		Float c2 = sc.nextFloat();

		if (c.length() > 1) {
            System.err.println("The operator input is too long, expected length of 1 char ("+c.length()+" instead) : " + c);
        }
		else if (c.length() == 0) {
            System.err.println("The operator input is empty, expected length of 1 char : " + c);
        }
		else {
            switch (c.charAt(0)) {
                case '+':
                    System.out.println("The result of (" + c1 + " + " + c2 + ") is : " + Calculette.add(c1, c2));
                    break;
                case '-':
                    System.out.println("The result of (" + c1 + " - " + c2 + ") is : " + Calculette.substract(c1, c2));
                    break;
                case '*':
                    System.out.println("The result of (" + c1 + " * " + c2 + ") is : " + Calculette.multiply(c1, c2));
                    break;
                case '/':
                    System.out.println("The result of (" + c1 + " / " + c2 + ") is : " + Calculette.divide(c1, c2));
                    break;
                default:
                    System.err.println("The operator couldn't be recognised : " + c);
                    break;

            }
        }


  }
}
