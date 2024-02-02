package se.mbaeumer.springbootlab.postgresql.part6;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;
    private AddressService addressService;

    public ContactController(ContactService contactService, AddressService addressService) {
        this.contactService = contactService;
        this.addressService = addressService;
    }

    @GetMapping("")
    public List<Contact> getAllContacts(){
        return this.contactService.getContacts();
    }

    @GetMapping("/city")
    public List<Contact> getAllContactsByCity(){
        return this.contactService.getContactsFromCity();
    }

    @GetMapping("/postalcode")
    public List<Contact> getAllContactsByPostalCode(){
        return this.contactService.getContactsByPostalCode();
    }

    @PostMapping("")
    public void createContact(@RequestBody final Contact contact){
        contactService.createContact(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable("id") final String id){
        contactService.deleteContact(Long.parseLong(id));
    }
}
