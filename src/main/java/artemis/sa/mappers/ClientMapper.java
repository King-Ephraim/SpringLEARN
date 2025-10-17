/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artemis.sa.mappers;

import artemis.sa.dto.ClientDTO;
import artemis.sa.entities.Client;
import java.util.function.Function;
import org.springframework.stereotype.Component;

/**
 *
 * @author code
 */
@Component
public class ClientMapper implements Function<Client, ClientDTO>{

    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(), client.getEmail(), client.getTelephone()) ;
    }
    
}
