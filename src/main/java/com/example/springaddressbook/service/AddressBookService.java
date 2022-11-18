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


    @Override
    public AddressBook addData(AddressBookDTO addressBookDTO) {
        AddressBook addAddressBook = new AddressBook(addressBookDTO);
        addressBookRepository.save(addAddressBook);
        return addAddressBook;
    }

    @Override
    public Optional<AddressBook> getById(int Id) {
        Optional<AddressBook> optional = addressBookRepository.findById(Id);
        if (optional.isPresent()){
            Optional<AddressBook> foundData = addressBookRepository.findById(Id);
            return foundData;
        }else
            throw new AddressBookException("Address-book of this id is not present");
    }

    @Override
    public List<AddressBook> findByFirstName(String firstName) {
        List<AddressBook> person = addressBookRepository.findAddressBookByFirstName(firstName);
        if (person.isEmpty()){
            return person;
        } else {
            throw new AddressBookException("Person is not exist of this name!!!");
        }
    }

    @Override
    public List<AddressBook> findByCity(String city) {
        List<AddressBook> personOfSameCity = addressBookRepository.
                personsOfSameCity(city);
        if (personOfSameCity.isEmpty()) {
            throw new AddressBookException("There are no Persons in the same city");
        } else {
            return personOfSameCity;
        }
    }

    @Override
    public List<AddressBook> orderByZipcode() {
        List<AddressBook> orderedList = addressBookRepository.orderByZipcode();
        if (orderedList.isEmpty()) {
            throw new AddressBookException("There are no Persons which can be ordered by zipcode");
        } else {
            return orderedList;
        }
    }

    @Override
    public List<AddressBook> getData() {
        if (addressBookRepository.findAll().isEmpty()){
            throw new AddressBookException("No Address-book Present in the database");
        }else
            return addressBookRepository.findAll();
    }

    @Override
    public AddressBook updateData(AddressBookDTO addressBookDTO, int Id) {
        Optional<AddressBook> optional = addressBookRepository.findById(Id);
        if (optional.isPresent()){
            AddressBook updateAddressBook = new AddressBook(Id,addressBookDTO);
            addressBookRepository.save(updateAddressBook);
            return updateAddressBook;
        } else {
            throw new AddressBookException("Address-book not present in the list to update");
        }
    }

    @Override
    public List<AddressBook> deleteById(int Id) {
        if (addressBookRepository.existsById(Id)){
            addressBookRepository.deleteById(Id);
            return addressBookRepository.findAll();
        } else {
            throw new AddressBookException("Id is not present to delete in database");
        }
    }

    @Override
    public List<AddressBook> deleteAll() {
        if (addressBookRepository.findAll().isEmpty()){
            throw new AddressBookException("No address-book Present to delete");
        } else addressBookRepository.deleteAll();
        return addressBookRepository.findAll();
    }
}
