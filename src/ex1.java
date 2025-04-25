import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ex1 {
    public static void main(String[] args) throws IOException {
        Path directory = Paths.get("/home/sonwerik/file_manager/directory");
        Path file = Paths.get("/home/sonwerik/file_manager/directory/file.txt");

        Files.createDirectory(directory);
        Files.createFile(file);
        Files.writeString(file, "Miau!");
    }
}
