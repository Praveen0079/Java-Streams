import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class readFromConsole {
    public static void main(String[] args) {
        String root = "C:\\Users\\Piyush\\OneDrive\\Desktop\\bridgelabz-workspace\\Java-Collections\\Java-Streams\\src\\main\\java\\Sample\\";

        try(InputStreamReader isr = new InputStreamReader(System.in);
         FileOutputStream fos = new FileOutputStream(root+"output1.txt")){
            System.out.print("Enter : ");
            int letter = isr.read();
            while (isr.ready()){
                fos.write(letter);
                System.out.print((char) letter);
                letter = isr.read();
            }
//            System.out.println("\n"+isr.ready());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}