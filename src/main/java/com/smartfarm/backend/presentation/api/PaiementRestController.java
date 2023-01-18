package com.smartfarm.backend.presentation.api;

import com.smartfarm.backend.model.dto.PaiementcarteDto;
import com.smartfarm.backend.service.IPaiement;
//import com.stripe.exception.StripeException;
//import com.stripe.model.Charge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/paiement")
@Slf4j
public class PaiementRestController {

    @Autowired
    IPaiement iPaiement;

//    @PostMapping("/checkout")
//    public ResponseEntity<Charge> checkout(@RequestBody PaiementcarteDto paiementcarteDto) throws StripeException {
//        PaiementRestController.log.info("Paiement d'une commande");
//        return ResponseEntity.ok(iPaiement.makePayment(paiementcarteDto));
//    }
}
