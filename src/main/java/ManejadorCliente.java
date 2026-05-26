import nasaapi.NasaWebConfig;

import java.io.*;
import java.net.*;
import java.util.List;

public class ManejadorCliente implements Runnable {
    private Socket socket;
    private PrintWriter salida;
    private BufferedReader entrada;
    private Protocol protocol;
    private NasaWebConfig nwc;

    public ManejadorCliente(Socket socket, Protocol protocol) {
        this.socket = socket;
        this.protocol = protocol;
    }

    @Override
    public void run() {
        try {
            this.salida = new PrintWriter(socket.getOutputStream(), true);
            this.entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String mensajeCliente;
            while ((mensajeCliente = entrada.readLine()) != null) {
                System.out.println(mensajeCliente);
                String l = protocol.processIn(mensajeCliente.split("\\|"), null); //Procesar entrada
                System.out.println(mensajeCliente);
                if (l != null){
                    System.out.println(l);
                    enviarMensajeDirecto(l);
                }

            }

        } catch (IOException e) {
            System.err.println("Fallo en la conexión");
        } finally {
            cerrarConexion();
        }
    }

    public void enviarMensajeDirecto(String mensaje) {
        if (salida != null) {
            salida.println(mensaje);
        }
    }

    private void cerrarConexion() {
        try {
            if (socket != null) socket.close();
            System.out.println("Socket cerrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
