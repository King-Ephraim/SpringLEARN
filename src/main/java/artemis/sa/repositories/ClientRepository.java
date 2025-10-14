/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package artemis.sa.repositories;

import artemis.sa.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author code
 */
public interface ClientRepository extends JpaRepository<Client, Integer>{
    
    Client findByEmail(String email) ;
    
}
