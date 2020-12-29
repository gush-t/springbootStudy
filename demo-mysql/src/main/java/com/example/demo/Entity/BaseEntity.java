package com.example.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String strName;


    public BaseEntity() {
    }

    public BaseEntity(Integer id, String strName) {
        this.id = id;
        this.strName = strName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(strName, that.strName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, strName);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

}
