/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artemis.sa.services;

import artemis.sa.entities.Client;
import artemis.sa.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author code
 */
@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client) {
        Client clientBd = this.clientRepository.findByEmail(client.getEmail());
        if (clientBd == null) {
            this.clientRepository.save(client);
        }

    }

    public List<Client> list() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(
                () -> new EntityNotFoundException("Aucun client ave cet identifiant")
        );
    }

    public Client lireOuCreer(Client clientACreer) {
        Client clientBd = this.clientRepository.findByEmail(clientACreer.getEmail());
        if (clientBd == null) {
            clientBd = this.clientRepository.save(clientACreer);
        }
        return clientBd;
    }

    public void modifier(int id, Client client) {
        Client clientBd = this.lire(id);
        if (clientBd.getId() == client.getId()) {
            clientBd.setEmail(client.getEmail());
            clientBd.setTelephone(client.getTelephone());
            this.clientRepository.save(clientBd);
        }

    }
}
