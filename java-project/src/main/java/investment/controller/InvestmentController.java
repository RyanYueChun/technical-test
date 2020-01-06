package investment.controller;

import investment.models.Investment;
import investment.models.InvestmentJson;
import investment.models.MessageLog;
import investment.service.InvestmentService;
import investment.service.MessageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/investments")
public class InvestmentController {

    @Autowired
    InvestmentService investmentService;
    @Autowired
    MessageLogService messageLogsService;

    @CrossOrigin
    @GetMapping(value = "/getById/{investment-id}")
    public ResponseEntity<InvestmentJson> getInvestmentById(@PathVariable(name = "investment-id") String id) {
        logEvent("fetching investment by Id = " + id);
        Optional<Investment> optionalInvestment = investmentService.findById(id);

        if (optionalInvestment.isPresent()) {
            InvestmentJson investmentJson = new InvestmentJson();
            try {
                investmentJson.fillJsonFromInvestment(optionalInvestment.get());
            } catch (IllegalFormatConversionException e) {
                logEvent(e.getLocalizedMessage());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            logEvent("investment fetched by Id = " + id);
            return new ResponseEntity<>(investmentJson, HttpStatus.OK);
        }
        logEvent("could not find investment corresponding to id = " + id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<InvestmentJson>> getAllInvestments() {
        logEvent("fetched all investments");
        Iterator<Investment> investmentIterator = investmentService.findAll().iterator();

        if (investmentIterator.hasNext()) {
            List<InvestmentJson> investmentJsons = new ArrayList<>();

            while (investmentIterator.hasNext()) {
                InvestmentJson investmentJson = new InvestmentJson();
                try {
                    investmentJson.fillJsonFromInvestment(investmentIterator.next());
                } catch (IllegalFormatConversionException e) {
                    logEvent(e.getLocalizedMessage());
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
                investmentJsons.add(investmentJson);
            }
            logEvent("all investments fetched");
            return new ResponseEntity<>(investmentJsons, HttpStatus.OK);
        }
        logEvent("could not fetch investments");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping(value = "/saveAll")
    public ResponseEntity<String> saveAllInvestments(@RequestBody Iterable<InvestmentJson> investmentJsons) {
        logEvent("save a list of investments");
        Iterator<InvestmentJson> investmentJsonIterator = investmentJsons.iterator();

        if (investmentJsonIterator.hasNext()) {
            List<Investment> investments = new ArrayList<>();

            while (investmentJsonIterator.hasNext()) {
                Investment investment = new Investment();
                try {
                    investment.fillInvestmentFromJson(investmentJsonIterator.next());
                } catch (IllegalFormatConversionException e) {
                    logEvent(e.toString());
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
                investments.add(investment);
            }
            investmentService.saveAll(investments);

            logEvent("list of investments saved");
            return new ResponseEntity<>(investments.size() + " investmesnts added!", HttpStatus.OK);
        }
        logEvent("could not save list of investment");
        return new ResponseEntity<>("No valid investments to add", HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @DeleteMapping(value = "/deleteById/{investment-id}")
    public ResponseEntity<String> deleteInvestmentById(@PathVariable(name = "investment-id") String id) {
        logEvent("deleting investmentby id = " + id);
        investmentService.deleteById(id);

        logEvent("deleted investment by id = " + id);
        return new ResponseEntity<>("Investment of id : " + id + " deleted", HttpStatus.OK);
    }

    private void logEvent(String event) {
        MessageLog messageLog = new MessageLog();
        messageLog.setTimeStamp(Calendar.getInstance());
        messageLog.setMessage(event);

        messageLogsService.save(messageLog);
    }
}
