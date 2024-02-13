package org.gennisilv.smartplanner.test;
import org.gennisilv.smartplanner.data.Utente;
import org.gennisilv.smartplanner.logic.UtenteLogic;
import org.gennisilv.smartplanner.utils.DateConverter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrazioneUtenteTest {
    @Test
    public void testRegistrazioneUsernameCaratteriSpeciali()
    {
        Utente u2= new Utente();
        u2.setNome("NomeTest2");
        u2.setCognome("CognomeTest2");
        u2.setEmail("nome2@test.com");
        u2.setPassword("Password");
        u2.setUsername("UserTest");
        u2.setDataDiNascita(DateConverter.toGregorianCalendar("29/09/1994"));
        Assert.assertEquals(1,UtenteLogic.registrazione(u2.getEmail(),u2.getPassword(),u2.getNome(),u2.getCognome(),u2.getDataDiNascita(),u2.getUsername()));
    }
    /*  public void testRegistrazioneUsernameCaratteriSpeciali1(){
       Utente u2 = new Utente();
       u2.setNome("NomeTest2");
       u2.setCognome("CognomeTest2");
       u2.setEmail("nome2@test.com");
       u2.setPassword("PasswordTest");
       u2.setUsername("UserTest%");
       u2.setDataDiNascita(DateConverter.toGregorianCalendar("29/09/1994"));

       Assert.assertEquals(1,registrazione.registrazione(u2.getEmail(), u2.getPassword(), u2.getNome(), u2.getCognome(), u2.getDataDiNascita(), u2.getUsername()));
    }*/

    @Test
    public void testRegistrazioneNomeCaratteriSpeciali(){
        Utente u4 = new Utente();
        u4.setNome("Nome4$");
        u4.setCognome("CognomeTest4");
        u4.setEmail("nome4@test.com");
        u4.setPassword("PasswordTest");
        u4.setUsername("UserTest4");
        u4.setDataDiNascita(DateConverter.toGregorianCalendar("29/09/1994"));
        assertEquals(1,UtenteLogic.registrazione(u4.getEmail(), u4.getPassword(), u4.getNome(), u4.getCognome(), u4.getDataDiNascita(), u4.getUsername()));
    }


    @Test
    public void testRegistrazioneCognomeCaratteriSpeciali(){
        Utente u6 = new Utente();
        u6.setNome("NomeTest6");
        u6.setCognome("CognomeTest6£");
        u6.setEmail("nome6@test.com");
        u6.setPassword("PasswordTest");
        u6.setUsername("UserTest6");
        u6.setDataDiNascita(DateConverter.toGregorianCalendar("29/09/1994"));
        assertEquals(1,UtenteLogic.registrazione(u6.getEmail(), u6.getPassword(), u6.getNome(), u6.getCognome(), u6.getDataDiNascita(), u6.getUsername()));
    }


    @Test
    public void testRegistrazionePasswordNonConforme(){
        Utente u8 = new Utente();
        u8.setNome("NomeTest8");
        u8.setCognome("CognomeTest8");
        u8.setEmail("nome8@test.com");
        u8.setPassword("pass");
        u8.setUsername("UserTest8");
        u8.setDataDiNascita(DateConverter.toGregorianCalendar("29/09/1994"));
        assertEquals(1,UtenteLogic.registrazione(u8.getEmail(), u8.getPassword(), u8.getNome(), u8.getCognome(), u8.getDataDiNascita(), u8.getUsername()));
    }

    @Test
    public void testRegistrazioneEmailSbagliata(){
        Utente u10 = new Utente();
        u10.setNome("NomeTest10");
        u10.setCognome("CognomeTest10");
        u10.setEmail("emailtest?@prova.it");
        u10.setPassword("PasswordTest");
        u10.setUsername("UserTest10");
        u10.setDataDiNascita(DateConverter.toGregorianCalendar("29/09/1994"));
        assertEquals(1,UtenteLogic.registrazione(u10.getEmail(), u10.getPassword(), u10.getNome(), u10.getCognome(), u10.getDataDiNascita(), u10.getUsername()));
    }
    @Test
    public void testDataDiNascitaMinorenne()
    {
        Utente u11 = new Utente();
        u11.setNome("NomeTest11");
        u11.setCognome("CognomeTest11");
        u11.setEmail("email11@prova.it");
        u11.setPassword("PasswordTest");
        u11.setUsername("UserTest11");
        u11.setDataDiNascita(DateConverter.toGregorianCalendar("16/10/2010"));
        assertEquals(1,UtenteLogic.registrazione(u11.getEmail(), u11.getPassword(), u11.getNome(), u11.getCognome(), u11.getDataDiNascita(), u11.getUsername()));
    }
    @Test
    public void testRegistrazioneEffettuata()
    {
        Utente u12 = new Utente();
        u12.setNome("NomeTesto");
        u12.setCognome("CognomeTesto");
        u12.setEmail("email12@prova.it");
        u12.setPassword("PasswordTest");
        u12.setUsername("UserTest12");
        u12.setDataDiNascita(DateConverter.toGregorianCalendar("29/09/1994"));
        assertEquals(1,UtenteLogic.registrazione(u12.getEmail(), u12.getPassword(), u12.getNome(), u12.getCognome(), u12.getDataDiNascita(), u12.getUsername()));
    }
}
