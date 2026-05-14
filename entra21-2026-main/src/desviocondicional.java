import java.util.Scanner;

public class desviocondicional {

	public static void main(String[] args) {
		//exercicio1();
		//exercicio2();
		//exercicio3();
		//exercicio4();
		//exercicio5();
		//exercicio6();
		//exercicio7();
		//exercicio8();
		//exercicio9();
		//exercicio10();
		//exercicio11();
		//exercicio12();
		//exercicio13();
		exercicio14();
	}
	
	static void exercicio1() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("Digite um número: ");
		int numero1 = entradaUser.nextInt();
		
		if (numero1 % 2 == 0) {
			System.out.println("O número é par.");
		} else { 
			System.out.println("O número é ímpar.");
		}
	}
	
	static void exercicio2() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("Digite um número: ");
		int numero1 = entradaUser.nextInt();
		
		System.out.print("Digite o segundo número: ");
		int numero2 = entradaUser.nextInt();
		
		if (numero1 > numero2) {
			System.out.println("O maior número é: " + numero1);
		} else if (numero2 > numero1) {
			System.out.println("O maior número é: " + numero2);
			
		} else {
			System.out.println("Os dois números são iguais.");
		}
		
	}
	
	static void exercicio3() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("Digite o primeiro número: ");
		int numero1 = entradaUser.nextInt();
		
		if (numero1 > 0) {
			System.out.println("Seu número é positivo.");
		} else if (numero1 < 0) {
			System.out.println("Seu número é negativo. ");
		} else {
			System.out.println("O valor do seu número é 0.");
		}
	}
	
	static void exercicio4() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("Digite sua nota: ");
		int nota = entradaUser.nextInt();
		
		if (nota > 6) {
			System.out.println("Parabéns, você foi APROVADO!");
		} if (nota < 6) {
			System.out.println("Desculpe, você foi REPROVADO.");
		}
	}
	
	static void exercicio5() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("Por favor, digite sua idade: ");
		int idade = entradaUser.nextInt();
		
		if (idade >= 16) {
			System.out.println("Você ESTÁ está apto a votar.");
		} else {
			System.out.println("Você NÃO apto a votar!");
		}
	}
	
	static void exercicio6() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("Digite o primeiro número: ");
		int numero1 = entradaUser.nextInt();
		
		System.out.print("Digite o segundo número: ");
		int numero2 = entradaUser.nextInt();
		
		System.out.print("Digite o terceiro número: ");
		int numero3 = entradaUser.nextInt();
		
		if (numero1 >= numero2 && numero1 >= numero3) {
			System.out.println("O maior número é: " + numero1);
		} else if (numero2 >= numero1 && numero2 >= numero1) {
			System.out.println("O maior número é: " + numero2);
		} else {
			System.out.println("O maior número é: " + numero3);
		}
	}
	
	static void exercicio7() {
		Scanner entradaUser = new Scanner(System.in);
		
		System.out.print("Digite a nota: ");
		int nota = entradaUser.nextInt();
		
		if (nota <= 4) {
			System.out.println("Insuficiente.");
		} else if (nota <= 6) {
			System.out.println("Regular.");
		} else if (nota <= 8) {
			System.out.println("Bom.");
		} else {
			System.out.println("Excelente.");
		}
	}
	
	static void exercicio8() {
		Scanner entradaUser = new Scanner(System.in);
		
		System.out.println("Digite o valor do primerio lado: ");
		int lado1 = entradaUser.nextInt();
		
		System.out.println("Digite o valor do segundo lado: ");
		int lado2 = entradaUser.nextInt();
		
		System.out.println("Digite o valor do terceiro lado: ");
		int lado3 = entradaUser.nextInt();
		
		if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
			System.out.println("Forma um triângulo!");
		} else { 
			System.out.println("Não forma um triângulo.");
			
		}
	}
	
	static void exercicio9() {
		Scanner entradaUser = new Scanner(System.in);
		
		 System.out.print("Digite o primeiro lado: ");
	        int lado1 = entradaUser.nextInt();
	        
	     System.out.print("Digite o segundo lado: ");
	        int lado2 = entradaUser.nextInt();
	        
	     System.out.print("Digite o terceiro lado: ");
	        int lado3 = entradaUser.nextInt();
	        
	        if (lado1 == lado2 && lado2 == lado3) {
                System.out.println("Triângulo Equilátero");
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                System.out.println("Triângulo Isósceles");
            } else {
                System.out.println("Triângulo Escaleno");
            }

	}
	
	static void exercicio10() {
		Scanner entradaUser = new Scanner(System.in);
		
		String adminCorreto = "admin";
		String senhaCorreta = "1234";
		
		System.out.print("Qual o usuário? ");
		String admin = entradaUser.next();
		
		System.out.print("Qual a senha? ");
		String senha = entradaUser.next();
		
		if (admin.equals(adminCorreto) && senha.equals(senhaCorreta)) {
			System.out.println("Acesso permitido");
		} else {
			System.out.println("Acesso NEGADO");
		}
	}
	
	static void exercicio11() {
		 Scanner entradaUser = new Scanner(System.in);

		    System.out.print("Digite um ano: ");
		    int ano = entradaUser.nextInt();

		    if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
		        System.out.println(ano + " É um ano bissexto");
		    } else {
		        System.out.println(ano + " Não é um ano bissexto");
		    }
		    
	}		
	
	static void exercicio12() {
		 Scanner entradaUser = new Scanner(System.in);

		    System.out.print("Digite o primeiro valor: ");
		    double valor1 = entradaUser.nextDouble();

		    System.out.print("Digite o segundo valor: ");
		    double valor2 = entradaUser.nextDouble();

		    System.out.print("Qual operação realizar? (+, -, *, /): ");
		    char operacao = entradaUser.next().charAt(0);

		    double resultado;

		    if (operacao == '+') {
		        resultado = valor1 + valor2;
		    } else if (operacao == '-') {
		        resultado = valor1 - valor2;
		    } else if (operacao == '*') {
		        resultado = valor1 * valor2;
		    } else if (operacao == '/') {
		        if (valor2 != 0) {
		            resultado = valor1 / valor2;
		        } else {
		            System.out.println("Erro: divisão por zero!");
		            entradaUser.close();
		            return;  // sai do método para não usar resultado não inicializado
		        }
		    } else {
		        System.out.println("Operação inválida!");
		        entradaUser.close();
		        return;
		    }

		    System.out.println("Resultado: " + resultado);
		    entradaUser.close();
		}
	
	static void exercicio13() {
		Scanner entradaUser = new Scanner(System.in);

        System.out.print("Digite o salário: R$ ");
        double salario = entradaUser.nextDouble();
        double imposto = 0;
        
        if (salario <= 2000) {
            imposto = 0;
        } else if (salario <= 3500) {
            imposto = salario * 0.10; // 10%
        } else if (salario <= 5000) {
            imposto = salario * 0.15; // 15%
        } else {
            imposto = salario * 0.20; // 20%
        }

        System.out.println("Salário: R$ " + salario);
        System.out.println("Imposto a pagar: R$ " + imposto);

	}
	
	static void exercicio14() {
		Scanner entradaUser = new Scanner(System.in);
		
		System.out.print("Qual o valor da compra? ");
		double valor = entradaUser.nextDouble();
		
		double desconto = 0;
		
		if (valor <= 100) {
			desconto = 0;
		} else if (valor < 500) {
			desconto = valor * 0.10;
		} else {
			desconto = valor * 0.20;
		}
		
		double valorFinal = valor - desconto;
		
		System.out.println("Valor da compra: R$ " + valor);
        System.out.println("Desconto aplicado: R$ " + desconto);
        System.out.println("Valor final: R$ " + valorFinal);

	}
				
	
	}

