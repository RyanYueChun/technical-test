package investment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "investment-index", type = "_doc")
public class Investment {

    @Id
    private String id;
    private String operationTitle;
    private String enterprise;
    private String deliveryYear;
    private String city;
    private String mandatary;
    private String ppi;
    private String lotAmount;
    private String highSchool;
    private String marketNotification;
    private String uaiCode;
    private String longitude;
    private String advancementState;
    private String amountApVotesInMeu;
    private String caoAttribution;
    private String latitude;
    private String projectManagement;
    private String devolutionMode;
    private String individualisationYear;
    private String prevEnvelopeInMeu;

    public void fillInvestmentFromJson(InvestmentJson investmentJson) {

//        this.id = String.valueOf(investmentJson.getId());
        this.operationTitle = investmentJson.getTitreoperation();
        this.enterprise = investmentJson.getEntreprise();
        this.deliveryYear = investmentJson.getAnnee_de_livraison();
        this.city = investmentJson.getVille();
        this.mandatary = investmentJson.getMandataire();
        this.ppi = investmentJson.getPpi();
        this.lotAmount = String.valueOf(investmentJson.getNombre_de_lots());
        this.highSchool = investmentJson.getLycee();
        this.marketNotification = investmentJson.getNotification_du_marche();
        this.uaiCode = investmentJson.getCodeuai();
        this.longitude = String.valueOf(investmentJson.getLongitude());
        this.advancementState = investmentJson.getEtat_d_avancement();
        this.amountApVotesInMeu = String.valueOf(investmentJson.getMontant_des_ap_votes_en_meu());
        this.caoAttribution = investmentJson.getCao_attribution();
        this.latitude = String.valueOf(investmentJson.getLatitude());
        this.projectManagement = investmentJson.getMaitrise_d_oeuvre();
        this.devolutionMode = investmentJson.getMode_de_devolution();
        this.individualisationYear = investmentJson.getAnnee_d_individualisation();
        this.prevEnvelopeInMeu = String.valueOf(investmentJson.getEnveloppe_prev_en_meu());

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperationTitle() {
        return operationTitle;
    }

    public void setOperationTitle(String operationTitle) {
        this.operationTitle = operationTitle;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getDeliveryYear() {
        return deliveryYear;
    }

    public void setDeliveryYear(String deliveryYear) {
        this.deliveryYear = deliveryYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMandatary() {
        return mandatary;
    }

    public void setMandatary(String mandatary) {
        this.mandatary = mandatary;
    }

    public String getPpi() {
        return ppi;
    }

    public void setPpi(String ppi) {
        this.ppi = ppi;
    }

    public String getLotAmount() {
        return lotAmount;
    }

    public void setLotAmount(String lotAmount) {
        this.lotAmount = lotAmount;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public String getMarketNotification() {
        return marketNotification;
    }

    public void setMarketNotification(String marketNotification) {
        this.marketNotification = marketNotification;
    }

    public String getUaiCode() {
        return uaiCode;
    }

    public void setUaiCode(String uaiCode) {
        this.uaiCode = uaiCode;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAdvancementState() {
        return advancementState;
    }

    public void setAdvancementState(String advancementState) {
        this.advancementState = advancementState;
    }

    public String getAmountApVotesInMeu() {
        return amountApVotesInMeu;
    }

    public void setAmountApVotesInMeu(String amountApVotesInMeu) {
        this.amountApVotesInMeu = amountApVotesInMeu;
    }

    public String getCaoAttribution() {
        return caoAttribution;
    }

    public void setCaoAttribution(String caoAttribution) {
        this.caoAttribution = caoAttribution;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getProjectManagement() {
        return projectManagement;
    }

    public void setProjectManagement(String projectManagement) {
        this.projectManagement = projectManagement;
    }

    public String getDevolutionMode() {
        return devolutionMode;
    }

    public void setDevolutionMode(String devolutionMode) {
        this.devolutionMode = devolutionMode;
    }

    public String getIndividualisationYear() {
        return individualisationYear;
    }

    public void setIndividualisationYear(String individualisationYear) {
        this.individualisationYear = individualisationYear;
    }

    public String getPrevEnvelopeInMeu() {
        return prevEnvelopeInMeu;
    }

    public void setPrevEnvelopeInMeu(String prevEnvelopeInMeu) {
        this.prevEnvelopeInMeu = prevEnvelopeInMeu;
    }
}
