package Sample;

import java.io.FileInputStream;

public class inputStreams {

    public static void main(String args[]) {

        try {
            FileInputStream input = new FileInputStream("input.txt");

            System.out.println("Data in the file: ");

            // Reads the first byte
            int i = input.read();

            while(i != -1) {
                System.out.print((char)i);

                // Reads next byte from the file
                i = input.read();
            }
            input.close();
        }

        catch(Exception e) {
            e.getStackTrace();
        }
    }
}