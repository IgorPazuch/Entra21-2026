import java.util.Scanner;

public class vetores {

	public static void main(String[] args) {
		//exemplo();
		//exercicio1();
		exercicio2();

	}
	
	static void exemplo() {
		String[] cars = {"volvo", "BMW", "ford", "mazda"};
		
		System.out.println(cars[0]);
		System.out.println(cars[1]);
		
		cars[2] = "ferrari";
		System.out.println(cars[2]);
		
		System.out.println("");
		//for indexado
		for(int i = 0; i < cars.length; i++) {
			System.out.println(i + "-> " + cars[i]);
		}
		
		System.out.println("");
		int x = 0;
		while(x < cars.length) {
			System.out.println(x + "-> " + cars[x]);
			x++;
		}
		//não indexado - iterativo
		System.out.println("");
		for(String c : cars) {
			System.out.println(c);
			
		}
	}
	
	static void exercicio1() {
		Scanner entradaUser = new Scanner(System.in);
		
		int[] numeros = new int[5];
		
		for(int i = 0; i < numeros.length; i++) {
			System.out.print("Digite o número para a posição " + i + ": ");
			numeros[i] = entradaUser.nextInt();
			
		}	
		
		System.out.println("O dobro dos valores: ");
		
		for(int n : numeros) {
			System.out.println(n * 2);
		}
	}
	
	static void exercicio2() {
		Scanner entradaUser = new Scanner(System.in);
		
		int[] numeros = new int[10];
		
		for(int i = 0; i < numeros.length; i++) {
			System.out.print("Digite o número " + i + ": ");
			numeros[i] = entradaUser.nextInt();
		}
		
		for(int n : numeros) {
			if(n % 2 == 0) {
				System.out.println(n + " é PAR");
			} else {
				System.out.println(n + " é ÍMPAR");
			}
		}
	}
	
	static void listarVetores(int[] dados) {
		for(int n : dados) {
			System.out.println(n * 2);
		}
	}
	

}
