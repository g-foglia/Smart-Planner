package org.gennisilv.smartplanner.data;

import java.util.GregorianCalendar;

public class Utente {
    String email;
    String password;
    String nome;
    String cognome;
    String username;
    GregorianCalendar dataDiNascita;

    public Utente(String email, String password, String nome, String cognome, String username) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public GregorianCalendar getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(GregorianCalendar dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
