package com.example.welcome.lang;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//klasa model(reperentuje dane z DB) to jest POJO klasa tworząca pracująca z obiektami
//kontakt z danymi przez DAO lub Repository
@Entity
@Table( name = "languages" )
public class Lang {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    @Column(name="welcomemsg") // nazwa jaka została zapisana w sql
    private String welcomeMsg;
    private String code;
    //stworzony dla hibernata pusty konstruktor można zrobić @Constructor
    @SuppressWarnings("unused")

    public Lang(Integer id, String welcomeMsg, String code) {
        this.id = id;
        this.welcomeMsg = welcomeMsg;
        this.code = code;
    }

    public Lang() {

    }

    public Integer getId() {
        return id;
    }
    //set id wyrzucam żeby nie mozna go było zmieniać
    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
