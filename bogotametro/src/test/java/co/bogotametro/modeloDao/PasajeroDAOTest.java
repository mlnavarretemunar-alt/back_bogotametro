package co.bogotametro.modeloDao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import co.bogotametro.modeloVo.PasajeroVO;
import java.util.Date;

public class PasajeroDAOTest {

    @Test
    void loginCorrecto() {

        PasajeroVO pasajero = new PasajeroVO(
            "Maria Angeles Duran",
            "$2b$10$sX3tN6mZo9",
            "3229876543",
            "maria.duran@gmail.com",
            "Cedula_de_ciudadania",
            "123456789",
            1,
            new Date(),
            true
        );

        PasajeroDAO dao = new PasajeroDAO(pasajero);

        boolean resultado = dao.iniciarSesion("Cedula_de_ciudadania", "1019876543","$2b$10$sX3tN6mZo9");
        assertTrue(resultado);
        assertNotNull(dao);
    }

    @Test
    void loginIncorrecto() {

    PasajeroVO pasajero = new PasajeroVO(
        "Maria Angeles Duran",
        "$2b$10$sX3tN6mZo9",
        "3229876543",
        "maria.duran@gmail.com",
        "Cedula_de_ciudadania",
        "1019876543",
        1,
        new Date(),
        true
    );

    PasajeroDAO dao = new PasajeroDAO(pasajero);

    boolean resultado = dao.iniciarSesion(
    "Cedula_de_ciudadania",
    "1019876543",
    "CLAVE_INCORRECTA"
);
    assertFalse(resultado);

}
    @Test
    void usuarioInexistente() {

    PasajeroVO pasajero = new PasajeroVO(

        "Usuario Prueba Inexistente",
        "clave1234567",
        "3000000000",
        "noexiste@gmail.com",
        "Cedula_de_ciudadania",
        "999999999",
        0,
        new Date(),
        true
    );
    PasajeroDAO dao = new PasajeroDAO(pasajero);

    boolean resultado = dao.iniciarSesion(
        "Cedula_de_ciudadania",
        "999999999",
        "clave1234567"
    );
    assertFalse(resultado);
    }

    @Test
    void integraciónLogin() {
        PasajeroVO pasajero = new PasajeroVO(
            "Diego Alejandro Sandoval",
            "$2b$10$dR7kT9zLp2",
            "3174567890",
            "diego.sandoval@gmail.com",
            "Cedula_de_ciudadania",
            "1032547865",
            0,
            new Date(),
            true
        );
    
    PasajeroDAO dao = new PasajeroDAO(pasajero);
    boolean resultado = dao.iniciarSesion(
        "Cedula_de_ciudadania",
        "1032547865",
        "$2b$10$dR7kT9zLp2"
    );
    assertTrue(resultado);
}
}