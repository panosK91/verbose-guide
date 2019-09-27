import java.util.Scanner;

public class main {
    static Scanner keyboard = new Scanner(System.in);
    private static mobilePhone mobile = new mobilePhone();
    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();

        while (!quit){
            System.out.println("Enter an action: ");
            int action = keyboard.nextInt();
            keyboard.nextLine();


            switch (action){
                case 0:
                    System.out.println("System is shuting down...");
                    quit = true;
                    break;
                case 1:
                    mobile.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }

        }
    }

    private static void startPhone(){
        System.out.println("Phone is starting....");
    }

    private static void printActions(){
        System.out.println(" \nAvailable actions: \npress" );
        System.out.println("0 - to shutdown\n" +
                           "1 - to print contacts\n" +
                           "2 - to add new contact\n" +
                           "3 - to update an existing contact \n" +
                           "4 - to remove an existing contact\n" +
                           "5 - query if an existing contact exists\n" +
                           "6 - to pring a list of available actions\n");
        System.out.println("Choose your action");
    }

    private static void addNewContact() {
        System.out.println("Give a new contact ");
        String name = keyboard.nextLine();
        System.out.println("Enter a phone ");
        String phone = keyboard.nextLine();
        Contact newContact = Contact.createNewContact(name,phone);
        mobile.addNewContact(newContact);

    }

    private static void updateContact(){
        System.out.println("Give the contact you want to replace ");
        String oldName = keyboard.nextLine();

        Contact oldContact = mobile.queryContact(oldName);

        if(oldContact == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Give the new contact ");
        String newName = keyboard.nextLine();
        String newPhone = keyboard.nextLine();

        Contact newContact = Contact.createNewContact(newName,newPhone);
        mobile.updateContact(oldContact,newContact);



    }

    private static void queryContact(){
        System.out.println("Give the contact you want to search: ");
        String name = keyboard.nextLine();

        if(mobile.queryContact(name)!=null){

            System.out.println("The number of  " + mobile.queryContact(name).getName() + " is "+mobile.queryContact(name).getPhone());

            return;
        }
        System.out.println("You dont have this contact");
    }


    private static void removeContact(){
        System.out.println("Give the contact you want to delete: ");
        String name = keyboard.nextLine();

        if(mobile.queryContact(name)!=null){

            System.out.println("The contact " + mobile.queryContact(name).getName() + " has been deleted ");
            mobile.deleteContact(mobile.queryContact(name));
            return;
        }
        System.out.println("You dont have this contact");

    }
}
