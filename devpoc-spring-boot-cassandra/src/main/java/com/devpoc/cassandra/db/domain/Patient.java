package com.devpoc.cassandra.db.domain;



import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;


@Data
@Table
public class Patient {
	
	    @PrimaryKey 
        private int id;
	 
	    private String firstName;
	   
	    private String lastName;
	   
	    private String emailAddress;
	   
	    private String address;
	   
	    private String country;
	  
	    private String state;
	  
	    private String hospitalId;
	    
	    private String phoneNumber;
}


