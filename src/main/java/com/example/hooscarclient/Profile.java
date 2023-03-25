package com.example.hooscarclient;
import java.util.*;

public class Profile {
    private String phoneNumber;
    private String username;
    private String displayname;
    private String password;
    private List<String> carPools;
    private List<String> hostedPools;
    public Profile(String phone, String user, String pass){
        phoneNumber = phone;
        username = user;
        password = pass;
        carPools = new ArrayList<String>();
        hostedPools = new ArrayList<String>();
    }
    public Profile(){
        this("","","");
    }
    private void setDisplayname(String display){
        displayname = display;
    }
    private String getDisplayname(String display){
        return displayname;
    }
    private void setPhoneNumber(String phone){
        phoneNumber = phone;
    }
    public void addPool(String id){
        carPools.add(id);
    }
    public List<String> getPools(){
        return carPools;
    }
    public boolean removePools(String id){
        return carPools.remove(id);
    }
    public void addHosted(String id){
        hostedPools.add(id);
    }
    public boolean removeHosted(String id){
        return hostedPools.remove(id);
    }
    public List<String> getHostedPools(){
        return hostedPools;
    }
    private String getPhoneNumber(){
        return phoneNumber;
    }
    private void setUsername(String user){
        username = user;
    }
    private String getUsername(){
        return username;
    }
    private void setPassword(String pass){
        password = pass;
    }
    private String getPassword(){
        return password;
    }

}
