import java.io.File;
import java.io.IOException;
import java.nio.file.*;


public class theory1 {
    public static void main(String[] args) throws IOException {


        //1. Creem objectes File
        File fitxer=new File("/home/slimbook/IdeaProjects/Fitxers/prova.txt");
        File directori=new File("/home/slimbook/IdeaProjects/Fitxers/src");

        Path fitxer2 = Paths.get("/","home", "slimbook", "IdeaProjects", "Fitxers", "prova2.txt");
        Path directori2 = Paths.get("/home/slimbook/IdeaProjects/Fitxers/src2");


        //2. Creem fitxers i directoris
        fitxer.createNewFile();
        directori.mkdir();

        Files.createFile(fitxer2);
        Files.createDirectory(directori2);


        //3. Indica si existeixen els arxius
        System.out.println("Fitxer " + fitxer.exists());
        System.out.println("Directori " + directori.exists());

        System.out.println("Fitxer " + Files.exists(fitxer2));
        System.out.println("Directori " + Files.exists(directori2));


        //4. Indica si son directori
        System.out.println("És directori? " + fitxer.isDirectory());
        System.out.println("És directori? " + directori.isDirectory());

        System.out.println("És directori? " + Files.isDirectory(fitxer2));
        System.out.println("És directori? " + Files.isDirectory(directori2));

        //5. Indica si son fitxers
        System.out.println("És fitxer? " + fitxer.isFile());
        System.out.println("És fitxer? " + directori.isFile());

        System.out.println("És fitxer? " + Files.isRegularFile(fitxer2));
        System.out.println("És fitxer? " + Files.isRegularFile(directori2));

        //6. Creació ruta relativa i absoluta
        File fitxerRutaAbsoluta=new File("/home/slimbook/IdeaProjects/Fitxers/src");

        Path fitxerRutaAbsoluta2 = Paths.get("/","home", "slimbook", "IdeaProjects", "Fitxers", "src");


        //7. Indica la ruta absoluta del File
        System.out.println("Ruta absoluta: "+fitxerRutaAbsoluta.getAbsolutePath());

        System.out.println("Ruta absoluta: "+fitxerRutaAbsoluta2.toAbsolutePath());


        //8. Indica el nom del document/carpeta
        System.out.println("Ruta absoluta: "+fitxerRutaAbsoluta.getName());

        System.out.println("Ruta absoluta: "+fitxerRutaAbsoluta2.getFileName());


        //9. Indica la ruta del document/carpeta
        System.out.println("Ruta absoluta: "+fitxerRutaAbsoluta.getParent());

        System.out.println("Ruta absoluta: "+fitxerRutaAbsoluta2.getParent());



        //10. Permisos
        fitxer.canRead();
        fitxer.canWrite();
        fitxer.canExecute();

        Files.isReadable(fitxer2);
        Files.isWritable(fitxer2);
        Files.isExecutable(fitxer2);

        //11.
        File directori=new File("/home/nomUsuari/direccio");
        File llista[]=directori.listFiles();
        for(File file: llista){
            System.out.println(file.getName());
        }

        String llista[]=directori.list();
        for(String file: llista){
            System.out.println(file);
        }



        Path fitxer2 = Paths.get("/","home", "slimbook", "IdeaProjects", "Fitxers", "prova2.txt");
        DirectoryStream<Path> files = Files.newDirectoryStream(fitxer2);
        for (Path file : files) {
            System.out.println(file.getFileName());
        }

        //12. Altres
        File fitxer=new File("/home/nomUsuari/direccio/fitxer");
        File fitxerDesti=new File("/home/nomUsuari/direccio/fitxer2");
        fitxer.length();
        fitxer.delete();
        fitxer.renameTo(fitxerDesti);


        Path fitxer2 = Paths.get("/","home", "slimbook", "IdeaProjects", "Fitxers", "prova2.txt");
        Path fitxerDesti2 = Paths.get("/","home", "slimbook", "IdeaProjects", "Fitxers", "prova3.txt");
        Files.size(fitxer2);
        Files.delete(fitxer2);
        Files.move(fitxer2, fitxerDesti2, StandardCopyOption.REPLACE_EXISTING);


        /*
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }



        Scanner sc = new Scanner(path);
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
        */

    }
}