package Utility;

import java.io.*;
import java.util.Scanner;

/**
 * The type Reader from file.
 */
public class ReaderFromFile {

    /**
     * Read from file string.
     *
     * @param filename the filename
     * @return the string
     * @throws FileNotFoundException the file not found exception
     */
    public String readFromFile(String filename) throws FileNotFoundException {
        try {
            String data = "";
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                data += scanner.nextLine().trim() + "\n";
            scanner.close();
            WriterToFile.setFilename(filename);
            return data;
        } catch (FileNotFoundException | NullPointerException e) {
            while (filename == (null)) {
                System.out.println("Вы забыли указать имя файла. Укажите имя файла сейчас:");
                String newFilename = Console.read();
                if (!(newFilename.equals(""))) {
                    WriterToFile.setFilename(filename);
                    break;
                }
            }
            return null;
        }
    }
}