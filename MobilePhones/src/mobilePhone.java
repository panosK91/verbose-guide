import java.util.ArrayList;

public class mobilePhone {
   private ArrayList<Contact> myContacts;

    public mobilePhone() {
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >=0){
            System.out.println("Contact is already on file");
            return false;
        }
        System.out.println("Contact is added on file ");
        this.myContacts.add(contact);
        return true;
    }

    public boolean deleteContact(Contact contact){
        if(findContact(contact.getName()) <0){
            System.out.println("Contact is already on file");
            return false;
        }
        System.out.println("Contact is added on file ");

        this.myContacts.remove(findContact(contact));
        return true;

    }


    public Contact queryContact(String name){
        for ( int i=0; i< this.myContacts.size(); i++){
            if(this.myContacts.get(i).getName().equals(name)){
                return this.myContacts.get(i);
            }
        }
        return null;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if(position<0){
            System.out.println("The contact not found ");
            return false;
        } else {
            this.myContacts.set(position,newContact);

            System.out.println("The contact " + oldContact.getName() +" has changed in " + newContact.getName());
            return true;
        }


    }




    public  void printContacts(){
        for(int i =0; i<this.myContacts.size();  i++){
            System.out.println("Name -> " + this.myContacts.get(i).getName() + " Phone -> " + this.myContacts.get(i).getPhone() );
        }
    }



    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    private int findContact( String name){
        for(int i=0; i<this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if( contact.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }


}
