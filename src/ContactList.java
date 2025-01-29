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

                if (sortBy == 0 && (current.getFirstName().compareTo(next.getFirstName()) < 0))
                {
                    Person mid = contacts.get(j);
                    contacts.set(j, contacts.get(j+ 1));
                    contacts.set(j + 1, mid);
                }
                else if (sortBy == 1 && current.getLastName().compareTo(next.getLastName()) < 0)
                {
                    Person mid = contacts.get(j);
                    contacts.set(j, contacts.get(j+ 1));
                    contacts.set(j + 1, mid);
                }
                else if (sortBy == 2 && current.getPhoneNumber().compareTo(next.getPhoneNumber()) < 0)
                {
                    Person mid = contacts.get(j);
                    contacts.set(j, contacts.get(j+ 1));
                    contacts.set(j + 1, mid);
                }


            }

        }
    }


    public Person searchByFirstName(String firstName)
    {
        for (Person contact : contacts)
        {
            if (contact.getFirstName().equals(firstName))
            {
                return contact;
            }
        }
        return  null;
    }

    public Person searchByLastName(String lastName)
    {
        for (Person contact : contacts)
        {
            if (contact.getLastName().equals(lastName))
            {
                return contact;
            }
        }
        return  null;
    }

    public Person searchByPhoneNumber(String phoneNumber)
    {
        for (Person contact : contacts)
        {
            if (contact.getPhoneNumber().equals(phoneNumber))
            {
                return contact;
            }
        }
        return  null;
    }


    public void listStudents()
    {

    }




}
