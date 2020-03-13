package com.devpoc.cassandra.db.domain;



import java.util.List;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
@Table
public class Hospital {
	   
	    @PrimaryKey 
	    private final String id;
	    
	    @NonNull
	    private String name;
	   
	    @NonNull
	    private String hospitalNumber;
	    
	    private String bedInfo;
	    
	  //  private int patientId;

}
