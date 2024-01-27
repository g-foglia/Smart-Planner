package org.gennisilv.smartplanner.logic;

import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.data.UtenteDAO;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.util.GregorianCalendar;

public class UtenteLogic {
    public static void registrazione(String email, String password, String nome, String cognome, GregorianCalendar nascita, String username){
        Utente utente= new Utente();
        utente.setEmail(email);
        utente.setPassword(password);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setDataDiNascita(nascita);
        utente.setUsername(username);

        UtenteDAO.doAddUtente(utente);

        UserHolder.getIstanza().setUtente(utente);
    }

    public static int login(String email, String passowrd){
        Utente utente = UtenteDAO.login(email,passowrd);

        if(utente == null){
            return -1;
        }else{
            UserHolder.getIstanza().setUtente(utente);
            return 0;
        }
    }

    public static void cancellaUtente(){
        UtenteDAO.doCancUtente(UserHolder.getIstanza().getUtente().getEmail());

        UserHolder.getIstanza().setUtente(null);
    }

    public Utente returnUtenteByEmail(String email){
        return UtenteDAO.doRetrieveByEmail(email);
    }

    public static void logout(){
        UserHolder.getIstanza().setUtente(null);
    }

    public static Utente returnLoggedInUser(){
        return UserHolder.getIstanza().getUtente();
    }
}
