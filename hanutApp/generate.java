import java.util.Random;
import java.io.*;
 class Main {

    public static void main (String [] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        
        System.out.println("Enter Name");
        String name=br.readLine();
        String n[]=new String[2];
        n=name.split(" ");
        String email=n[0];
        long num=phone();
        

         String [] arr = {"@gmail.com", "@yahoo.com", "@hotmail.co.uk", "@rediff.com", "@outlook.com", "@comcast.net","@msn.com"};
         Random random = new Random();

         // randomly selects an index from the arr
         int select = random.nextInt(arr.length); 

         // prints out the value at the randomly selected index
            email=email+arr[select]; 
            System.out.println(num);
            System.out.print(email);
    }
    
    public static long phone()
    {
        int num1, num2, num3; //3 numbers in area code
        int set2, set3; //sequence 2 and 3 of the phone number
        String num;
        long n;
        
        
        Random generator = new Random();
        
        //Area code number; Will not print 8 or 9
        num1 = generator.nextInt(7) + 1; //add 1 so there is no 0 to begin  
        num2 = generator.nextInt(8); //randomize to 8 becuase 0 counts as a number in the generator
        num3 = generator.nextInt(8);
        
        // Sequence two of phone number
        // the plus 100 is so there will always be a 3 digit number
        // randomize to 643 because 0 starts the first placement so if i randomized up to 642 it would only go up yo 641 plus 100
        // and i used 643 so when it adds 100 it will not succeed 742 
        set2 = generator.nextInt(643) + 100;
        
        //Sequence 3 of numebr
        // add 1000 so there will always be 4 numbers
        //8999 so it wont succed 9999 when the 1000 is added
        set3 = generator.nextInt(8999) + 1000;
        
        num="9"+Integer.toString(num1)+Integer.toString(num2)+Integer.toString(num3)+Integer.toString(set2)+Integer.toString(set3);
        n=Long.parseLong(num);
        n=n/10;
        return n;
        
        
    }
}
