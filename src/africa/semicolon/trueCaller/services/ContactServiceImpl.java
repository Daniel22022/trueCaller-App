package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;

public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl contactService(){
        return null;
    }
    public ContactServiceImpl(){
        this.contactRepository = contactRepository;
    }

    // save contact to repository
    // return contact
    @Override
    public Contact addNewContact(Contact contact) {
        return null;

    }
}


