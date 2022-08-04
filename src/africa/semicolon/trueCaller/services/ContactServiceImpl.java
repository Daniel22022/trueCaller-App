package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.dto.responses.AddContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;



    // save contact to repository
    // return contact
    @Override
    public Contact addNewContact(Contact contact) {
        return contactRepository.save(contact);


    }

    @Override
    public AddContactResponse addContactMessage(AddContactResponse addContactResponse) {
        addContactResponse.setMessage("Contact added successfully");
        return addContactResponse;
    }
}


