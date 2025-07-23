import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

class InputStreamReaderEx {

    public static void main(String[] ar) {
        // System.in -> system terminal is generally line buffered means it takes one whole line and
        // then sends to the program
        // the string or characters are sent as ex: "hello\n" a new line character is also added at the end
        // InputStreamReader reader = new InputStreamReader(System.in);
        // try {
        //     // while (true) {
        //     int input = reader.read();

        //     // here is a problem ready method checks if there are characters available to be read without blocking (waiting).
        //     // once it has consumed all those characters, the stream becomes empty. The ready() method will then return false,
        //     //  and the loop will terminate. The program will not wait for you to type more text.
        //     while (reader.ready()) {
        //         System.out.println("you typed: " + (char) (input));
        //         input = reader.read();
        //     }
        //     // }
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // }

        // try (
        //     OutputStreamWriter o = new OutputStreamWriter(
        //         System.out,
        //         StandardCharsets.UTF_8
        //     );
        // ) {
        //     o.write("🙂");
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // }

        // try {
        //     File f = new File("/home/zen/Documents/me.txt");
        //     f.createNewFile();
        //     System.out.println(f.getName());
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }

        try {
            // File fo = new File("random.txt"); this random.txt is not an actual file it is an object in memory
            // and createneewfile() method is just creating a file with current file object name in the
            // specified directory. and delete method id deleting the actual file in the directory(in the disk)
            // not the file object in the main memory
            File fo = new File("random.txt");
            fo.createNewFile();
            if (fo.delete()) {
                System.out.println(fo.getName());
            }
            fo.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
