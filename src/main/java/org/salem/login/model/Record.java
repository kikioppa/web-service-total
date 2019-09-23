package org.salem.login.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.jpa.repository.Query;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Product entity.
 */
@Entity
@Data
//@Cache(usage = version.NONSTRICT_READ_WRITE)
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer rank;
    private BigDecimal avg;
    private String name;
    private Integer variance;
    //@ManyToOne(cascade = CascadeType.ALL)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Record() {
    	
        createdDate = new Date();
        
    }
}