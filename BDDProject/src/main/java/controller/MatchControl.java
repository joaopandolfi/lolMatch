package controller;

import extras.TimeAPL;
import model.Match;
import model.MercenaryMatch;
import model.Wallet;
import persistence.MatchDAO;
import persistence.MercenaryMatchDAO;

/**
 * Created by joao on 6/10/16.
 */
public class MatchControl {
    MatchDAO matchDAO;
    MercenaryMatchDAO mercenaryMatchDAO;

    public MatchControl(){
        matchDAO = new MatchDAO();
        mercenaryMatchDAO = new MercenaryMatchDAO();
    }


    /*
    * Cria match
    * @params idConviter {int}
    * @params idConvidated {int}
    * @returns boolean {boolean}
    * */
    public boolean makeMath(int idConviter, int idConvidated){
        Match match = new Match();
        match.setDate(TimeAPL.getCurrentDateToBD());
        match.setIdSender(idConviter);
        match.setIdReceiver(idConvidated);
        return matchDAO.save(match);
    }


    /*
    * Cria Match mercenario OBS: EFETUA PAGAMENTO
    * @params idConviter {int}
    * @params idConvidated {int}
    * @params carteira {Wallet}
    * @params value {int}
    * @returns boolean {boolean}
    * */
    public boolean makeMercenryMatch(int idConviter, int idConvidated,Wallet wallet, int value){
        if(wallet.getSaldo() < value)
            return false;
        MercenaryMatch mercenaryMatch = new MercenaryMatch();
        mercenaryMatch.setIdReceiver(idConvidated);
        mercenaryMatch.setIdSender(idConviter);
        mercenaryMatch.setPrice(value);
        mercenaryMatch.setDate(TimeAPL.getCurrentDateToBD());
        if(mercenaryMatchDAO.save(mercenaryMatch)){
            WalletControl walletControl = new WalletControl(wallet);
            return walletControl.transferValue(idConvidated, value);
        }
        return false;
    }
}
