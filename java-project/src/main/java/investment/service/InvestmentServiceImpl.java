package investment.service;

import investment.models.Investment;
import investment.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Override
    public Optional<Investment> findById(String id) {
        return investmentRepository.findById(id);
    }

    @Override
    public Iterable<Investment> findAll() {
        return investmentRepository.findAll();
    }

    @Override
    public void saveAll(Iterable<Investment> investments) {
        investmentRepository.saveAll(investments);
    }

    @Override
    public void deleteById(String id) {
        investmentRepository.deleteById(id);
    }

    @Override
    public Iterable<Investment> findByCity(String city) {
        return investmentRepository.findByCityIgnoreCase(city);
    }

    @Override
    public Iterable<Investment> findByAdvancementState(String advancementState) {
        return investmentRepository.findByAdvancementStateIgnoreCase(advancementState);
    }

    @Override
    public List<Investment> findByCityAndAdvancementStateAllIgnoreCase(String city, String advancementState) {
        return investmentRepository.findByCityAndAdvancementStateAllIgnoreCase(city, advancementState);
    }
}
