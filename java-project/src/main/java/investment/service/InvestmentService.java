package investment.service;

import investment.models.Investment;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface InvestmentService {
    Optional<Investment> findById(String id);
    Iterable<Investment> findAll();
    void saveAll(Iterable<Investment> investments);
    void deleteById(String id);

    Iterable<Investment> findByCity(@Nullable String city);
    Iterable<Investment> findByAdvancementState(@Nullable String advancementState);
    List<Investment> findByCityAndAdvancementStateAllIgnoreCase(@Nullable String city, @Nullable String advancementState);
}
