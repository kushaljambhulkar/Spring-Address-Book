package com.example.springaddressbook.controller;


import com.example.springaddressbook.dto.AddressBookDTO;
import com.example.springaddressbook.dto.ResponseDTO;
import com.example.springaddressbook.model.AddressBook;
import com.example.springaddressbook.service.AddressBookService;
import com.example.springaddressbook.service.AddressBookServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AddressbookController {
@Autowired
    AddressBookServiceI addressBookServiceI;
    //Method to insert Data In the DataBase
    @PostMapping("/insert-data")
    public ResponseEntity<ResponseDTO> addData(@RequestBody AddressBookDTO addressBookDTO){
        AddressBook addAddressBookDTO = addressBookServiceI.addData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data Added in Repository Successfully",addAddressBookDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    //Get ID from AddressBook
    @GetMapping("/getById/{Id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int Id){
        Optional<AddressBook> addressBookDTO = addressBookServiceI.getById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Id Successfully",addressBookDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.FOUND);
    }
    //Get find person by firstName
    @GetMapping("/getByFirstName")
    public ResponseEntity<ResponseDTO> getByFirstName(@RequestParam String firstName) {
        List<AddressBook> person = addressBookServiceI.findByFirstName(firstName);
        ResponseDTO responseDTO = new ResponseDTO("Persons who have this first name are!!", person);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    //Find person by Zipcode using Custom Query in Repository
    @GetMapping("/orderByZipcode")
    public ResponseEntity<ResponseDTO> orderByZipcode() {
        List<AddressBook> person = addressBookServiceI.orderByZipcode();
        ResponseDTO responseDTO = new ResponseDTO("Persons ordered according to zipcode", person);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }
    //Get all the data of AddressBook from DataBase
    @GetMapping("/get-all")
    public List<AddressBook> getData(){
        return addressBookServiceI.getData();
    }
    //Update the details of person in DataBase
    @PutMapping("/update/{Id}")
    public ResponseEntity<ResponseDTO> updateData(@RequestBody AddressBookDTO addressBookDTO, @PathVariable int Id){
        AddressBook updateAddressBook = addressBookServiceI.updateData(addressBookDTO,Id);
        ResponseDTO responseDTO = new ResponseDTO("Data Updated Successfully",updateAddressBook);
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    //Delete Data By using Id
    @DeleteMapping("/delete-id")
    public ResponseEntity<ResponseDTO> deleteById(@RequestParam int ID) {
        List<AddressBook> addressBook = addressBookServiceI.deleteById(ID);
        ResponseDTO responseDTO = new ResponseDTO("Data deleted Successfully in Repo", addressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
