import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
public class Person {
    public enum Sex {
            MALE, FEMALE
        }

        String name;
        LocalDate birthday;
        Sex gender;
        String emailAddress;

        //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public Sex getGender() {
        return gender;
    }
    public void setGender(Sex gender) {
        this.gender = gender;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    //Constructor
    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        roster.add(this);
    }
    public Person() {
    }
    List<Person> roster = new ArrayList<>();
    public int getAge() {

        LocalDate today = LocalDate.now();
        return Period.between(this.birthday, LocalDate.now()).getYears();
        }

    public void printPerson(){
        System.out.println("Name:"+name+"Email:"+emailAddress+"Age:"+getAge()+"Gender:"+gender);
        }

        public static void printPersons(List<Person> roster, CheckPerson tester) {
                for (Person p : roster) {
                    if (tester.test(p)) {
                        p.printPerson();
                    }
                }
            }

            //Specify Search Criteria Code in a Local Class
            public static void printPersons(List<Person> roster, int age){
            class LocalClass implements CheckPerson {
                @Override
                public boolean test(Person p) {
                    return p.getAge()>=age;
                }}
                printPersons(roster,new LocalClass());
            }




    //Specify Search Criteria Code in an Anonymous Class
public static void printPersonsAnonymousClass(List<Person> roster, int age)
{
    printPersons(roster, new CheckPerson() {
        public boolean test(Person p) {
            return p.getAge()>=age;
        }
    });

}



    //Specify Search Criteria Code with a Lambda Expression
    public static void printPersonsLambda(List<Person> roster, int age) {
        printPersons(roster, p -> p.getAge() >= age);
    }


        }


