package com.example.springaddressbook.service;

import com.example.springaddressbook.dto.AddressBookDTO;
import com.example.springaddressbook.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface AddressBookServiceI {
    //Method to insert Data In the DataBase
    AddressBook addData(AddressBookDTO addressBookDTO);
    //Get ID from AddressBook
    Optional<AddressBook> getById(int Id);
    //Get find person by firstName
    List<AddressBook> findByFirstName(String firstName);
    //Find person by Zipcode using Custom Query in Repository
    List<AddressBook> orderByZipcode();
    //Get all the data of AddressBook from DataBase
    List<AddressBook> getData();
    //Update the details of person in DataBase
    AddressBook updateData(AddressBookDTO addressBookDTO, int Id);
    //Delete Data By using Id
    List<AddressBook> deleteById(int ID);
}
