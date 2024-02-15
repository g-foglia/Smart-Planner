package org.gennisilv.smartplanner.logic;

import org.gennisilv.smartplanner.data.entity.Utente;
import org.gennisilv.smartplanner.data.dao.UtenteDAO;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtenteLogic {

    public static int registrazione(String email, String password, String nome, String cognome, GregorianCalendar nascita, String username){
        /*
        CONTROLLI SUI CAMPI
         */
        if(!nome.isEmpty() && !checkName(nome))
            if(!cognome.isEmpty() && !checkName(cognome))
                if(nascita != null && date(nascita))
                    if(!email.isEmpty() && checkEmail(email))
                        if(!username.isEmpty() && !formato(username))
                            if(!password.isEmpty() && lunghezza(password)){
                                Utente utente= new Utente();
                                utente.setEmail(email);
                                utente.setPassword(password);
                                utente.setNome(nome);
                                utente.setCognome(cognome);
                                utente.setDataDiNascita(nascita);
                                utente.setUsername(username);

                                UtenteDAO.doAddUtente(utente);

                                UserHolder.getIstanza().setUtente(utente);
                                return 0;
                            }
                            else{
                                //passowrd troppo corta, troppo lunga o vuota
                               return 1;
                            }
                        else{
                            //formato username illegale o vuoto
                            return 2;
                        }
                    else{
                        //email in formato errato o vuota
                        return 3;
                    }
                else{
                    //utente troppo giovane o nessuna data
                    return 4;
                }
            else{
                //cognome che contiene numeri, caratteri speciali o è vuoto
                return 5;
            }
        else{
            //nome che contiene numeri, caratteri speciali o è vuoto
            return 6;
        }

    }

    public static int login(String email, String passowrd){
        Utente utente;
        if(checkEmail(email)) {
            utente = UtenteDAO.login(email, passowrd);
            if (utente == null) {
                return 1;
            } else {
                UserHolder.getIstanza().setUtente(utente);
                return 0;
            }
        }
        else{
                return 2;
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



    private static boolean checkName(String nome){
        return Pattern.compile("[^a-zA-Z\\s]").matcher(nome).find();
    }

    private static boolean date(GregorianCalendar nascita){
        GregorianCalendar dataAttuale = new GregorianCalendar();
        dataAttuale.add(Calendar.YEAR, -16);

        return nascita.before(dataAttuale);
    }

    private static boolean checkEmail(String email){
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean formato(String username){
        return Pattern.compile("[^a-zA-Z0-9]").matcher(username).find();
    }

    private static boolean lunghezza(String password){
        if(password.length()<8 || password.length()>30)
            return false;
        return true;
    }
}
