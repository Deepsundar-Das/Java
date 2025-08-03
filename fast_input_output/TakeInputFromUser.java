import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TakeInputFromUser {

    public static void main(String[] arr) {
        // take input using InputStream object, which is available in System class
        // int num = 0;
        // try{
        //   /*
        //    * 1. the problem is in is an object of InputStream which takes input byte by byte means it will print just one byte of
        //     character no matter how long you give input in console
        //     eg : you write 55 it will accept only first 5 only

        //     2. It returns only ASCII value of the characters eg: you give input 5 it will return 53 because ASCII value of 0 is 48.
        //   */
        //   num = System.in.read();
        // }catch(IOException e){
        //   System.out.println(e.getMessage());
        // }

        // System.out.println(num);

        // Better way to take input is use a BufferReader or InputStreamReader

        // InputStreamReader in = new InputStreamReader(System.in);
        // BufferedReader bf = new BufferedReader(in);
        // but BufferedReader returns a string so we have to parse it into our desireable format
        // BufferdReader takes some resources so we need to free it to give it to other program(though it is AutoClosable).
        // long num2 = 0;
        // try {
        //     num2 = Long.parseLong(bf.readLine());
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // }
        // System.out.println(num2);
        // try {
        //     bf.close();
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // }

        // we have to call close method no matter if we get exception or not
        // so we can use finally block
        // finally block is used whenever the we need to perform some task which is common like bf.close()
        // will be executed if we get exception or not

        // try {
        //     num2 = Long.parseLong(bf.readLine());
        //     System.out.println(num2);
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // } finally {
        //     try {
        //         bf.close();
        //     } catch (IOException e) {
        //         System.out.println(e.getMessage());
        //     }
        // }

        // we can create object of BufferedReader as  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // for no headache we can use like this

        long num3 = 0;
        // here try block will automatically close the BufferedReader, it is called try with resources
        try (
            BufferedReader bf1 = new BufferedReader(
                new InputStreamReader(System.in)
            )
        ) {
            num3 = Long.parseLong(bf1.readLine());
            System.out.println(num3);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

