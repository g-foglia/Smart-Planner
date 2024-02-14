package org.gennisilv.smartplanner.test;
import org.gennisilv.smartplanner.data.entity.Utente;
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
        u2.setNome("Silvana");
        u2.setCognome("Cognome");
        u2.setEmail("silvanacafaro13@gmail.com");
        u2.setPassword("12345678");
        u2.setUsername("Zzilv#");
        u2.setDataDiNascita(DateConverter.toGregorianCalendar("11/10/2002"));
        Assert.assertEquals(2,UtenteLogic.registrazione(u2.getEmail(),u2.getPassword(),u2.getNome(),u2.getCognome(),u2.getDataDiNascita(),u2.getUsername()));
    }

    @Test
    public void testRegistrazioneNomeCaratteriSpeciali(){
        Utente u4 = new Utente();
        u4.setNome("Silvana2002");
        u4.setCognome("Cafaro");
        u4.setEmail("silvanacafaro13@gmail.com");
        u4.setPassword("12345678");
        u4.setUsername("Zzilv");
        u4.setDataDiNascita(DateConverter.toGregorianCalendar("11/10/2002"));
        assertEquals(6,UtenteLogic.registrazione(u4.getEmail(), u4.getPassword(), u4.getNome(), u4.getCognome(), u4.getDataDiNascita(), u4.getUsername()));
    }


    @Test
    public void testRegistrazioneCognomeCaratteriSpeciali(){
        Utente u6 = new Utente();
        u6.setNome("Silvana");
        u6.setCognome("Cafaro2002");
        u6.setEmail("silvanacafaro13@gmail.com");
        u6.setPassword("12345678");
        u6.setUsername("Zzilv");
        u6.setDataDiNascita(DateConverter.toGregorianCalendar("11/10/2002"));
        assertEquals(5,UtenteLogic.registrazione(u6.getEmail(), u6.getPassword(), u6.getNome(), u6.getCognome(), u6.getDataDiNascita(), u6.getUsername()));
    }


    @Test
    public void testRegistrazionePasswordNonConforme(){
        Utente u8 = new Utente();
        u8.setNome("Silvana");
        u8.setCognome("Cafaro");
        u8.setEmail("silvanacafaro13@gmail.com");
        u8.setPassword("1234");
        u8.setUsername("Zzilv");
        u8.setDataDiNascita(DateConverter.toGregorianCalendar("11/10/2002"));
        assertEquals(1,UtenteLogic.registrazione(u8.getEmail(), u8.getPassword(), u8.getNome(), u8.getCognome(), u8.getDataDiNascita(), u8.getUsername()));
    }

    @Test
    public void testRegistrazioneEmailSbagliata(){
        Utente u10 = new Utente();
        u10.setNome("Silvana");
        u10.setCognome("Cafaro");
        u10.setEmail("Silvanacafaro13gmail.com");
        u10.setPassword("12345678");
        u10.setUsername("Zzilv");
        u10.setDataDiNascita(DateConverter.toGregorianCalendar("11/10/2002"));
        assertEquals(3,UtenteLogic.registrazione(u10.getEmail(), u10.getPassword(), u10.getNome(), u10.getCognome(), u10.getDataDiNascita(), u10.getUsername()));
    }
    @Test
    public void testDataDiNascitaMinorenne()
    {
        Utente u11 = new Utente();
        u11.setNome("Silvana");
        u11.setCognome("Cafaro");
        u11.setEmail("Silvanacafaro13@gmail.com");
        u11.setPassword("12345678");
        u11.setUsername("Zzilv");
        u11.setDataDiNascita(DateConverter.toGregorianCalendar("11/10/2011"));
        assertEquals(4,UtenteLogic.registrazione(u11.getEmail(), u11.getPassword(), u11.getNome(), u11.getCognome(), u11.getDataDiNascita(), u11.getUsername()));
    }
    @Test
    public void testRegistrazioneEffettuata()
    {
        Utente u12 = new Utente();
        u12.setNome("Silvana");
        u12.setCognome("Cafaro");
        u12.setEmail("silvanacafaro13@gmail.com");
        u12.setPassword("12345678");
        u12.setUsername("Zzilv");
        u12.setDataDiNascita(DateConverter.toGregorianCalendar("11/10/2002"));
        assertEquals(0,UtenteLogic.registrazione(u12.getEmail(), u12.getPassword(), u12.getNome(), u12.getCognome(), u12.getDataDiNascita(), u12.getUsername()));
    }
}
