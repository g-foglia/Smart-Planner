package org.gennisilv.smartplanner.logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.data.UtenteDAO;
import org.gennisilv.smartplanner.utils.UserHolder;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtenteLogic {

    public static int registrazione(String email, String password, String nome, String cognome, GregorianCalendar nascita, String username){
        /*
        CONTROLLI SUI CAMPI
         */
        if(!checkName(nome))
            if(!checkName(cognome))
                if(date(nascita))
                    if(checkEmail(email))
                        if(!formato(username))
                            if(lunghezza(password)){
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
                                //passowrd troppo corta o troppo lunga
                               return 1;
                            }
                        else{
                            //formato username illegale
                            return 2;
                        }
                    else{
                        //email in formato errato
                        return 3;
                    }
                else{
                    //utente troppo giovane
                    return 4;
                }
            else{
                //cognome che contiene numeri o caratteri speciali
                return 5;
            }
        else{
            //nome che contiene numeri o caratteri speciali
            return 6;
        }

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



    private static boolean checkName(String nome){
        return Pattern.compile("[^a-zA-Z]").matcher(nome).find();
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
