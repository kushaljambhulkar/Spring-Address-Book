package com.example.springaddressbook.dto;


import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;

public @Data class AddressBookDTO {

    @NotEmpty(message = "First Name is mandatory")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "First Name is Invalid!!!")
    private String firstName;

    @NotNull
    private String lastName;

    @Pattern(regexp = ".{10,50}", message = "Address should be 10 to 50 words")
    private String address;

    @Pattern(regexp = "[0-9]{10}", message = "Mobile number should be 10 digits")
    private Long phoneNumber;

    private String state;
    private String city;

    @Pattern(regexp = "[0-9]{6}", message = "Pin code should be Minimum 6 characters")
    private String zipCode;
    //^\d{5}(?:[-\s]\d{4})?$

}
