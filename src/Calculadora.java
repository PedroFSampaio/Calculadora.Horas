import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Calculadora de Horas");
            System.out.print("Digite a primeira hora (HH:MM:SS): ");
            String entrada1 = scanner.next();

            System.out.print("Digite a segunda hora (HH:MM:SS): ");
            String entrada2 = scanner.next();

            // Divide as entradas em horas, minutos e segundos
            String[] partes1 = entrada1.split(":");
            String[] partes2 = entrada2.split(":");

            int horas1 = Integer.parseInt(partes1[0]);
            int minutos1 = Integer.parseInt(partes1[1]);
            int segundos1 = Integer.parseInt(partes1[2]);

            int horas2 = Integer.parseInt(partes2[0]);
            int minutos2 = Integer.parseInt(partes2[1]);
            int segundos2 = Integer.parseInt(partes2[2]);

            // Realiza a operação (adição ou subtração)
            System.out.print("Escolha a operação (+ para adição, - para subtração): ");
            char operacao = scanner.next().charAt(0);

            int ResultadoHora = 0;
            int ResultadoMinuto = 0;
            int ResultadoSegundo = 0;

            if (operacao == '+') {
                ResultadoHora = horas1 + horas2;
                ResultadoMinuto = minutos1 + minutos2;
                ResultadoSegundo = segundos1 + segundos2;
            } else if (operacao == '-') {
                ResultadoHora = horas1 - horas2;
                ResultadoMinuto = minutos1 - minutos2;
                ResultadoSegundo = segundos1 - segundos2;
            } else {
                System.out.println("Operação inválida. Use + para adição ou - para subtração.");
                return;
            }

            // Realiza ajustes se os segundos ou minutos excederem 60
            if (ResultadoSegundo >= 60) {
                ResultadoSegundo -= 60;
                ResultadoMinuto++;
            }
            if (ResultadoMinuto >= 60) {
                ResultadoMinuto -= 60;
                ResultadoHora++;
            }

            // Exibe o resultado
            System.out.println("Resultado: " + String.format("%02d:%02d:%02d", ResultadoHora, ResultadoMinuto, ResultadoSegundo));
        } catch (NumberFormatException e) {
            
            e.printStackTrace();
        }
    }
}
