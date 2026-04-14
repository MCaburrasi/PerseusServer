import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int puerto = 4445;
        
        // Se crea la partida a la que se uniran los clientes
        System.out.println("Servidor iniciado y partida creada \n");
        System.out.println("Se espera a jugadores para comenzar partida \n");

        try (ServerSocket socketServidor = new ServerSocket(puerto)) {
            
            while (true) {
                Socket socketCliente = socketServidor.accept();
                
                // Miro si la partida ya esta completa
                ManejadorCliente manejador = new ManejadorCliente(socketCliente);
                Thread hilo = new Thread(manejador);
                hilo.start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
