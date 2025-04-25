import java.io.*;
import java.nio.file.*;
import java.util.List;

public class theory2 {

    public static void main(String[] args) {

        //FileNotFoundException
        try(FileReader reader = new FileReader("fitxer_inexistent.txt")) {

            reader.close();
        } catch (Exception e) {
            System.out.println("Fitxer no trobat: " + e.getMessage());
        }



        //IOException
        try {
            BufferedReader br = new BufferedReader(new FileReader("fitxer.txt"));
            String linea = br.readLine();
            br.close();
        } catch (IOException e) {
            System.out.println("Error d'E/S: " + e.getMessage());
        }

        //InvalidPathException
        try {
            Path path = Paths.get("ruta:\\invalida:<>.txt");
        } catch (InvalidPathException e) {
            System.out.println("Ruta no vàlida: " + e.getMessage());
        }

        //SecurityException
        try {
            File fitxer = new File("/fitxer_sistema_prohibit.txt");
            if (fitxer.exists()) {
                boolean llegible = fitxer.canRead(); // pot llençar SecurityException
            }
        } catch (SecurityException e) {
            System.out.println("Sense permisos d'accés: " + e.getMessage());
        }

        //NoSuchFileException
        try {
            byte[] dades = Files.readAllBytes(Paths.get("fitxer_inexistent.txt"));
        } catch (NoSuchFileException e) {
            System.out.println("El fitxer no existeix: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error d'E/S: " + e.getMessage());
        }

        /*
        * Intenta llegir un fitxer.

        Comprova si la ruta és vàlida.

        Comprova si tens permisos.

        Llegeix les línies del fitxer.

        Mostra missatges clars segons el tipus d’error.
        **/
        // Prova amb una ruta de fitxer (pots canviar-la per provar diferents casos)
        /*
        Una ruta vàlida amb un fitxer existent (fitxers/exemple.txt amb contingut).

        Una ruta inexistent (fitxers/inexistent.txt).

        Una ruta amb caràcters il·legals (fitxers/<>error.txt).

        Un fitxer amb permisos denegats (si ho vols simular en un sistema Unix, pots canviar els permisos).
        */
        llegirFitxer("fitxers/exemple.txt");




    }

    public static void llegirFitxer(String rutaFitxer) {
        try {
            // Comprovació de ruta vàlida
            Path path = Paths.get(rutaFitxer);

            // Comprovació de permisos
            File fitxer = path.toFile();
            if (!fitxer.exists()) {
                throw new FileNotFoundException("El fitxer no existeix.");
            }
            if (!fitxer.canRead()) {
                throw new SecurityException("No tens permisos per llegir el fitxer.");
            }

            // Llegir el fitxer
            List<String> linies = Files.readAllLines(path);
            System.out.println("Contingut del fitxer:");
            for (String linia : linies) {
                System.out.println(linia);
            }

        } catch (InvalidPathException e) {
            System.out.println("⚠️ Ruta no vàlida: " + e.getMessage());
        } catch (NoSuchFileException | FileNotFoundException e) {
            System.out.println("❌ Fitxer no trobat: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("🔒 Error de permisos: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("💥 Error d'entrada/sortida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❗ Error inesperat: " + e.getMessage());
        }
    }
}

