package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dto.responses.AddContactResponse;


public interface ContactService {
    Contact addNewContact(Contact contact);

    // save contact to repository
    // return contact
    AddContactResponse addContactMessage(AddContactResponse addContactResponse);
}
