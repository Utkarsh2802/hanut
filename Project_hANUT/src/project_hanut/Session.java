/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_hanut;

/**
 *
 * @author raghav
 */
public class Session {
    public static char userType;
    public static int currUser;
    public static void logined(String id){
       char c[]= id.toCharArray();
       currUser=Integer.parseInt(id);
       String s=Character.toString(c[0]);
       s+=Character.toString(c[1]);
       int i=Integer.parseInt(s);
       userType=(char)i;
       
    }
    public static char user_type(){
        return userType;
    }
    public static int curr_user(){
        return currUser;
    }
    public static void logout(){
        currUser=0;
        userType=' ';
    }
}