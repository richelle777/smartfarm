package com.smartfarm.backend.serviceImpl;

import com.smartfarm.backend.mapper.PaiementcarteMapper;
import com.smartfarm.backend.model.dto.PaiementcarteDto;
import com.smartfarm.backend.repository.PaiementcarteRepository;
import com.smartfarm.backend.service.IPaiement;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaiementImplService implements IPaiement {
    @Autowired
    PaiementcarteMapper paiementcarteMapper;

    @Autowired
    PaiementcarteRepository paiementcarteRepository;

    //Clé secrète générée par stripe au dashboard
    private final String secretKey = "sk_test_51MR9AhEl4mIYP5xTI5OZdXpxs1UgjCHikRr2rpQZMfxTYyotcp2rMBX63Lp5pzqfh49lVN4m6Pze1Q1ysDrQUmPg00oI7WacMc";

    @Override
    public Charge makePayment(PaiementcarteDto paiementcarteDto) throws StripeException {
        Stripe.apiKey = secretKey; // Affectation de la clé à l'api

        // Préparation des paramètres pour l'objet
        Map<String, Object> params = new HashMap<>();
        params.put("amount", paiementcarteDto.getPaiementDto().getMontant());
        params.put("currency", paiementcarteDto.getCurrency());
        params.put("source", paiementcarteDto.getNumeroCarte());
        params.put("description", "Achat d'une commande d'un montant de : " + paiementcarteDto.getPaiementDto().getMontant());

        // Création d'un nouvel ID de paiement
        Boolean isIdNotNew = true;
        String id = "";
        while (isIdNotNew){
            long code = Math.round(Math.random() * 10000);
            id = "PA" + code;
            if (!paiementcarteRepository.existsById(id))
                isIdNotNew = false;
        }
        paiementcarteDto.setId(id);
        paiementcarteDto.getPaiementDto().setId(id);
        // Mettre à jour le statut de la commande
        paiementcarteDto.getPaiementDto().getCommandeDto().setStatutCommande("Payé");
        // Enregistrement de la commande en BD
        paiementcarteRepository.save(paiementcarteMapper.toEntity(paiementcarteDto));

        return Charge.create(params);
    }
}
