import javax.sound.sampled.SourceDataLine;

class Main {

    public static void main(String[] arr) {
        OuterClass.InnerClass inner = new OuterClass().new InnerClass();
        inner.setAge(20);
        System.out.println(inner.getAge());
    }
}
