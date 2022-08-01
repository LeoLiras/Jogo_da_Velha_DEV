package Jogo_da_Velha;

import java.util.Scanner;

public class Jogo_da_Velha {

	public static void main(String[] args) {
		//Criação da matriz e iniciação do jogo.
		int matriz[][] = criarMatriz();
		mostraMatriz(matriz);
		jogoDaVelha(matriz);
	}
	
	
	/**
	 * Método que cria a matriz
	 * @return A própria matriz.
	 */
	public static int[][] criarMatriz(){
		//Cria uma matriz 3x3.
		int matriz[][] = new int [3][3];
		
		//Preenche a matriz toda com o valor 0.
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = 0;
			}		
		}
		
		return matriz;	
	}
	
	/**
	 * Método que exibe a matriz no console.
	 * @param A matriz que foi criada.
	 */
	public static void mostraMatriz(int [][] matriz) {
		//Exibe a matriz no console no formato 3x3, simulando um jogo da velha.
		for(int i = 0; i < matriz.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + "   ");
			}
		}
		System.out.println("\n");
	}
	
	/**
	 * Método que inicia o jogo. É encerrado quando um dos jogadores ganha.
	 * @param A matriz que foi criada.
	 */
	public static void jogoDaVelha(int[][] matriz) {
		//Array que irá armazenar a linha e a coluna da jogada.
		int jogada[] = new int[2];
		int jogador = 1;
		Scanner teclado = new Scanner(System.in);
		
		//Laço que se repete enquanto nenhum dos jogadores ganhar o jogo ou enquanto não "dar velha".
		while(verificarJogo(matriz, 1) == false && verificarDeuVelha(matriz) == false) {
			jogador = 1;
			System.out.println("Jogador 1: ");
			System.out.println("Insira a linha da sua jogada: ");
			jogada[0] = teclado.nextInt();
			System.out.println("Insira a coluna da sua jogada: ");
			jogada[1] = teclado.nextInt();
			
			//Verifica e valida a jogada, atualizando a matriz.
			matriz = verificarJogada(matriz, jogada[0], jogada[1], jogador);
			mostraMatriz(matriz);
			
			//Verifica se "deu velha".
			if(verificarDeuVelha(matriz) == true) {
				System.out.println("Deu Velha!");
				break;
			}
			
			//Verifica se o jogador 1 venceu.
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
			
			//Verifica se "deu velha".
			if(verificarDeuVelha(matriz) == true) {
				System.out.println("Deu Velha!");
				break;
			}
			
			//Verifica se jogador 2 venceu.
			if(verificarJogo(matriz, 2) == true) {
				System.out.println("Jogador 2 venceu!!");
				break;
			}
		}
		
		teclado.close();
	}
	
	/**
	 * Método que verifica a jogada realizada, atualizando a matriz caso a jogada tenha sido validada.
	 * @param matriz 
	 * @param linha da jogada
	 * @param coluna da jogada
	 * @param jogador que realizou a jogada
	 * @return A matriz atualizada.
	 */
	public static int[][] verificarJogada(int[][] matriz, int linha, int coluna, int jogador) {
		//Verifica qual jogador realizou a jogada e se aquele índice já foi preenchido em jogadas anteriores, atualizando a matriz caso a jogada seja válida.
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
	
	/**
	 * Método que verifica se um dos jogadores venceu a partida.
	 * @param matriz
	 * @param Numero do jogador(1 ou 2).
	 * @return Resultado. Se true, um dos jogadores venceu e o programa encerra.
	 */
	public static boolean verificarJogo(int[][] matriz, int jogador_numero) {
		boolean resultado = false;
		//Checa todas as possibilidades de vitória e retorna true caso algum dos jogadores tenha ganho o jogo.
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
	
	/**
	 * Verifica se "deu velha", ou seja, se toda a matriz foi preenchida, mas nenhum dos jogadores conseguiu ganhar. Dessa maneira, o jogo termina em empate.
	 * @param matriz
	 * @return Se true: Deu velha.
	 */
	public static boolean verificarDeuVelha(int[][] matriz) {
		boolean deu_velha = false;
		
		//Checa se todos os índices da matriz já foram preenchidos com jogadas.
		if(matriz[0][0] != 0 && matriz[0][1] != 0 && matriz[0][2] != 0 && matriz[1][0] != 0 && matriz[1][1] != 0 && matriz[1][2] != 0 && matriz[2][0] != 0 && matriz[2][1] != 0 && matriz[2][2] != 0) {
			System.out.println("Deu Velha!");
			deu_velha = true;
		}
		
		return deu_velha;
	}
}
