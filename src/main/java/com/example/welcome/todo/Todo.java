package com.example.welcome.todo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//klasa model(reperentuje dane z DB) to jest POJO klasa tworząca pracująca z obiektami
//kontakt z danymi przez DAO lub Repository
@Entity
@Table( name = "todos" )
class Todo {

    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private Integer id;
    private String text;
    private boolean done;
    //stworzony dla hibernata pusty konstruktor można zrobić @Constructor
    @SuppressWarnings("unused")

    private Todo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
