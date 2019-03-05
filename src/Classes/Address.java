/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author NiviPillay
 */
public class Address {

    private int id;
    private String cityOrTown;
    private String postalCode;
    private String lastUpdated;
    private Type type;
    private Country country;
    private AddressLineDetail addressLineDetail;
    private ProvinceOrState provinceOrState;
    private String suburbOrDistrict;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public AddressLineDetail getAddressLineDetail() {
        return addressLineDetail;
    }

    public void setAddressLineDetail(AddressLineDetail addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
    }

    public ProvinceOrState getProvinceOrState() {
        return provinceOrState;
    }

    public void setProvinceOrState(ProvinceOrState provinceOrState) {
        this.provinceOrState = provinceOrState;
    }

    public String getSuburbOrDistrict() {
        return suburbOrDistrict;
    }

    public void setSuburbOrDistrict(String suburbOrDistrict) {
        this.suburbOrDistrict = suburbOrDistrict;
    }
   
    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", cityOrTown=" + cityOrTown + ", postalCode=" + postalCode + ", lastUpdated=" + lastUpdated + ", type=" + type + ", country=" + country + ", addressLineDetail=" + addressLineDetail + ", provinceOrState=" + provinceOrState + ", suburbOrDistrict=" + suburbOrDistrict + '}';
    }
   
}




