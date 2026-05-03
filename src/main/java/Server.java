import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 3621;

        Protocol protocol = new Protocol();
        try (ServerSocket socketServidor = new ServerSocket(port)) {
            
            while (true) {
                Socket socketCliente = socketServidor.accept();

                ManejadorCliente manejador = new ManejadorCliente(socketCliente);
                Thread hilo = new Thread(manejador);
                hilo.start();
                System.out.println("Cliente iniciado");
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
