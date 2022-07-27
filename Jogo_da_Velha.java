package secao7parte2;

import java.util.Scanner;

public class ex25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matriz[][] = criarMatriz();
		mostraMatriz(matriz);
		jogoDaVelha(matriz);
	}
	
	public static int[][] criarMatriz(){
		int matriz[][] = new int [3][3];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = 0;
			}		
		}
		
		return matriz;	
	}
	
	public static void mostraMatriz(int [][] matriz) {
		for(int i = 0; i < matriz.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "   ");
			}
		}
		System.out.println("\n");
	}
	
	public static void jogoDaVelha(int[][] matriz) {
		int jogada[] = new int[2];
		int jogador = 1;
		Scanner teclado = new Scanner(System.in);
		
		while(verificarJogo(matriz, 1) == false) {
			jogador = 1;
			System.out.println("Jogador 1: ");
			System.out.println("Insira a linha da sua jogada: ");
			jogada[0] = teclado.nextInt();
			System.out.println("Insira a coluna da sua jogada: ");
			jogada[1] = teclado.nextInt();
			
			matriz = verificarJogada(matriz, jogada[0], jogada[1], jogador);
			mostraMatriz(matriz);
			
			if(verificarJogo(matriz, 1) == true) {
				System.out.println("Jogador 1 venceu!!");
				break;
			}
			
			jogador = 2;
			System.out.println("Jogador 2: ");
			System.out.println("Insira a linha da sua jogada: ");
			jogada[0] = teclado.nextInt();
			System.out.println("Insira a coluna da sua jogada: ");
			jogada[1] = teclado.nextInt();
			
			matriz = verificarJogada(matriz, jogada[0], jogada[1], jogador);
			mostraMatriz(matriz);
			
			if(verificarJogo(matriz, 2) == true) {
				System.out.println("Jogador 2 venceu!!");
				break;
			}
		}
		
		teclado.close();
	}
	
	public static int[][] verificarJogada(int[][] matriz, int linha, int coluna, int jogador) {
		if(matriz[linha][coluna] == 0) {
			if(jogador == 1) {
				matriz[linha][coluna] = 1;
			}else if(jogador == 2) {
				matriz[linha][coluna] = 2;
			}
		}else {
			System.out.println("\nEste campo já foi preenchido, você perdeu a sua vez.\n");
		}
		
		return matriz;
	}
	
	public static boolean verificarJogo(int[][] matriz, int jogador_numero) {
		boolean resultado = false;
		if(matriz[0][0] == jogador_numero && matriz[0][1] == jogador_numero && matriz[0][2] == jogador_numero) {
			resultado = true;
		}else if(matriz[0][2] == jogador_numero && matriz[1][2] == jogador_numero && matriz[2][2] == jogador_numero) {
			resultado = true;
		}else if(matriz[2][0] == jogador_numero && matriz[2][1] == jogador_numero && matriz[2][2] == jogador_numero) {
			resultado = true;
		}else if(matriz[0][0] == jogador_numero && matriz[1][0] == jogador_numero && matriz[2][0] == jogador_numero) {
			resultado = true;
		}else if(matriz[0][0] == jogador_numero && matriz[1][1] == jogador_numero && matriz[2][2] == jogador_numero) {
			resultado = true;
		}else if(matriz[0][2] == jogador_numero && matriz[1][1] == jogador_numero && matriz[2][0] == jogador_numero) {
			resultado = true;
		}
		
		if(matriz[0][0] == jogador_numero && matriz[0][1] == jogador_numero && matriz[0][2] == jogador_numero) {
			resultado = true;
		}else if(matriz[0][2] == jogador_numero && matriz[1][2] == jogador_numero && matriz[2][2] == jogador_numero) {
			resultado = true;
		}else if(matriz[2][0] == jogador_numero && matriz[2][1] == jogador_numero && matriz[2][2] == jogador_numero) {
			resultado = true;
		}else if(matriz[0][0] == jogador_numero && matriz[1][0] == jogador_numero && matriz[2][0] == jogador_numero) {
			resultado = true;
		}else if(matriz[0][0] == jogador_numero && matriz[1][1] == jogador_numero && matriz[2][2] == jogador_numero) {
			resultado = true;
		}else if(matriz[0][2] == jogador_numero && matriz[1][1] == jogador_numero && matriz[2][0] == jogador_numero) {
			resultado = true;
		}
		
		return resultado;
	}
}
