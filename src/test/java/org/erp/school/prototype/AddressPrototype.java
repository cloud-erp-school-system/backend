package org.erp.school.prototype;

import org.erp.school.address.Address;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AddressPrototype {

    public static Set<Address> getTestAddress(boolean isPrimary){
        Set<Address> testAddressSet = new HashSet<>();
        Address testAddress = new Address();

        testAddress.setId(UUID.randomUUID().toString());
        testAddress.setCity("Test_City");
        testAddress.setCountry("Test_Country");
        testAddress.setPrimary(isPrimary);
        testAddress.setPostcode("11111");
        testAddress.setStreet("Test_Street");

        testAddressSet.add(testAddress);

        return testAddressSet;
    }
}
