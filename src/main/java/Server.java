import classes.HibernateUtil;
import nasaapi.NasaWebConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //TODO Sacar del main
        int port = 3621;
        NasaWebConfig nwc = new NasaWebConfig();
        DatabaseManager dm = new DatabaseManager(HibernateUtil.getSessionFactory().openSession());

        try (ServerSocket socketServidor = new ServerSocket(port)) {
            
            while (true) {
                Socket socketCliente = socketServidor.accept();

                Protocol protocol = new Protocol(dm, nwc);

                ManejadorCliente manejador = new ManejadorCliente(socketCliente, protocol);
                Thread hilo = new Thread(manejador);
                hilo.start();
                System.out.println("Cliente iniciado");
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
