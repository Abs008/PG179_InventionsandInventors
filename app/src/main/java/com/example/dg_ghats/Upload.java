package com.example.dg_ghats;

public class Upload {
    private String  Name;
    private String Imageurl;
    public Upload(){
        //empty
    }
    public Upload( String name , String imageurl){
        if(name.trim().equals("")){
            name ="No name";
        }

        Name = name;
        Imageurl = imageurl;

    }
    public  String getName() {
        return Name;
    }

    public void setName(String name){
        Name = name;
    }


    public  String getImageurl() {
        return Imageurl;
    }

    public void  setImageurl(String imageurl){

    }
}
