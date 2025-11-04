package com.crypto.Criptografia.Service;

import com.crypto.Criptografia.Entity.Payment;
import com.crypto.Criptografia.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository payRepo;

    public PaymentService(PaymentRepository payRepo){this.payRepo = payRepo;}

    public Payment create (Payment payment){return  payRepo.save(payment);}
    public Optional<Payment> findById(Long id){return payRepo.findById(id);}
    public List<Payment>findAll(){return payRepo.findAll();}
    public Payment update(Long id, Payment update){
        return payRepo.findById(id).map(p -> {
            p.setUserDocument(update.getUserDocument());
            p.setCreditCardToken(update.getCreditCardToken());
            p.setpaymentValue(update.getpaymentValue());
            return payRepo.save(p);
        }).orElseThrow(()-> new RuntimeException("Não encontrado"));
    }
    public void delete(Long id){payRepo.deleteById(id);}
}
