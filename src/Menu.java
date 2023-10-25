import java.util.Scanner;

public class Menu {
    public static int mainMenu() {
        int resposta = 0;
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("MENU");
            Integer numProcessadores = Programa.numProcessadores();
            System.out.println("Sua máquina possui " + numProcessadores + " processadores.");
            int opcao = 0;

            do {
                System.out.println("Escolha uma opção:");
                System.out.println("[1] - Tamanho do vetor: 800.000");
                System.out.println("[2] - Tamanho do vetor: 1.000.000");
                System.out.println("[3] - Tamanho do vetor: 1.000.000.000");

                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    if (opcao < 1 || opcao > 3) {
                        System.out.println("Opção inválida. Escolha uma opção de 1 a 3.");
                    }
                } else {
                    System.out.println("Entrada inválida. Digite um número de 1 a 3.");
                    scanner.next();
                }
            } while (opcao < 1 || opcao > 3);

            switch (opcao) {
                case 1:
                    System.out.println("Opção 1 selecionada.");
                    resposta = 800000;
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada.");
                    resposta = 1000000000;
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada.");
                    resposta = 1000000000;
                    break;
            }

            return resposta;

        } catch (Exception e) {
            e.printStackTrace();
            return resposta;
        }
    }
}




