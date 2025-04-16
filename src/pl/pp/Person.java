package pl.pp;

public class Person {

    public String forename;
    public String surname;
    public int age;
    public String adres;
    public int rok_urodzenia;
    public Person() {
    }
    public Person(String forename, String surname, int age){
        this.forename = forename;
        this.surname = surname;
        this.age = age;
    }
    public void hiToAll () {
        System.out.println("Nazywam sie " + forename + " " + surname + " mam " + age + " lat. ");
        System.out.println(" Moj adres: " + adres + ". Urodzilem sie w " + rok_urodzenia + " roku.");
    }
    public void growOld ( int value){
        this.age += value;
    }
    public void beYounger () {
        this.age -= 1;
    }
    public String getName () {
        return this.forename;
    }
    public String setName (String newName){
        return this.forename = newName;
    }

}
