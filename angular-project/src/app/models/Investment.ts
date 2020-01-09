export class Investment {
    public id: string;
    public titreoperation: string;
    public entreprise: string;
    public annee_de_livraison: string;
    public ville: string;
    public mandataire: string;
    public ppi: string;
    public nombre_de_lots: number;
    public lycee: string;
    public notification_du_marche: string;
    public codeuai: string;
    public longitude: number;
    public etat_d_avancement: string;
    public montant_des_ap_votes_en_meu: number;
    public cao_attribution: string;
    public latitude: number;
    public maitrise_d_oeuvre: string;
    public mode_de_devolution: string;
    public annee_d_individualisation: string;
    public enveloppe_prev_en_meu: number;

    constructor (id: string, titreoperation: string, entreprise: string, annee_de_livraison: string, ville: string,
        mandataire: string, ppi: string, nombre_de_lots: number, lycee: string, notification_du_marche: string,
        codeuai: string, longitude: number, etat_d_avancement: string, montant_des_ap_votes_en_meu: number,
        cao_attribution: string, latitude: number, maitrise_d_oeuvre: string, mode_de_devolution: string,
        annee_d_individualisation: string, enveloppe_prev_en_meu: number) {
            this.id = id;
            this.titreoperation = titreoperation;
            this.entreprise = entreprise;
            this.annee_de_livraison = annee_de_livraison;
            this.ville = ville;
            this.mandataire = mandataire;
            this.ppi = ppi;
            this.nombre_de_lots = nombre_de_lots;
            this.lycee = lycee;
            this.notification_du_marche = notification_du_marche;
            this.codeuai = codeuai;
            this.longitude = longitude;
            this.etat_d_avancement = etat_d_avancement;
            this.montant_des_ap_votes_en_meu = montant_des_ap_votes_en_meu;
            this.cao_attribution = cao_attribution;
            this.latitude = latitude;
            this.maitrise_d_oeuvre = maitrise_d_oeuvre;
            this.mode_de_devolution = mode_de_devolution;
            this.annee_d_individualisation = annee_d_individualisation;
            this.enveloppe_prev_en_meu = enveloppe_prev_en_meu;
    }

}