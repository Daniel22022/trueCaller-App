package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceImplTest {

    @Test
    void  addNewContact(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
         ContactService contactService  = new ContactServiceImpl();
        Contact contact = new Contact();
        contact.setFirstName("John");
        contact.setLastName("Doe");
        contact.setPhoneNumber("123456789");
        contact.setEmail("JohnDoe@gmail.com");
        contactService.addNewContact(contact);
        assertNotEquals(0, contactService.addNewContact(contact));
    }

}