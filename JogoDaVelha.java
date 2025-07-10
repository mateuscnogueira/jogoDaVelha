import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    String resposta = "";

    do {
        int i = 0, j = 0, jogada = 1;
        char matriz[][] = new char[3][3];
        String vencedor = "Empate";
        boolean pararLoop = false;
    
        System.out.println("\n\nJOGO DA VELHA\n");
        matriz = atribuirValores(matriz, i, j);
        imprimirMatriz(matriz, i, j);
    
        while (jogada <= 9 && !pararLoop) {
            System.out.println("\nJogada " + jogada);
            matriz = jogadorX(matriz, i, j, leitor, jogada);
            jogada++;
            imprimirMatriz(matriz, i, j);
    
            vencedor = verificarDiagonal(matriz, vencedor);
            vencedor = verificarLinhas(matriz, vencedor);
            vencedor = verificarColunas(matriz, vencedor);
    
            if (!vencedor.equals("Empate")) {
                pararLoop = true;
            } else {
                if (jogada <= 9) {
                    System.out.println("\nJogada " + jogada);
                    matriz = jogadorO(matriz, i, j, leitor, jogada);
                    jogada++;
                    imprimirMatriz(matriz, i, j);
        
                    vencedor = verificarDiagonal(matriz, vencedor);
                    vencedor = verificarLinhas(matriz, vencedor);
                    vencedor = verificarColunas(matriz, vencedor);
        
                    if (!vencedor.equals("Empate")) {
                        pararLoop = true;
                    }
                }
            }
        }
    
        System.out.println(vencedor);

        boolean entradaValida = false;

        while(!entradaValida) {
            System.out.print("Deseja jogar novamente? (sim/não): ");
            resposta = leitor.next().toLowerCase();

            if (resposta.equals("sim") || resposta.equals("nao") || resposta.equals("não")) {
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida! Digite apenas 'sim' ou 'não'.\n");
            }
        }

    } while (resposta.equals("sim"));

    System.out.println("\n\nFim do jogo. Obrigado por jogar!\n");
    }


	static char[][] atribuirValores (char matriz[][], int i, int j) {
		for (i=0; i<3; i++) {
			for (j=0; j<3; j++) {
				matriz[i][j] = '-';
			}
		}
		return matriz;
	}

	static void imprimirMatriz (char matriz[][], int i, int j) {
		for (i=0; i<3; i++) {
			for (j=0; j<3; j++) {
				System.out.print("  " + matriz[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static char[][] jogadorX(char matriz[][], int i, int j, Scanner leitor, int jogada) {
        while (true) {
            try {
                System.out.println("Jogador X - Entre com posição da linha que deseja jogar (0, 1 ou 2): ");
                i = leitor.nextInt();
                System.out.println("Jogador X - Entre com posição da coluna que deseja jogar (0, 1 ou 2): ");
                j = leitor.nextInt();

                if (i >= 0 && i < 3 && j >= 0 && j < 3) {
                    if (matriz[i][j] == '-') {
                        matriz[i][j] = 'x';
                        return matriz;
                    } else {
                        System.out.println("Essa posição já foi usada. Tente novamente.\n");
                    }
                } else {
                    System.out.println("Posição inválida! Use apenas valores 0, 1 ou 2.\n");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite apenas números inteiros.\n");
            }
        }
    }

	static char[][] jogadorO(char matriz[][], int i, int j, Scanner leitor, int jogada) {
        while (true) {
            try {
                System.out.println("Jogador O - Entre com posição da linha que deseja jogar (0, 1 ou 2): ");
                i = leitor.nextInt();
                System.out.println("Jogador O - Entre com posição da coluna que deseja jogar (0, 1 ou 2): ");
                j = leitor.nextInt();

                if (i >= 0 && i < 3 && j >= 0 && j < 3) {
                    if (matriz[i][j] == '-') {
                        matriz[i][j] = 'o';
                        return matriz;
                    } else {
                        System.out.println("Essa posição já foi usada. Tente novamente.\n");
                    }
                } else {
                    System.out.println("Posição inválida! Use apenas valores 0, 1 ou 2.\n");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite apenas números inteiros.\n");
                leitor.nextLine();
            }
        }
    }

	static String verificarDiagonal (char matriz[][], String vencedor) {
		if (!vencedor.equals("Empate")) {
        return vencedor;
    	}
		if ((matriz[0][0] == 'x' && matriz[1][1] == 'x' && matriz[2][2] == 'x') || (matriz[2][0] == 'x' && matriz[1][1] == 'x' && matriz[0][2] == 'x')) {
			vencedor = "O jogador X venceu";
		} else {
			if ((matriz[0][0] == 'o' && matriz[1][1] == 'o' && matriz[2][2] == 'o') || (matriz[2][0] == 'o' && matriz[1][1] == 'o' && matriz[0][2] == 'o')) {
				vencedor = "O jogador O venceu";
			}
		}
		return vencedor;
	}

	static String verificarLinhas (char matriz[][], String vencedor) {
		if (!vencedor.equals("Empate")) {
        return vencedor;
    	}
		if ((matriz[0][0] == 'x' && matriz[0][1] == 'x' && matriz[0][2] == 'x') || (matriz[1][0] == 'x' && matriz[1][1] == 'x' && matriz[1][2] == 'x') || (matriz[2][0] == 'x' && matriz[2][1] == 'x' && matriz[2][2] == 'x')) {
			vencedor = "O jogador X venceu";
		} else {
			if ((matriz[0][0] == 'o' && matriz[0][1] == 'o' && matriz[0][2] == 'o') || (matriz[1][0] == 'o' && matriz[1][1] == 'o' && matriz[1][2] == 'o') || (matriz[2][0] == 'o' && matriz[2][1] == 'o' && matriz[2][2] == 'o')) {
				vencedor = "O jogador O venceu";
			}
		}
		return vencedor;
	}

	static String verificarColunas (char matriz[][], String vencedor) {
		if (!vencedor.equals("Empate")) {
        return vencedor;
    	}
		if ((matriz[0][0] == 'x' && matriz[1][0] == 'x' && matriz[2][0] == 'x') || (matriz[0][1] == 'x' && matriz[1][1] == 'x' && matriz[2][1] == 'x') || (matriz[0][2] == 'x' && matriz[1][2] == 'x' && matriz[2][2] == 'x')) {
			vencedor = "O jogador X venceu";
		} else {
			if ((matriz[0][0] == 'o' && matriz[1][0] == 'o' && matriz[2][0] == 'o') || (matriz[0][1] == 'o' && matriz[1][1] == 'o' && matriz[2][1] == 'o') || (matriz[0][2] == 'o' && matriz[1][2] == 'o' && matriz[2][2] == 'o')) {
				vencedor = "O jogador O venceu";
			}
		}
		return vencedor;
	}
}