/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package artemis.sa.services;

import artemis.sa.entities.Client;
import artemis.sa.entities.Sentiment;
import artemis.sa.enums.TypeSentiment;
import artemis.sa.repositories.SentimentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author code
 */
@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void creer(Sentiment sentiment) {
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);
        
        // Analyse de mon sentiment
        sentiment.setType(TypeSentiment.POSITIF);
        
        if (sentiment.getTexte().contains("pas")) {
            sentiment.setType(TypeSentiment.NEGATIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> list(TypeSentiment type) {
        if (type == null) {
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);
        }
    }

    public void supprimer(int id) {
        this.sentimentRepository.deleteById(id);
    }
}
