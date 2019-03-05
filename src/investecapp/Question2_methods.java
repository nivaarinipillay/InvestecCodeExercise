/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investecapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import Classes.Address;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 *
 * @author NiviPillay
 */
public class Question2_methods { 
   
    /**
     * prettyPrintAddress method will print all parameters of the Address object given in a specified format
     * @param address is an instance of Address  
     * @return prettyAddress: a readable String format of the address given
     */
    public static String prettyPrintAddress(Address address) {
        
        String prettyAddress = address.getType().getName() +": "+ 
                address.getAddressLineDetail().getLine1() +", "+ 
                address.getAddressLineDetail().getLine2() +" - "+
                address.getCityOrTown() +" - "+
                address.getProvinceOrState().getName() +" - "+
                address.getPostalCode() +" - "+
                address.getCountry().getName();
        
        return prettyAddress;  
    
    }


    /**
     * getAddressByAddressType method finds all addresses with the specified type
     * @param type is a string specifying the address type of the address to be found
     * @return resultList: an arrayList of all addresses with type matching the specified type
     */
     static ArrayList<Address> getAddressByAddressType(String type){
       
        List<Address> allAddresses = getAllAddresses();
        
        ArrayList<Address> resultList = new ArrayList<>();
        
        allAddresses.stream().filter((address) -> (address.getType().getName().equals(type))).forEachOrdered((address) -> {
            resultList.add(address);
        });
  
        return resultList;
   
    }
     
     
    /**
     * getAllAddresses method gets all addresses from json file
     * @return addressList: a list of addresses still in json format
     */
    static List<Address> getAllAddresses(){
    
        List<Address> addressList = null;
        
        try{ 
            byte[] url = Files.readAllBytes(Paths.get("../InvestecApp/src/resources/addresses.json"));
            ObjectMapper mapper = new ObjectMapper();
            addressList = Arrays.asList(mapper.readValue(url,Address[].class));   
        }catch(FileNotFoundException e){
            System.out.print(e);
        }catch(IOException e){
            System.out.print(e);
        }catch(Exception e){
            System.out.print(e);
        }        
        return addressList;       
    } 
    
    /**
     * prettyPrintAllAddresses method prints all addresses in a file, in a readable format
     * @return addressList: a List containing all addresses  
    */     
    static String prettyPrintAllAddresses(){
    
        String addressList = null;
        try{ 
            ObjectMapper mapper = new ObjectMapper();
            addressList = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getAllAddresses());
        }catch(JsonProcessingException e){
            System.out.print(e);
        } 
        catch(Exception e){
            System.out.print(e);
        } 
        return addressList;       
    } 
     
     
     /**
      * validate method will test if an address is of the correct, specified format
      * @param address is an instance of Address that we are validating
      * @returns validatedAddress: a boolean value. "true" when the address is of the correct format. "false" when the address does not fit the format
      */
     static boolean validate(Address address){
           String postalCode = (address.getPostalCode() !=null)?address.getPostalCode():null;
           String country = (address.getCountry().getCode()!=null)?address.getCountry().getCode():null;
           String addressLine1 = (address.getAddressLineDetail()!= null)? address.getAddressLineDetail().getLine1():null;
           String addressLine2 = (address.getAddressLineDetail()!= null)?  address.getAddressLineDetail().getLine2():null;
           String province = (address.getProvinceOrState()!= null) ? address.getProvinceOrState().getName():null;
         boolean validatedAddress = true;
         
         if( ((addressLine1 == "" | addressLine1 == null) && (addressLine2 == "" | addressLine2 == null))){
             validatedAddress = false;
         }
         if(!StringUtils.isNumeric(postalCode)){
             validatedAddress = false;
         }
         if(country == null){
             validatedAddress = false;
         }
         if(country == "ZA"){
             if(province == null){
                 validatedAddress = false;
             }
         }
         return validatedAddress;
         
      } 
     
     

     /**
      * inValidError method is the answer to question e, my initial approach was to add onto validate method but decided to separate as there were 2 separate questions.
      * invalidError method will iterate through all addresses and specify if the address is valid or not, then specifying why it is invalid.
      * @returns errorList: an arrayList with all errors making the address invalid 
      */
     static ArrayList<String> invalidError(){
        List<Address> allAddresses = getAllAddresses();
        ArrayList<String> errorList = new ArrayList<String>();       
        
        for(Address address : allAddresses){
           String postalCode = (address.getPostalCode() !=null)?address.getPostalCode():null;
           String country = (address.getCountry().getCode()!=null)?address.getCountry().getCode():null;
           String addressLine1 = (address.getAddressLineDetail()!= null)? address.getAddressLineDetail().getLine1():null;
           String addressLine2 = (address.getAddressLineDetail()!= null)?  address.getAddressLineDetail().getLine2():null;
           String province = (address.getProvinceOrState()!= null) ? address.getProvinceOrState().getName():null;
        
    
           
         if( ((addressLine1 == "" | addressLine1 == null) && (addressLine2 == "" | addressLine2 == null))){
             
             errorList.add("AddressLine Details are both empty");
         }
         if(!StringUtils.isNumeric(postalCode)){
             errorList.add("PostalCode is not numeric");
            
         }
         if(country == null){
             errorList.add("No Country added");
         }
         if(country.equals( "ZA")){
             if(province == null){
                 errorList.add("Province for ZA not mentioned");
             }
         }
         if(errorList.size()> 0 ){
             printErrorList(errorList, address);
             errorList.clear();
         }else{
         System.out.println("Address with id " + address.getId()+" is valid");
         }
     
        }
        return errorList;
     }
     
     /**
      * printErrorList method is called to print all errors of the individual method when invalid
      * @param errorList is the list passed with all the individual addresses errors
      * @param address is the address object in reference to specify with the ID when invalid
      */
     static void printErrorList(ArrayList<String> errorList, Address address){     
         for(String s : errorList){
             System.out.print("Address with id "+ address.getId()+" is invalid - ");
             System.out.println(s);
         }        
     }
    
}
         
      
