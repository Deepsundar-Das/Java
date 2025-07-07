class WrapperClass {

    public static void main(String[] arr) {
        /*
        The Integer class, like other wrapper classes (e.g., Long, Double, Boolean),
        is designed to be immutable. This means that once an Integer object is created,
        its value cannot be changed.
        When you perform operations like x++ on an Integer object, Java doesn't modify the original object.
        Instead, it creates a new Integer object with the new value
        */
        Integer a = 10;
        Integer b = 20;
        changeValue(a, b);
        System.out.println("a= " + a + ", b=" + b);
    }

    /*
    what is happening here ????
    => what I understand,
        let memory addresses of 'a' and 'b' are S100 and S200 (in stack memory)
        in heap memory let say two addresses are H101 and H201 where 10 and 20 is present and 100 and 200 are pointing to them
        now when I passed value of 'a' and 'b' in the changeValue it created another memory space in heap memory and assigned the value 10 and 20
        let say the memory is H203 and H304 this does not need to be stored in the stack it can be passed immediately

        eg: S100 -> H101 -> 10 and H203 -> 10
            S200 -> H201 -> 20 and H304 -> 20

        now they are separate now they could not affect each other

    */

    /*

    but for non-premitives the copy of the stack's value(object's stored memory address) is passed to the method that is why
   the changes in an reference is seen to the other reference
    */
    static void changeValue(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
}
