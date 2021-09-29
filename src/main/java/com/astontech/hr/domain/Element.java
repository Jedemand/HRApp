package com.astontech.hr.domain;

import javax.persistence.*;

@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ElementId")
    private Integer id;

    @Version
    private Integer version;

    private String elementName;


    //Constructors
    public Element() {}

    public Element(String elementName) {
        this.elementName = elementName;
    }

    //region GetSet
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    //endregion
}
