package investment.service;

import investment.models.Investment;

import java.util.List;
import java.util.Optional;

public interface InvestmentService {
    Optional<Investment> findById(String id);
    Iterable<Investment> findAll();
    void saveAll(Iterable<Investment> investments);
    void deleteById(String id);
}
