/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investecapp;

import Classes.Address;
import Classes.AddressLineDetail;
import Classes.Country;
import Classes.ProvinceOrState;
import Classes.Type;
import investecapp.HCF;
import investecapp.Question2_methods;

/**
 *
 * @author NiviPillay
 */
public class InvestecApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        int[] numbers = {10,15,30};
        System.out.println(HCF.highestCommonFactor(numbers));

        //creating address object for testing purposes
        Address myAddress = new Address();
        AddressLineDetail address = new  AddressLineDetail();
        address.setLine1("Line1");
        address.setLine2("Line2");
        ProvinceOrState province = new ProvinceOrState();
        province.setCode("GAU");
        province.setName("Gauteng");
        Country country = new Country();
        country.setCode("ZA");
        country.setName("South Africa");
        Type type = new Type();
        type.setCode("1");
        type.setName("Postal Address");
        myAddress.setId(1);
        myAddress.setCityOrTown("Johannesburg");
        myAddress.setPostalCode("0157");
        myAddress.setLastUpdated("2019-10-06");
        myAddress.setType(type);
        myAddress.setAddressLineDetail(address);
        myAddress.setCountry(country);
        myAddress.setProvinceOrState(province);
        myAddress.setSuburbOrDistrict("Edenvale");
        
        //testing prettyPrintAddress
        System.out.println(Question2_methods.prettyPrintAddress(myAddress));
        //testing validate
        System.out.println(Question2_methods.validate(myAddress));
        //testing getAddressByAddressType
        System.out.println(Question2_methods.getAddressByAddressType("Physical Address"));
        //testing prettyPrintAllAddresses
        System.out.println(Question2_methods.prettyPrintAllAddresses());
        //testing invalidError
        Question2_methods.invalidError();

    }
}
