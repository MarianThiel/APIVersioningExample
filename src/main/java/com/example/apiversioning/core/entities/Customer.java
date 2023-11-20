package com.example.apiversioning.core.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private Address firstAddress;


    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", firstAddress=" + firstAddress +
                '}';
    }
}
