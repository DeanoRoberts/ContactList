import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<Person> contacts = new ArrayList<Person>();
    private Scanner scanner;

    public ContactList() {
        this.contacts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public ContactList(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person person) {
        contacts.add(person);
    }

    public void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i).toString());
        }
    }

    public void sort(int sortBy) {
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - 1 - i; j++) {
                Person next = contacts.get(j + 1);
                Person current = contacts.get(j);
                boolean canSwap = false;

                if (sortBy == 0 && (current.getFirstName().compareTo(next.getFirstName()) < 0)) {
                    canSwap = true;
                } else if (sortBy == 1 && current.getLastName().compareTo(next.getLastName()) < 0) {
                    canSwap = true;
                } else if (sortBy == 2 && current.getPhoneNumber().compareTo(next.getPhoneNumber()) < 0) {
                   canSwap = true;
                }

               if (canSwap)
               {
                  contacts.set(j, next);
                  contacts.set(j + 1, current);
               }

            }

        }
    }


    public Person searchByFirstName(String firstName) {
        for (Person contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person contact : contacts) {
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }


    public void listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);

            }
        }

    }

    public void printInstuctions()
    {
        System.out.println("Menu:");
        System.out.println("1. Add contact");
        System.out.println("2. List all contacts by first name");
        System.out.println("3. List all contacts by last name");
        System.out.println("4. List all contacts by phone Number");
        System.out.println("5. List all student");
        System.out.println("6. Search by first name");
        System.out.println("7. Search by last name");
        System.out.println("8. Search by phone number");
        System.out.println("0. Exit");
        System.out.println(" Enter your choice: ");
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            printInstuctions();
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Select a type pf contact to add: ");
                System.out.println("1. Student");
                System.out.println("2. Worker");
                int theType = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please fill out the following");
                System.out.println("First Name: ");
                String firstName = scanner.nextLine();
                System.out.println("Last Name: ");
                String lastName = scanner.nextLine();
                System.out.println("Phone Number: ");
                String phoneNumber = scanner.nextLine();

                if (theType == 1) {
                    System.out.println("Grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    Student newCon = new Student(firstName, lastName, phoneNumber, grade);
                    contacts.add(newCon);
                } else {
                    System.out.println("Subject: ");
                    String subject = scanner.nextLine();
                    Teacher newCon = new Teacher(firstName, lastName, phoneNumber, subject);
                    contacts.add(newCon);
                }

            } else if (choice == 2) {
                sort(0);
                printContacts();
            } else if (choice == 3) {
                sort(1);
                printContacts();
            } else if (choice == 4) {
                sort(2);
                printContacts();

            } else if (choice == 5) {
                listStudents();
            } else if (choice == 6) {
                System.out.println("Enter a name");
                String name = scanner.nextLine();

                if (searchByFirstName(name) != null) {
                    System.out.println(searchByFirstName(name));
                } else {
                    System.out.println(name + "is not in the list");
                }
            } else if (choice == 7) {
                System.out.println("Enter  last  name");
                String name = scanner.nextLine();

                if (searchByLastName(name) != null) {
                    System.out.println(searchByLastName(name));
                } else {
                    System.out.println(name + "is not in the list");
                }
            } else if (choice == 8) {
                System.out.println("Enter a phone Number: ");
                String name = scanner.nextLine();

                if (searchByPhoneNumber(name) != null) {
                    System.out.println(searchByPhoneNumber(name));
                } else {
                    System.out.println(name + "is not in the list");
                }
            } else if (choice != 0) {
                System.out.println("Invalid option. Try agian");

            }
        } while (choice != 0);


    }

    public static void main(String[] args) {
        ContactList contacts = new ContactList();
        contacts.run();
    }

}


