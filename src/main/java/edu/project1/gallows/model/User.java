package edu.project1.gallows.model;

import java.util.Objects;

public class User {

     private String login;
     private String password;
     private int wins;
     private int loses;

     public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.wins = 0;
        this.loses = 0;
    }

    public User(String login, String password, int wins, int loses) {
        this.login = login;
        this.password = password;
        this.wins = wins;
        this.loses = loses;
    }

    public void increaseWins() {
         this.wins++;
    }

    public void increaseLoses() {
        this.loses++;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "User{" +
            "login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", wins=" + wins +
            ", loses=" + loses +
            '}';
    }

}
