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
public class AddressLineDetail {
    
    private String line1;
    private String line2;

    @Override
    public String toString() {
        return "AddressLineDetail{" + "line1=" + line1 + ", line2=" + line2 + '}';
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }
    
    
    
}
