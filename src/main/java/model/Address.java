package model;

import enums.AddressCountry;
import enums.AddressState;
import lombok.Data;

@Data
public class Address {
    private String company;
    private String address;
    private String city;
    private AddressState addressState;
    private String postalCode;
    private AddressCountry addressCountry;
    private String additionalInfo;
    private String homePhone;
    private String mobilePhone;
    private String myAddress;
}
