import java.util.function.Function;

class PlayWithComparator {

    public static void main(String[] args) {
        // MyComparator<Person> cmp1 = MyComparator.comparing(p ->
        //     p.getLastName()
        // );

        // instead of above code we can write this below one
        // MyComparator<Person> cmp1 = MyComparator.comparing(Person::getLastName);

        // now let say lastname is same what to do now ?
        // compare first name

        MyComparator<Person> cmp1 = MyComparator.comparing(Person::getLastName)
            .andThen(Person::getFirstName)
            .andThen(Person::getAge)
            .reversed();

        /*
        MyComparator<Person> cmp1 = new MyComparator<Person>() {
            public int compare(Person p1, Person p2) {
                // Now the function/lastName1 and lastName2 variable depends on only on person

                String lastName1 = lastName.apply(p1);
                String lastName2 = lastName.apply(p1);
                return lastName1.compareTo(lastName2);

                // we can do more simplification
            }
            */

        // now if I want to get firstname I just need to change the getLastName to getFirstName
        // but my code depends mainly on the method not on the object
        // we can do more better
        /*
            private String getDetails(Person p) {
                    return p.getLastName();
            }
        */
    }
}
