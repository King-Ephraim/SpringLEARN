/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package artemis.sa.repositories;

import artemis.sa.entities.Sentiment;
import artemis.sa.enums.TypeSentiment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author code
 */
public interface SentimentRepository extends JpaRepository<Sentiment, Integer>{
    List<Sentiment> findByType(TypeSentiment type) ;
}
