import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ForEach {

    public static void main(String[] ar) {
        List<Integer> nums = Arrays.asList(1, 3, 4, 6, 7, 8);

        // Consumer con = new Consumer<Integer>() {
        //     public void accept(Integer n) {
        //         System.out.println(n);
        //     }
        // };

        // nums.forEach(con);
        //  we can minimize the work using lambda
        nums.forEach(n -> {
            System.out.println(n);
        });
    }
}
