package investment.controller;

import investment.models.Investment;
import investment.models.InvestmentJson;
import investment.models.MessageLog;
import investment.models.ResponseMessage;
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
        logEvent("fetching all investments");
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
    public ResponseEntity<ResponseMessage> saveAllInvestments(@RequestBody Iterable<InvestmentJson> investmentJsons) {
        ResponseMessage responseMessage = new ResponseMessage();
        logEvent("saving a list of investments");
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

            responseMessage.setContent(investments.size() + " investmesnts added!");
            logEvent("list of investments saved");
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }
        responseMessage.setContent("No valid investments to add");
        logEvent("could not save list of investment");
        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @DeleteMapping(value = "/deleteById/{investment-id}")
    public ResponseEntity<ResponseMessage> deleteInvestmentById(@PathVariable(name = "investment-id") String id) {
        ResponseMessage responseMessage = new ResponseMessage();
        logEvent("deleting investmentby id = " + id);
        investmentService.deleteById(id);

        responseMessage.setContent("Investment of id : " + id + " deleted");
        logEvent("deleted investment by id = " + id);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/getByCity")
    public ResponseEntity<List<InvestmentJson>> getInvestmentByCity(@RequestBody ResponseMessage body) {
        String city = body.getContent();
        logEvent("fetching investments by city = " + city);
        Iterator<Investment> investmentIterator = investmentService.findByCity(city).iterator();

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
            logEvent("investments fetched by city");
            return new ResponseEntity<>(investmentJsons, HttpStatus.OK);
        }
        logEvent("could not fetch investments by city");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping(value = "/getByAdvancementState")
    public ResponseEntity<List<InvestmentJson>> getInvestmentByAdvancementState(@RequestBody ResponseMessage body) {
        String advancementState = body.getContent();
        logEvent("fetching investments by advancementState = " + advancementState);
        Iterator<Investment> investmentIterator = investmentService.findByAdvancementState(advancementState).iterator();

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
            logEvent("investments fetched by advancementState");
            return new ResponseEntity<>(investmentJsons, HttpStatus.OK);
        }
        logEvent("could not fetch investments by advancementState");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping(value = "/getByCityAndAdvancementState")
    public ResponseEntity<List<InvestmentJson>> getInvestmentByCityAndAdvancementState(@RequestBody ResponseMessage body) {
        String city = body.getContent();
        String advancementState = body.getContent2();
        logEvent("fetching investments by city = " + city + " and advancementState = " + advancementState);
        Iterator<Investment> investmentIterator = investmentService.findByCityAndAdvancementStateAllIgnoreCase(city, advancementState).iterator();

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
            logEvent("investments fetched by city and advancementState");
            return new ResponseEntity<>(investmentJsons, HttpStatus.OK);
        }
        logEvent("could not fetch investments by city and advancementState");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private void logEvent(String event) {
        MessageLog messageLog = new MessageLog();
        messageLog.setTimeStamp(Calendar.getInstance());
        messageLog.setMessage(event);

        messageLogsService.save(messageLog);
    }
}
