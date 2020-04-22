/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author skliz
 */
public class Interview2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int noOfWashes=2;
        int[] cleanpile  ={1, 2,1,1};
        int[] dirtypile  = { 1, 4, 3, 2, 4};
        
                
        boolean validate = validateInputs(noOfWashes, cleanpile, dirtypile);
        
        if(validate){
            
           int ans =  returnAnswer(noOfWashes, cleanpile, dirtypile);
           
           System.out.println(ans);
        }
    }
    
    public static int returnAnswer(int noOfWashes, int[] cleanpile, int[] dirtypile){
        
        if(noOfWashes == 0){
            
            return 1;//This is the default since the washing machine is not working
        }
        else{
            
            //Want numbers without duplicated so I put it in a suorted list
            Set<Integer> sortednums = new TreeSet<>();
            
            for(int num : cleanpile){
                sortednums.add(num);
            }
           
            //NOw we are going to put the occurrence in a sorted tree
            List<Integer> numOccurrence = new ArrayList<>();
            
            for(int num : sortednums ){
                
                //Find the number of times it occurs
               int occur =  countOccurrence( num, cleanpile);
               numOccurrence.add(occur);
               
            }
            
          //  System.out.println(numOccurrence);
            
            //We would sort
            Collections.sort(numOccurrence);
            
            //Since we sorted the numbers we are going to get the last occurrence.
                        
            int lastOccur = numOccurrence.get(numOccurrence.size()-1);
            
            if(lastOccur > 4){
                return 4;   //Based on instruction if it washes multiple times. you just return 4 as max.
            }
            else
                return lastOccur;
        }
    }
    
    //This is going to count occurrence.
   private static int countOccurrence(int num,int[] cleanpile){
       int counter = 0;
       
       for(int i : cleanpile){
           
           if(num == i){
               counter++;
           }
       }
       
       return counter;
   }
    
    public static boolean validateInputs(int noOfWashes, int[] cleanpile, int[] dirtypile){
        
        boolean validate = false;
        String errorMessage = "";
        
        //Cerfity condition 1
        if(noOfWashes >= 0 && noOfWashes <=50){
            
            validate = true;
        }
        else{
            validate = false;
            errorMessage += "Invalid no of washes";
        }
        
        //Certify condition 2
        int testNum = -1;
        
        //We have to loop tru to ensure that conditions are meet
        Arrays.sort(cleanpile);  Arrays.sort(dirtypile);
        
        if((cleanpile[0] < 0) || cleanpile[cleanpile.length-1] > 50){
            validate = false;
            errorMessage += "Clean pile has invalid values less than 0 or greater than 50";
        }
        
         if((dirtypile[0] < 0) || dirtypile[dirtypile.length-1] > 50){
            validate = false;
            errorMessage += "Dirty pile has invalid values less than 0 or greater than 50";
        }
         
         System.out.println(errorMessage);
         
         return validate;         
    }
    
}
