package edu.icet.crm.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student {
     private Long Id;
    private String studentName;
    private String studentAge;
    private String studentContact;
    private String guardianName;
    private String gurdianAdderss;
    private String gurdianContact;



}
