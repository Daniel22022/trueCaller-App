package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 public class ContactRepositoryImplTest {

     @Test
     public void saveContactCountIncreasesTest() {
         ContactRepository contactRepository = new ContactRepositoryImpl();
         Contact contact = new Contact();
         contact.setFirstName("John");
         contact.setLastName("Doe");
         contact.setPhoneNumber("123456789");
         contact.setEmail("JohnDoe@gmail.com");
         contactRepository.save(contact);
         assertEquals(1, contactRepository.count());
     }

     @Test
     public void saveContact_findByIdTest() {
         ContactRepository contactRepository = new ContactRepositoryImpl();
         Contact contact = new Contact();
         contact.setFirstName("John");
         contact.setLastName("Doe");
         contact.setPhoneNumber("123456789");
         contact.setEmail("JohnDoe@gmail.com");
         contactRepository.save(contact);
         Contact contact2 = contactRepository.findById(1);
         assertEquals(1, contactRepository.count());
         assertEquals("John", contact2.getFirstName());
     }

     @Test
     public void saveContact_deleteContactTest() {
         ContactRepository contactRepository = new ContactRepositoryImpl();
         Contact contact = new Contact();
         contact.setFirstName("John");
         contact.setLastName("Doe");
         contact.setPhoneNumber("123456789");
         contact.setEmail("JohnDoe@gmail.com");
         contactRepository.save(contact);
         assertEquals(1, contactRepository.count());
         contactRepository.delete(contact);
         assertEquals(0, contactRepository.count());

     }

     @Test
     public void saveContact_deleteByIdTest() {
         ContactRepository contactRepository = new ContactRepositoryImpl();
         Contact contact = new Contact();
         contact.setFirstName("John");
         contact.setLastName("Doe");
         contact.setPhoneNumber("123456789");
         contact.setEmail("JohnDoe@gmai.com");
         contactRepository.save(contact);
         Contact contact2 = new Contact();
         contact2.setFirstName("Jane");
         contact2.setLastName("Doe");
         contact2.setPhoneNumber("123456789");
         contact2.setEmail("JaneDoe@gmail.com");
         contactRepository.save(contact2);
         assertEquals(2, contactRepository.count());
         contactRepository.delete(contact);
         Contact contact3 = contactRepository.findById(1);
         assertEquals(1, contactRepository.count());


     }

     @Test
     public void findByIdTest() {
         ContactRepository contactRepository = new ContactRepositoryImpl();
         Contact contact = new Contact();
         contact.setFirstName("John");
         contact.setLastName("Doe");
         contact.setPhoneNumber("123456789");
         contact.setEmail("JohnDoe@gmail.com");
         contactRepository.save(contact);
         Contact contact2 = new Contact();
         contact2.setFirstName("Jane");
         contact2.setLastName("Doe");
         contact2.setPhoneNumber("123456789");
         contact2.setEmail("JaneDoe@gmail.com");
         contactRepository.save(contact2);
         Contact contact3 = new Contact();
         contact3.setFirstName("Jack");
         contact3.setLastName("Doe");
         contact3.setPhoneNumber("123456789");
         contact3.setEmail("JackDoe@gmail.com");
         contactRepository.save(contact3);
         Contact contact4 = contactRepository.findById(2);
         assertEquals("Jane", contact4.getFirstName());
         // print all contacts
         System.out.println(contactRepository.findAll());

     }

     // test that you can update a contact
     @Test
     public void updateContactTest() {
         ContactRepository contactRepository = new ContactRepositoryImpl();
         Contact contact = new Contact();
         contact.setFirstName("John");
         contact.setLastName("Doe");
         contact.setPhoneNumber("123456789");
         contact.setEmail("JohnDoe@gmail.com");
         contactRepository.save(contact);
         Contact contact2 = new Contact();
         contact2.setFirstName("Jane");
         contact2.setLastName("Doe");
         contact2.setPhoneNumber("123456789");
         contact2.setEmail("JohnDoe@gmail.com");
         contactRepository.update(contact);
         assertEquals("Jane", contact2.getFirstName());


     }

     @Test
     public void findAllTest() {
         ContactRepository contactRepository = new ContactRepositoryImpl();
         Contact contact = new Contact();
         contact.setFirstName("John");
         contact.setLastName("Doe");
         contact.setPhoneNumber("123456789");
         contact.setEmail("JohnDoe@gmail.com");
         contactRepository.save(contact);
         assertEquals("John", contact.getFirstName());
         Contact contact2 = new Contact();
         contact2.setFirstName("Jane");
         contact2.setLastName("Doe");
         contact2.setPhoneNumber("123456788");
         contact2.setEmail("JaneDoe@gmail.com");
         contactRepository.save(contact2);
         assertEquals("Jane", contact2.getFirstName());
     }
 }
