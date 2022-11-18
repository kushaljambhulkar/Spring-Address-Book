package com.example.springaddressbook.repository;

import com.example.springaddressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook,Integer> {

    // Find Person in the Address-book by its first name
    @Query(value = "select * from address_book where first_Name= :firstName", nativeQuery = true)
    List<AddressBook> findAddressBookByFirstName(String firstName);

    //Query to Sort Person in the Address-book by their pin-code
    @Query(value = "select * from address_book group by zip_code order by zip_code ", nativeQuery = true)
    List<AddressBook> orderByZipcode();

}
