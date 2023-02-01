package com.api.bootrestbook.entities;

public class Author {

    private int authorID;
    private String firstName;
    private String LastName;
    private String language;

    public Author() {
    }

    public Author(int authorID, String firstName, String lastName, String language) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.LastName = lastName;
        this.language = language;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
