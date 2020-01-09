package investment.models;

public class InvestmentJson {

    private String id;
    private String titreoperation;
    private String entreprise;
    private String annee_de_livraison;
    private String ville;
    private String mandataire;
    private String ppi;
    private float nombre_de_lots;
    private String lycee;
    private String notification_du_marche;
    private String codeuai;
    private double longitude;
    private String etat_d_avancement;
    private float montant_des_ap_votes_en_meu;
    private String cao_attribution;
    private double latitude;
    private String maitrise_d_oeuvre;
    private String mode_de_devolution;
    private String annee_d_individualisation;
    private float enveloppe_prev_en_meu;

    public void fillJsonFromInvestment(Investment investment) {

        this.id = investment.getId();
        this.titreoperation = investment.getOperationTitle();
        this.entreprise = investment.getEnterprise();
        this.annee_de_livraison = investment.getDeliveryYear();
        this.ville = investment.getCity();
        this.mandataire = investment.getMandatary();
        this.ppi = investment.getPpi();
        this.nombre_de_lots = Float.parseFloat(investment.getLotAmount() != null ? investment.getLotAmount() : "0");
        this.lycee = investment.getHighSchool();
        this.notification_du_marche = investment.getMarketNotification();
        this.codeuai = investment.getUaiCode();
        this.longitude = Double.parseDouble(investment.getLongitude() != null ? investment.getLongitude() : "0");
        this.etat_d_avancement = investment.getAdvancementState();
        this.montant_des_ap_votes_en_meu = Float.parseFloat(investment.getAmountApVotesInMeu() != null ? investment.getAmountApVotesInMeu() : "0");
        this.cao_attribution = investment.getCaoAttribution();
        this.latitude = Double.parseDouble(investment.getLatitude() != null ? investment.getLatitude() : "0");
        this.maitrise_d_oeuvre = investment.getProjectManagement();
        this.mode_de_devolution = investment.getDevolutionMode();
        this.annee_d_individualisation = investment.getIndividualisationYear();
        this.enveloppe_prev_en_meu = Float.parseFloat(investment.getPrevEnvelopeInMeu() != null ? investment.getPrevEnvelopeInMeu() : "0");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitreoperation() {
        return titreoperation;
    }

    public void setTitreoperation(String titreoperation) {
        this.titreoperation = titreoperation;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getAnnee_de_livraison() {
        return annee_de_livraison;
    }

    public void setAnnee_de_livraison(String annee_de_livraison) {
        this.annee_de_livraison = annee_de_livraison;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMandataire() {
        return mandataire;
    }

    public void setMandataire(String mandataire) {
        this.mandataire = mandataire;
    }

    public String getPpi() {
        return ppi;
    }

    public void setPpi(String ppi) {
        this.ppi = ppi;
    }

    public float getNombre_de_lots() {
        return nombre_de_lots;
    }

    public void setNombre_de_lots(float nombre_de_lots) {
        this.nombre_de_lots = nombre_de_lots;
    }

    public String getLycee() {
        return lycee;
    }

    public void setLycee(String lycee) {
        this.lycee = lycee;
    }

    public String getNotification_du_marche() {
        return notification_du_marche;
    }

    public void setNotification_du_marche(String notification_du_marche) {
        this.notification_du_marche = notification_du_marche;
    }

    public String getCodeuai() {
        return codeuai;
    }

    public void setCodeuai(String codeuai) {
        this.codeuai = codeuai;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getEtat_d_avancement() {
        return etat_d_avancement;
    }

    public void setEtat_d_avancement(String etat_d_avancement) {
        this.etat_d_avancement = etat_d_avancement;
    }

    public float getMontant_des_ap_votes_en_meu() {
        return montant_des_ap_votes_en_meu;
    }

    public void setMontant_des_ap_votes_en_meu(float montant_des_ap_votes_en_meu) {
        this.montant_des_ap_votes_en_meu = montant_des_ap_votes_en_meu;
    }

    public String getCao_attribution() {
        return cao_attribution;
    }

    public void setCao_attribution(String cao_attribution) {
        this.cao_attribution = cao_attribution;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getMaitrise_d_oeuvre() {
        return maitrise_d_oeuvre;
    }

    public void setMaitrise_d_oeuvre(String maitrise_d_oeuvre) {
        this.maitrise_d_oeuvre = maitrise_d_oeuvre;
    }

    public String getMode_de_devolution() {
        return mode_de_devolution;
    }

    public void setMode_de_devolution(String mode_de_devolution) {
        this.mode_de_devolution = mode_de_devolution;
    }

    public String getAnnee_d_individualisation() {
        return annee_d_individualisation;
    }

    public void setAnnee_d_individualisation(String annee_d_individualisation) {
        this.annee_d_individualisation = annee_d_individualisation;
    }

    public float getEnveloppe_prev_en_meu() {
        return enveloppe_prev_en_meu;
    }

    public void setEnveloppe_prev_en_meu(float enveloppe_prev_en_meu) {
        this.enveloppe_prev_en_meu = enveloppe_prev_en_meu;
    }

    @Override
    public String toString() {
        return "InvestmentJson{" +
                "id='" + id + '\'' +
                ", titreoperation='" + titreoperation + '\'' +
                ", entreprise='" + entreprise + '\'' +
                ", annee_de_livraison='" + annee_de_livraison + '\'' +
                ", ville='" + ville + '\'' +
                ", mandataire='" + mandataire + '\'' +
                ", ppi='" + ppi + '\'' +
                ", nombre_de_lots=" + nombre_de_lots +
                ", lycee='" + lycee + '\'' +
                ", notification_du_marche='" + notification_du_marche + '\'' +
                ", codeuai='" + codeuai + '\'' +
                ", longitude=" + longitude +
                ", etat_d_avancement='" + etat_d_avancement + '\'' +
                ", montant_des_ap_votes_en_meu=" + montant_des_ap_votes_en_meu +
                ", cao_attribution='" + cao_attribution + '\'' +
                ", latitude=" + latitude +
                ", maitrise_d_oeuvre='" + maitrise_d_oeuvre + '\'' +
                ", mode_de_devolution='" + mode_de_devolution + '\'' +
                ", annee_d_individualisation='" + annee_d_individualisation + '\'' +
                ", enveloppe_prev_en_meu=" + enveloppe_prev_en_meu +
                '}';
    }
}
