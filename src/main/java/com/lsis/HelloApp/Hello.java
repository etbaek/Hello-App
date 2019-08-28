package com.lsis.HelloApp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="HELLO")
public class Hello implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String language;
    private String helloMessage;

    public Hello() {
    }

    public Hello(String country, String language, String helloMessage) {
        this.country = country;
        this.language = language;
        this.helloMessage = helloMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hello hello = (Hello) o;
        return id.equals(hello.id) &&
                Objects.equals(country, hello.country) &&
                Objects.equals(language, hello.language) &&
                Objects.equals(helloMessage, hello.helloMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, language, helloMessage);
    }

    @Override
    public String toString() {
        return "Hello{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", helloMessage='" + helloMessage + '\'' +
                '}';
    }
}
