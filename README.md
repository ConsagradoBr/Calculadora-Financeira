# Calculadora Financeira

Projeto Java com Maven voltado para prática de testes unitários com JUnit. A aplicação concentra uma classe simples de regras de negócio para cálculos básicos e validações, acompanhada por uma suíte de testes automatizados.

## O que o projeto faz

A classe `CalculadoraFinanceira` implementa os seguintes comportamentos:

- cálculo de desconto percentual;
- cálculo de juros simples;
- cálculo de média de valores;
- verificação de aprovação com base em nota mínima.

## Tecnologias

- Java 17
- Maven
- JUnit 5

## Estrutura do projeto

```text
src/
├─ main/
│  └─ java/
│     └─ org/example/
│        ├─ CalculadoraFinanceira.java
│        └─ Main.java
└─ test/
   └─ java/
      └─ CalculadoraFinanceiraTest.java
```

## Pré-requisitos

Antes de executar o projeto, tenha instalado:

- JDK 17 ou superior
- Maven 3.9 ou superior

Para verificar:

```bash
java -version
mvn -version
```

## Como executar os testes

Na raiz do projeto, rode:

```bash
mvn test
```

No estado atual do repositório, os testes passam com sucesso.

## Exemplo de uso

```java
import org.example.CalculadoraFinanceira;

public class Exemplo {
    public static void main(String[] args) {
        CalculadoraFinanceira calc = new CalculadoraFinanceira();

        double valorComDesconto = calc.calcularDesconto(1000, 10);
        double juros = calc.calcularJurosSimples(1000, 0.1, 2);
        double media = calc.calcularMedia(new double[] {8.0, 7.5, 9.0});
        boolean aprovado = calc.ehAprovado(6.5);

        System.out.println("Valor com desconto: " + valorComDesconto);
        System.out.println("Juros simples: " + juros);
        System.out.println("Media: " + media);
        System.out.println("Aprovado: " + aprovado);
    }
}
```

## Cobertura de testes atual

Os testes validam:

- cenários válidos de desconto;
- percentual zero;
- tratamento de valores negativos;
- cálculo de juros simples;
- tratamento de parâmetros inválidos;
- cálculo de média;
- validação de array nulo e vazio;
- regra de aprovação;
- casos parametrizados para desconto.

## Objetivo do repositório

Este projeto serve como base de estudo para:

- testes unitários em Java;
- organização de projeto com Maven;
- validação de regras de negócio simples;
- uso de testes parametrizados com JUnit.

## Melhorias possíveis

- adicionar uma interface de linha de comando em `Main.java`;
- revisar as dependências do `pom.xml` para eliminar avisos do Maven;
- incluir cobertura de testes e integração contínua.
