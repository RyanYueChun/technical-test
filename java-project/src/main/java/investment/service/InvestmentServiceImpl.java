package investment.service;

import investment.models.Investment;
import investment.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
