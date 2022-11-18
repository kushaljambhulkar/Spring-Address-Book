package com.example.springaddressbook.service;

import com.example.springaddressbook.dto.AddressBookDTO;
import com.example.springaddressbook.exception.AddressBookException;
import com.example.springaddressbook.model.AddressBook;
import com.example.springaddressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements AddressBookServiceI {
    @Autowired
    AddressBookRepository addressBookRepository;

    //Method to insert Data In the DataBase
    @Override
    public AddressBook addData(AddressBookDTO addressBookDTO) {
        AddressBook addAddressBook = new AddressBook(addressBookDTO);
        addressBookRepository.save(addAddressBook);
        return addAddressBook;
    }
    //Get ID from AddressBook
    @Override
    public Optional<AddressBook> getById(int Id) {
        Optional<AddressBook> optional = addressBookRepository.findById(Id);
        if (optional.isPresent()){
            Optional<AddressBook> foundData = addressBookRepository.findById(Id);
            return foundData;
        }else
            throw new AddressBookException("Address-book of this id is not present");
    }
    //Get find person by firstName
    @Override
    public List<AddressBook> findByFirstName(String firstName) {
        List<AddressBook> person = addressBookRepository.findAddressBookByFirstName(firstName);
        if (person.isEmpty()){
            return person;
        } else {
            throw new AddressBookException("Person is not exist of this name!!!");
        }
    }
    //Find person by Zipcode using Custom Query in Repository
    @Override
    public List<AddressBook> orderByZipcode() {
        List<AddressBook> orderedList = addressBookRepository.orderByZipcode();
        if (orderedList.isEmpty()) {
            throw new AddressBookException("There are no Persons which can be ordered by zipcode");
        } else {
            return orderedList;
        }
    }
    //Get all the data of AddressBook from DataBase
    @Override
    public List<AddressBook> getData() {
        if (addressBookRepository.findAll().isEmpty()){
            throw new AddressBookException("No person Present in the database");
        }else
            return addressBookRepository.findAll();
    }
    //Update the details of person in DataBase
    @Override
    public AddressBook updateData(AddressBookDTO addressBookDTO, int Id) {
        Optional<AddressBook> optional = addressBookRepository.findById(Id);
        if (optional.isPresent()){
            AddressBook updateAddressBook = new AddressBook(Id,addressBookDTO);
            addressBookRepository.save(updateAddressBook);
            return updateAddressBook;
        } else {
            throw new AddressBookException("person not present in the list to update");
        }
    }
    //Delete Data By using Id
    @Override
    public List<AddressBook> deleteById(int Id) {
        if (addressBookRepository.existsById(Id)){
            addressBookRepository.deleteById(Id);
            return addressBookRepository.findAll();
        } else {
            throw new AddressBookException("Id is not present to delete in database");
        }
    }
}
