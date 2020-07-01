package com.nikgian.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="role")
public class Role implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private int rid;
    @NotNull
    @Column(name = "rname")
    private String rname;

    public Role() {
    }

    public Role(int rid, String rname) {
        this.rid = rid;
        this.rname = rname;
    }

    public int getRid() {
        return rid;
    }

    public void setId(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                '}';
    }
}
