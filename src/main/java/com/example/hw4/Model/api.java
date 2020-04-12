package com.example.hw4.Model;
import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "api2")
public class api {
@Id
    @Column(name = "old")
    private String old;
    public api(){

    }
    public api(String old){

        this.old=old;
    }




    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }
}
