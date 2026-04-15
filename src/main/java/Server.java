import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int puerto = 4445;

        Protocol protocol = new Protocol();
        try (ServerSocket socketServidor = new ServerSocket(puerto)) {
            
            while (true) {
                Socket socketCliente = socketServidor.accept();

                ManejadorCliente manejador = new ManejadorCliente(socketCliente);
                Thread hilo = new Thread(manejador);
                hilo.start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
