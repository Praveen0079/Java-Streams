package Sample;

import java.io.*;

public class FileReaderWriterExample {
    public static void main(String[] args) {
        String root = "C:\\Users\\Piyush\\OneDrive\\Desktop\\bridgelabz-workspace\\Java-Collections\\Java-Streams\\src\\main\\java\\Sample\\";

        try (FileReader fr = new FileReader(root+"input.txt");
             FileWriter fw = new FileWriter(root+"output.txt")) {

            int charData;
            while ((charData = fr.read()) != -1) {
                fw.write(charData);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}