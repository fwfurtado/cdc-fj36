package br.com.caelum.buyer.repository;

import br.com.caelum.buyer.model.Buyer;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface BuyerRepository extends Repository<Buyer, Long> {
    Optional<Buyer> findByEmail(String email);

    Optional<Buyer> findById(Long id);

    void save(Buyer buyer);
}
