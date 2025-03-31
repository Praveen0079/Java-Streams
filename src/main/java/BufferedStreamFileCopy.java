import java.io.*;

public class BufferedStreamFileCopy {
    private static final int BUFFER_SIZE = 4096; // 4 KB chunk size

    public static void main(String[] args) {
        String sourceFile = "largefile.dat";  // Replace with your actual large file path
        String destFile1 = "copy_normal.dat"; // Output for normal stream
        String destFile2 = "copy_buffered.dat"; // Output for buffered stream

        // Copy using normal file streams
        long timeNormal = copyUsingNormalStreams(sourceFile, destFile1); 
        System.out.println("Time taken with normal streams: " + timeNormal + " ns");

        // Copy using buffered streams
        long timeBuffered = copyUsingBufferedStreams(sourceFile, destFile2);
        System.out.println("Time taken with buffered streams: " + timeBuffered + " ns");

        // Compare performance
        double speedup = (double) timeNormal / timeBuffered;
        System.out.println("\n💡 Buffered Streams are " + String.format("%.2f", speedup) + "x faster than normal streams.");
    }

    // Method 1: Copy using Normal File Streams
    private static long copyUsingNormalStreams(String source, String dest) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Method 2: Copy using Buffered Streams (Efficient)
    private static long copyUsingBufferedStreams(String source, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE]; // 4 KB buffer
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
