package com.example.springaddressbook.service;

import com.example.springaddressbook.dto.AddressBookDTO;
import com.example.springaddressbook.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface AddressBookServiceI {
    AddressBook addData(AddressBookDTO addressBookDTO);

    Optional<AddressBook> getById(int Id);

    List<AddressBook> findByFirstName(String firstName);

    List<AddressBook> findByCity(String city);

    List<AddressBook> orderByZipcode();

    List<AddressBook> getData();

    AddressBook updateData(AddressBookDTO addressBookDTO, int Id);

    List<AddressBook> deleteById(int ID);

    List<AddressBook> deleteAll();
}
