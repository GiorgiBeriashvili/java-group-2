public class Main {

    public static void main(String[] args) {
//	    System.out.println("Hello, world!");

	    Person giorgi = new Person();
	    giorgi.firstName = "Giorgi";
	    giorgi.lastName = "Beriashvili";
	    giorgi.printData();

        Person mariami = new Person();
        mariami.firstName = "Mariami";
        mariami.lastName = "Chakhvadze";
        mariami.printData();

        Person levani = new Person();
        levani.firstName = "Levani";
        levani.lastName = "Bejanidze";
        levani.printData();
    }
}
