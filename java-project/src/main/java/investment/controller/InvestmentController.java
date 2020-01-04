package investment.controller;

import investment.models.Investment;
import investment.models.InvestmentJson;
import investment.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/investments")
public class InvestmentController {

    @Autowired
    InvestmentService investmentService;

    @CrossOrigin
    @GetMapping(value = "/getById/{investment-id}")
    public InvestmentJson getInvestmentById(@PathVariable(name = "investment-id") String id) {
        Optional<Investment> optionalInvestment = investmentService.findById(id);

        if (optionalInvestment.isPresent()) {
            InvestmentJson investmentJson = new InvestmentJson();
            investmentJson.fillJsonFromInvestment(optionalInvestment.get());

            return investmentJson;
        }
        return new InvestmentJson();
    }

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<InvestmentJson> getAllInvestments() {
        Iterator<Investment> investmentIterator = investmentService.findAll().iterator();


        if (investmentIterator.hasNext()) {
            List<InvestmentJson> investmentJsons = new ArrayList<>();

            while (investmentIterator.hasNext()) {
                InvestmentJson investmentJson = new InvestmentJson();
                investmentJson.fillJsonFromInvestment(investmentIterator.next());
                investmentJsons.add(investmentJson);
            }

            return investmentJsons;
        }

        return new ArrayList<InvestmentJson>();
    }

    @CrossOrigin
    @PostMapping(value = "/saveAll")
    public String saveAllInvestments(@RequestBody Iterable<InvestmentJson> investmentJsons) {
        Iterator<InvestmentJson> investmentJsonIterator = investmentJsons.iterator();

        if (investmentJsonIterator.hasNext()) {
            List<Investment> investments = new ArrayList<>();

            while (investmentJsonIterator.hasNext()) {
                Investment investment = new Investment();
                investment.fillInvestmentFromJson(investmentJsonIterator.next());
                investments.add(investment);
            }
            investmentService.saveAll(investments);
            return investments.size() + " investmesnts added!";
        }

        return "No valid investment to add";
    }

    @CrossOrigin
    @DeleteMapping(value = "/deleteInvestmentById/{investment-id}")
    public String deleteInvestmentById(@PathVariable(name = "investment-id") String id) {
        investmentService.deleteById(id);
        return "Investment of id : " + id + " deleted";
    }
}
