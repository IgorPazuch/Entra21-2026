import java.util.Scanner;

public class jogodavelha {

	
	
	static char [][] tabuleiro = {
			{' ', ' ', ' '},
			{' ', ' ', ' '},
			{' ', ' ', ' '}
	};
	static void mostrarTabuleiro() {
		System.out.println("------------");
		for (int i=0; i < 3; i++) {
			System.out.print("| ");
			for (int j=0; j < 3; j++) {
				System.out.print(tabuleiro [i][j] + " | ");
			}
			System.out.println("\n------------");
		}
	}
	static void jogar(char jogador) {
		Scanner sc = new Scanner(System.in);
		
		mostrarTabuleiro();
		
		System.out.println("Digite a linha: ");
		int linha = sc.nextInt();
		System.out.println("Digite a coluna: ");
		int coluna = sc.nextInt();
		
		if (tabuleiro[linha][coluna] == ' ') {
			tabuleiro[linha][coluna] = jogador;
		}
		else {
			System.out.println("O espaço já está ocupado.");
			jogar (jogador);
		}
	}
	
	public static boolean verificarVitoria(char jogador) {
		for (int i=0; i < 3; i++) {
			if ((tabuleiro[i][0] == jogador&&tabuleiro[i][1] == jogador&&tabuleiro[i][2] == jogador)||
					(tabuleiro[0][i] == jogador&&tabuleiro[1][i] == jogador&&tabuleiro[2][i] == jogador)) {
				System.out.println("Parabéns " + jogador + " você venceu.");
				return true;
			}
			if ((tabuleiro[0][0] == jogador&&tabuleiro[1][1] == jogador&&tabuleiro[2][2] == jogador)||
					(tabuleiro[0][2] == jogador&&tabuleiro[1][1] == jogador&&tabuleiro[2][0] == jogador)) {
				System.out.println("Parabéns " + jogador + " você venceu.");
				return true;
			}
			
		}
		return false;
	}
	public static boolean verificarEmpate() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(tabuleiro[i][j]==' ') {
					return false;
				}
			}
		}
		System.out.println("Empate.");
		return true;
	}
	public static void main(String[] args) {
		while (true) {
			jogar ('x');
			if (verificarVitoria('x')==true||verificarVitoria('o')==true||verificarEmpate()==true) {
				break;
			}
			jogar ('o');
			if (verificarVitoria('x')==true||verificarVitoria('o')==true||verificarEmpate()==true) {
				break;
			
		}
	}

}
}
