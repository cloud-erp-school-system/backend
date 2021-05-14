package org.erp.school.client.repository;

import org.erp.school.client.Client;
import org.erp.school.prototype.ClientPrototype;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void findByDocumentsId() {
        clientRepository.save(ClientPrototype.getTestClient().get());
        Client client = clientRepository.findById(ClientPrototype.getTestClient().get().getId()).orElse(null);
        assertThat(client).isNotNull();
        assertThat(client.getName()).isEqualTo(ClientPrototype.getTestClient().get().getName());
        assertThat(client.getId()).isEqualTo(ClientPrototype.getTestClient().get().getId());
    }
}