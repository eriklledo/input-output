import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ex1 {
    public static void main(String[] args) throws IOException {
        Path directory = Paths.get("directory");
        Path file = directory.resolve("file.txt");
        Path file2 = directory.resolve("file2.txt");

        if (!Files.exists(directory)) {Files.createDirectory(directory);}
        if (!Files.exists(file)) {Files.createFile(file);}
        if (!Files.exists(file2)) {Files.createFile(file2);}

        Files.writeString(file, "Aquest és el fitxer gran!");
        Files.writeString(file2, "Aquest n'és el petit");

        Path fitxerMesGran = null;
        long midaMesGran = 0;

        DirectoryStream<Path> stream = Files.newDirectoryStream(directory);
        for (Path fitxer : stream) {
            if (Files.isRegularFile(fitxer)) {
                long size = Files.size(fitxer);
                if (size > midaMesGran) {
                    midaMesGran = size;
                    fitxerMesGran = fitxer;
                }
            }
        }
        System.out.println(fitxerMesGran);
    }
}
