import { Injectable } from '@angular/core';
import { Investment } from '../models/Investment';

@Injectable({
  providedIn: 'root'
})
export class InitializeObjectsService {

  constructor() { }


    /**
     * getEmptyInvestment
     *Rreturns an Investment Object with initialized fields
     */
    public getEmptyInvestment(): Investment {
      let newInvestment: Investment = {
        id: "",
        titreoperation: "",
        entreprise: "",
        annee_de_livraison: "",
        ville: "",
        mandataire: "",
        ppi: "",
        nombre_de_lots: 0,
        lycee: "",
        notification_du_marche: "",
        codeuai: "",
        longitude: 0,
        etat_d_avancement: "",
        montant_des_ap_votes_en_meu: 0,
        cao_attribution: "",
        latitude: 0,
        maitrise_d_oeuvre: "",
        mode_de_devolution: "",
        annee_d_individualisation: "",
        enveloppe_prev_en_meu: 0
      } 
  return newInvestment;
}
}
