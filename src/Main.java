import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Ruta del Archivo en formato txt
        String rutaArchivo = "C:/Users/braya/Downloads/codigos_postales_hmo.txt";

        // Creación de un mapa para almacenar los códigos postales y sus cantidades de asentamientos
        Map<String, Integer> codigoPostal = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            // Leer cada línea del archivo
            while ((line = br.readLine()) != null) {
                // Dividir la línea en partes usando el tab como separador
                String[] parts = line.split("\t");
                // Obtener el código postal de la parte correspondiente
                String cp = parts[0];

                // Agregar o actualizar el código postal en el mapa, aumentando su cantidad
                codigoPostal.put(cp, codigoPostal.getOrDefault(cp, 0) + 1);
            }
        } catch (IOException e) {
            // Manejar posibles errores al leer el archivo
            e.printStackTrace();
        }

        // Iterar a través del mapa de códigos postales y cantidades
        for (Map.Entry<String, Integer> entry : codigoPostal.entrySet()) {
            // Obtener el código postal y la cantidad de asentamientos del mapa
            String cp = entry.getKey();
            int numAsentamientos = entry.getValue();
            // Imprimir
            System.out.println("Código Postal " + cp + " Comparte: " + numAsentamientos + " Asentamientos");

        }
        System.out.println();
        System.out.println("Alumno: Beltran Calvo Brayan");
    }
}
