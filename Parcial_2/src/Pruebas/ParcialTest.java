package Pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Logica.Parcial;

public class ParcialTest {
	private Parcial parcial;
	
	@BeforeEach
	void setup() {
		parcial = new Parcial(); }
	
	@Test
	void raicesRealesDiferentes() throws Exception {
		assertEquals("x1 =2.0, x2 =1.0", parcial.calcularRaices(1, -3, 2)); }

    @Test
    void raicesIguales() throws Exception {
        assertEquals("x1 = -1.0, x2 = -1.0", parcial.calcularRaices(1, 2, 1));}

    @Test
    void discriminanteNegativoLanzaExcepcion() {
        Exception e = assertThrows(Exception.class, () -> parcial.calcularRaices(1, 2, 5));
        assertEquals("Raíces complejas: el discriminante es negativo", e.getMessage());}
}