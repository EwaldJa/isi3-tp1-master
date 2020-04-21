package calculette_tp1a_q2;

import calculette_tp1a_q2.utils.exceptions.OperationFactory;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		OperationFactory.printImplementations();
		char[] operators = OperationFactory.getSupportedOperators();
		for(char op:operators) { System.out.println(op); }
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisissez l'operateur");
		String c = sc.nextLine();
		System.out.println("Saisissez le 1er nombre");//saisir avec , et pas .
		Float c1 = sc.nextFloat();
		System.out.println("Saisissez le 2nd nombre");
		Float c2 = sc.nextFloat();
*/


  }
}
