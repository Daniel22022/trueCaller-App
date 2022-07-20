package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {

    private int counter;
    private final List<Contact> contacts = new ArrayList<>();

    @Override
    public Contact save(Contact contact) {

        counter++;
        contact.setId(counter);
        contacts.add(contact);

        Contact foundContact = findById(contact.getId());
        if (foundContact != null) {
            return foundContact;
        }
        return null;
    }


    @Override
    public void delete(Contact contact) {
        counter--;
        contacts.remove(contact);
        contact.setId(counter);

    }

    @Override
    public void delete(int id) {
        Contact foundContact = findById(id);
        contacts.remove(foundContact);
        foundContact.setId(counter);

    }

    @Override
    public Contact findById(int id) {
        for (var contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
//        for (Contact contact5 : .findAll()) {
//            System.out.println("Name: " + contact5.getFirstName());
//        }
        return null;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public void update(Contact contact) {
        Contact foundContact = findById(contact.getId());
        foundContact.setFirstName(contact.getFirstName());
        foundContact.setLastName(contact.getLastName());
        foundContact.setPhoneNumber(contact.getPhoneNumber());
        foundContact.setEmail(contact.getEmail());

    }
}

// Language: java