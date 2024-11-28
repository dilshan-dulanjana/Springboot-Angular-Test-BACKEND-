package edu.icet.crm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="student")
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String studentName;
    private String studentAge;
    private String studentContact;
    private String guardianName;
    private String gurdianAdderss;
    private String gurdianContact;


}
