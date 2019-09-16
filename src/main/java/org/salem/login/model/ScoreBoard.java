package org.salem.login.model;

import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.salem.criteria.BoardType;
import org.springframework.data.jpa.repository.Query;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


/**
 * Product entity.
 */

@Data
@Entity
//@Cache(usage = version.NONSTRICT_READ_WRITE)
public class ScoreBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String scoreboardId;
    private String name;
    private String title;
    private String content;
    private int hit;


    private BoardType boardType;
    
    //@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
   // @JoinColumn(nullable = false,insertable=false,updatable=false, name = "name")
    //private User user;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public ScoreBoard() {
    	
        createdDate = new Date();
        
        }
    
    
}