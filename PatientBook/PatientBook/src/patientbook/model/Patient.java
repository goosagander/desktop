/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientbook.model;

// Patient.java

import java.time.LocalDate;

// Patient class that represents an entry in a medical book.
//Partha Gangavalli 2019
//Amended Address Book example from (C) Copyright 1992-2012 by Deitel & Associates, Inc.
public class Patient
{
   private int patientID;
   private String firstName;
   private String lastName;
   private int contacPhone;
   private LocalDate dateOfBirth;
   private String gender;

   // no-argument constructor
   public Patient()
   {
   } // end no-argument Person constructor

   // parameterised constructor
   public Patient( int id, String firstName, String lastName,
      int contactPhone, LocalDate dateOfBirth, String gender)
   {
      setPatientID( id );
      setFirstName( firstName );
      setLastName( lastName );
      setContactPhone( contactPhone );
      setGender( gender );
   } // end five-argument Person constructor



   // sets the patientID
   public void setPatientID( int id )
   {
      patientID = id;
   } // end method setPatientID

   // returns the patientID
   public int getPatientID()
   {
      return patientID;
   } // end method getPatientID

   // sets the Name
   public void setFirstName( String firstName )
   {      this.firstName = firstName;
   } // end method setName

   // returns the name
   public String getLastName()
   {
      return lastName;
   } // end method getName

   // sets the address
   public void setLastName( String lastName )
   {
      this.lastName = lastName;
   } // end method setAddress

   // returns the address
   public int getContactPhone()
   {
      return ContactPhone;
   } // end method getAddress

   // sets the age
   public void setContactPhone( int contactPhone )
   {
      this.contactPhone = contactPhone;
   } // end method setAge

   // returns the age
   public int getAge()
   {
      return age;
   } // end method getAge

   // sets next of kin
   public void setGender( String gender )
   {
      Gender = gender;
   } // end method setNextOfKin

   // returns the next of kin
   public String getGender()
   {
      return gender;
   } // end method getNextOfKin


} // end class Person


