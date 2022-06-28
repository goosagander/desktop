/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientbook.model;
// PatientModel.java
//Partha Gangavalli 2019
//Amended Address Book example from (C) Copyright 1992-2012 by Deitel & Associates, Inc.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class PatientModel implements IPatientModel
{
   //private static final String URL = "jdbc:derby://localhost:1527/Medical";
   // ("jdbc:mysql://localhost/world" , "root", "Pass21")

   private static final String URL = "jdbc:mysql://localhost/Medical";

   private static final String USERNAME = "root";
   private static final String PASSWORD = "043253098By*"; //your own password to Root account of MySQL

   private Connection connection = null; // manages connection
   private PreparedStatement selectAllPatients = null;
   private PreparedStatement selectPatientByName = null;
   private PreparedStatement selectPatientByID = null;
   private PreparedStatement insertNewPatient = null;

   // constructor
   public PatientModel()
   {
      try
      {
         connection =
            DriverManager.getConnection( URL,USERNAME,PASSWORD );

         // create query that selects all entries in the table
         selectAllPatients =
            connection.prepareStatement( "SELECT * FROM Patients" );

         // create query that selects entries with a specific name
         selectPatientByName = connection.prepareStatement(
            "SELECT * FROM Patients WHERE name = ?" );
         // create query that selects entirs with a specific id
         selectPatientByID = connection.prepareStatement(
            "SELECT * FROM Patients WHERE PatientID = ?" );
         // create insert that adds a new entry into the database
         insertNewPatient = connection.prepareStatement(
            "INSERT INTO Patients " +
            "( Name, Address, Age, Nok ) " +
            "VALUES ( ?, ?, ?, ? )" );
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         System.exit( 1 );
      } // end catch
   } // end PatientModel constructor

   // select all of the patients in the database
   public List< Patient > getAllPatients()
   {
      List< Patient> results = null;
      ResultSet resultSet = null;

      try
      {
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectAllPatients.executeQuery();
         results = new ArrayList< Patient>();

         while ( resultSet.next() )
         {
            results.add( new Patient(
               resultSet.getInt( "PatientID" ),
               resultSet.getString( "firstName" ),
               resultSet.getString( "lastName" ),
               resultSet.getInt( "contactPhone" ),
               resultSet.getLocalDate( "dateOfBirth" )
                ) );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
      finally
      {
         try
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();
            close();
         } // end catch
      } // end finally

      return results;
   } // end method getAllPatients

   // select patient by name
   public List< Patient > getPatientsByName( String name )
   {
      List< Patient > results = null;
      ResultSet resultSet = null;

      try
      {
         selectPatientByName.setString( 1, name ); // specify last name

         // executeQuery returns ResultSet containing matching entries
         resultSet = selectPatientByName.executeQuery();

         results = new ArrayList< Patient >();

         while ( resultSet.next() )
         {
            results.add( new Patient(
               resultSet.getInt( "PatientID" ),
               resultSet.getString( "Name" ),
               resultSet.getString( "Address" ),
               resultSet.getInt( "Age" ),
               resultSet.getString( "Nok" )
                ) );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
      finally
      {
         try
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();
            close();
         } // end catch
      } // end finally

      return results;
   } // end method getByName

   // select patient by name
   public List< Patient > getPatientsByID( int id )
   {
      List< Patient > results = null;
      ResultSet resultSet = null;

      try
      {
         selectPatientByID.setInt( 1, id ); // specify id

         // executeQuery returns ResultSet containing matching entries
         resultSet = selectPatientByID.executeQuery();

         results = new ArrayList< Patient >();

         while ( resultSet.next() )
         {
            results.add( new Patient(
               resultSet.getInt( "PatientID" ),
               resultSet.getString( "firstName" ),
               resultSet.getString( "lastName" ),
               resultSet.getInt( "contactPhone" ),
               resultSet.getString( "Nok" )
                ) );
         } // end while
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
      finally
      {
         try
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();
            close();
         } // end catch
      } // end finally

      return results;
   } // end method getByName
   // add an entry
   public int addPatient(
      String name, String address, int age, String nok )
   {
      int result = 0;

      // set parameters, then execute insertNewPatient
      try
      {
         insertNewPatient.setString( 1, name );
         insertNewPatient.setString( 2, address );
         insertNewPatient.setInt( 3, age );
         insertNewPatient.setString( 4, nok );

         // insert the new entry; returns # of rows updated
         result = insertNewPatient.executeUpdate();
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         close();
      } // end catch

      return result;
   } // end method addPatient

   // close the database connection
   public void close()
   {
      try
      {
         connection.close();
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
   } // end method close

    @Override
    public int addPatient(String firstName, String lastName, int contactPhone, LocalDate dateOfBirth, String gender) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
} // end class PersonModel

