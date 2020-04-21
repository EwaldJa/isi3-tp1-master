package calculette_tp1a_q2;

import calculette_tp1a_q2.utils.exceptions.IncorrectOperatorException;
import calculette_tp1a_q2.utils.exceptions.UnsupportedOperationException;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		//OperationFactory.printImplementations(); vérification pour les classes qui implémentent Operation

		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez l'operateur (" + Calculette.supportedOperationsToString() + ") : ");
		String c = sc.nextLine();
		System.out.println("Saisissez le 1er nombre");//saisir avec , et pas .
		Float c1 = sc.nextFloat();
		System.out.println("Saisissez le 2nd nombre");
		Float c2 = sc.nextFloat();

		try {
			System.out.println("The result of the operation is : " + Calculette.calculate(c, c1, c2)); }
		catch (IncorrectOperatorException | UnsupportedOperationException e) {
			e.printStackTrace(); }
	}
}
