package Sample;

import java.io.*;

public class FileStreamExample {
    public static void main(String[] args) {
        String root = "C:\\Users\\Piyush\\OneDrive\\Desktop\\bridgelabz-workspace\\Java-Collections\\Java-Streams\\src\\main\\java\\Sample\\";

        try (FileInputStream fis = new FileInputStream(root+"input.txt");
             FileOutputStream fos = new FileOutputStream(root+"output.txt")) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
                System.out.print((char) byteData);
            }
            System.out.println("\nFile copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
