package org.erp.school.prototype;

import org.erp.school.client.Client;
import org.erp.school.global.enums.SizeCategory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class ClientPrototype {

    public static Optional<Client> getTestClient(){
        Client testClient = new Client();

        testClient.setId("Test_Client");
        testClient.setName("Test_Organization");
        testClient.setAddress(AddressPrototype.getTestAddress(false));
        testClient.setDocuments(DocumentPrototype.getTestDocuments());
        testClient.setWebsite("Test_Website.com");
        testClient.setVerificationStatus("ACTIVE");
        testClient.setCreatedDate(new Timestamp(new Date().getTime()));
        testClient.setActivities(null);
        testClient.setStaffSize(SizeCategory.MICRO);
        testClient.setStudentSize(SizeCategory.MICRO);

        // can be changed later
        testClient.setUsers(null);

        return Optional.of(testClient);
    }
}
