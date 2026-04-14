package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Locale LOCALE_PT_BR = Locale.forLanguageTag("pt-BR");

    private final Scanner scanner = new Scanner(System.in);
    private final CalculadoraFinanceira calculadora = new CalculadoraFinanceira();

    public static void main(String[] args) {
        new Main().executar();
    }

    private void executar() {
        System.out.println("Calculadora Financeira");

        boolean executando = true;
        while (executando) {
            mostrarMenu();
            int opcao = lerInteiro("Escolha uma opcao: ");

            switch (opcao) {
                case 1 -> calcularDesconto();
                case 2 -> calcularJurosSimples();
                case 3 -> calcularMedia();
                case 4 -> verificarAprovacao();
                case 0 -> {
                    executando = false;
                    System.out.println("Encerrando a aplicacao.");
                }
                default -> System.out.println("Opcao invalida. Tente novamente.");
            }

            if (executando) {
                System.out.println();
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("1 - Calcular desconto percentual");
        System.out.println("2 - Calcular juros simples");
        System.out.println("3 - Calcular media de valores");
        System.out.println("4 - Verificar aprovacao");
        System.out.println("0 - Sair");
    }

    private void calcularDesconto() {
        try {
            double valor = lerDouble("Valor original: ");
            double percentual = lerDouble("Percentual de desconto: ");
            double resultado = calculadora.calcularDesconto(valor, percentual);
            System.out.printf(LOCALE_PT_BR, "Valor com desconto: %.2f%n", resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void calcularJurosSimples() {
        try {
            double capital = lerDouble("Capital inicial: ");
            double taxa = lerDouble("Taxa decimal por periodo (ex.: 0,1 para 10%): ");
            int tempo = lerInteiro("Quantidade de periodos: ");
            double resultado = calculadora.calcularJurosSimples(capital, taxa, tempo);
            System.out.printf(LOCALE_PT_BR, "Juros simples: %.2f%n", resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void calcularMedia() {
        try {
            int quantidade = lerInteiro("Quantos valores deseja informar? ");
            if (quantidade <= 0) {
                throw new IllegalArgumentException("A quantidade deve ser maior que zero");
            }

            double[] valores = new double[quantidade];
            for (int i = 0; i < quantidade; i++) {
                valores[i] = lerDouble("Valor " + (i + 1) + ": ");
            }

            double resultado = calculadora.calcularMedia(valores);
            System.out.printf(LOCALE_PT_BR, "Media: %.2f%n", resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void verificarAprovacao() {
        double nota = lerDouble("Informe a nota final: ");
        boolean aprovado = calculadora.ehAprovado(nota);
        System.out.println(aprovado ? "Resultado: aprovado" : "Resultado: reprovado");
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido.");
            }
        }
    }
}
