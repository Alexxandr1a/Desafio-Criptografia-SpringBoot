package com.crypto.Criptografia.Controller;

import com.crypto.Criptografia.Entity.Payment;
import com.crypto.Criptografia.Service.PaymentService;
import com.crypto.Criptografia.Repository.PaymentRepository;
import com.crypto.Criptografia.dto.EncryptedPaymentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;
    private final PaymentRepository repo;

    public PaymentController(PaymentService service, PaymentRepository repo) {
        this.service = service;
        this.repo = repo;
    }


    @GetMapping
    public List<Payment> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        Payment saved = service.create(payment);
        return ResponseEntity.created(URI.create("/api/payments/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment payment) {
        try {
            Payment update = service.update(id, payment);
            return ResponseEntity.ok(update);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/encrypted")
    public List<EncryptedPaymentDto> allEncrypted() {
        List<Object[]> rows = repo.findAllRaw();
        return rows.stream().map(this::toEncryptedDto).collect(Collectors.toList());
    }


    @GetMapping("/encrypted/{id}")
    public ResponseEntity<EncryptedPaymentDto> getEncryptedById(@PathVariable Long id) {
        Object[] row = repo.findRawById(id);
        if (row == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(toEncryptedDto(row));
    }

    private EncryptedPaymentDto toEncryptedDto(Object[] row) {
        Long id = row[0] == null ? null : ((Number) row[0]).longValue();
        String token = row[1] == null ? null : row[1].toString();
        String doc = row[2] == null ? null : row[2].toString();
        Long val = row[3] == null ? null : ((Number) row[3]).longValue();
        return new EncryptedPaymentDto(id, token, doc, val);
    }
}
