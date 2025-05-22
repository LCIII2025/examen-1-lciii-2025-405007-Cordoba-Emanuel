package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //DONE test
        Estacionamiento estacionamiento = new Estacionamiento();
        Cliente cliente = new Cliente("123", "Emanuel");
        Vehiculo vehiculo = new Vehiculo("LHL466", "Fiat Punto", Vehiculo.Tipo.AUTO);

        estacionamiento.ingresarVehiculo(cliente.getDni(), cliente.getNombre(), vehiculo);

        Ticket ticketResult = estacionamiento.retirarVehiculo(vehiculo.getPatente());

        assertNotNull(ticketResult);
        assertEquals(vehiculo.getPatente(), ticketResult.getVehiculo().getPatente());
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // DONE test
        Cliente cliente = new Cliente("123", "Emanuel");
        LocalDateTime entrada = LocalDateTime.of(2025, 1, 1, 10, 0);
        LocalDateTime salida = LocalDateTime.of(2025, 1, 1, 11, 0);

        Vehiculo vehiculo1 = new Vehiculo("LHL466", "Fiat Punto", Vehiculo.Tipo.AUTO);
        Vehiculo vehiculo2 = new Vehiculo("ASD345", "Ford Maverick", Vehiculo.Tipo.SUV);
        Vehiculo vehiculo3 = new Vehiculo("PPP666", "Ford Ranger", Vehiculo.Tipo.PICKUP);

        Ticket ticket1 = new Ticket(cliente, vehiculo1, entrada, salida);
        Ticket ticket2 = new Ticket(cliente, vehiculo2, entrada, salida);
        Ticket ticket3 = new Ticket(cliente, vehiculo3, entrada, salida);

        double precioResult1 = ticket1.calcularPrecio();
        double precioResult2 = ticket2.calcularPrecio();
        double precioResult3 = ticket3.calcularPrecio();

        assertEquals(100, (int) precioResult1);
        assertEquals(130, (int) precioResult2);
        assertEquals(180, (int) precioResult3);
    }

}