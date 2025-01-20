import java.util.ArrayList;

public class ContactList
{
    ArrayList<Person> contacts = new ArrayList<Person>();

    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Person> getContacts()
    {
        return  contacts;
    }

    public  void addContact(Person person){
        contacts.add(person);
    }

    public void printContacts()
    {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i).toString());
        }
    }

    public  void sort(int sortBy)
    {
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - 1; j++) {
                Person next = contacts.get(j + 1);
                Person current = contacts.get(j);

                if ()




            }

        }
    }




}
