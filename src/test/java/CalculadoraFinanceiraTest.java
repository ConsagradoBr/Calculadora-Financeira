import org.example.CalculadoraFinanceira    ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraFinanceiraTest {

    private CalculadoraFinanceira calc;

    @BeforeEach
    void setup() {
        calc = new CalculadoraFinanceira();
    }

    /* Testes para Desconto */

    @Test
    void deveCalcularDescontoCorretamente(){
        assertEquals(90, calc.calcularDesconto(100, 10));
    }

    @Test
    void deveRetornarMesmoValorQuandoPercentualZero(){
        assertEquals(100, calc.calcularDesconto(100, 0));
    }

    @Test
    void deveLancarExcecaoParaValoresNegativos() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularDesconto(-100, 10);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularDesconto(100, -10);
        });
    }

    /* Testes para Juros simples */
    @Test
    void deveCalcularJurosSimplesCorretamente() {
        assertEquals(200, calc.calcularJurosSimples(1000, 0.1, 2));
    }

    @Test
    void deveLancarExcecaoParaValoresInvalidosJuros() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularJurosSimples(0, 10, 2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularJurosSimples(1000, 0, 2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularJurosSimples(1000, 10, 0);
        });
    }

    /* Testes para Média */

    @Test
    void deveCalcularMediaCorretamente() {
        double[] valores = {10.0, 20.0, 30.0};
        double resultado = calc.calcularMedia(valores);
        assertEquals(20.0, resultado);
    }

    @Test
    void deveLancarExcecaoParaArrayVazio() {
        double[] valores = {};

        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularMedia(valores);
        });
    }

    @Test
    void deveLancarExcecaoParaArrayNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularMedia(null);
        });
    }

    /* Testes para Aprovar */

    @Test
    void deveRetornarTrueParaNotaMaiorQueSeis() {
        assertTrue(calc.ehAprovado(7));
    }

    @Test
    void deveRetornarTrueParaNotaIgualASeis() {
        assertTrue(calc.ehAprovado(6));
    }

    @Test
    void deveRetornarFalseParaNotaMenorQueSeis() {
        assertFalse(calc.ehAprovado(5));
    }

    @ParameterizedTest
    @CsvSource({
            "100, 10, 90",
            "200, 20, 160",
            "50, 50, 25"
    })
    void deveCalcularDescontoComMultiplosValores(double valor, double percentual, double esperado) {
        assertEquals(esperado, calc.calcularDesconto(valor, percentual));
    }

}
