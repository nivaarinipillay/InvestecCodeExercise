/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investecapp;

/**
 *
 * @author NiviPillay
 */
public class HCF {
    public static int highestCommonFactor(int[] numbers){
      int size = numbers.length;
      int result = numbers[0];
      int i = 1;
      while(i<size)
      {
         if(numbers[i]%result==0)
         {
            i++;
         } else {
            result = numbers[i]%result;
            i++;
         }
      }
      return result;
    }    
}
