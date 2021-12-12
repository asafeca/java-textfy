package service;

import java.util.ArrayList;
import java.util.List;

import factory.BaseFactory;

public class StringLineResult implements BaseFactory{
    private static StringLineResult INSTANCE=null;
    private List<BaseFactory> children =new  ArrayList<>();
    private  String convertedString = "";

    public static BaseFactory getInstance(){
        if(null == INSTANCE){

            INSTANCE = new StringLineResult();

        }
        return INSTANCE;
    }

   public  void add(BaseFactory child){
        this.children.add(child);
    }
 

    @Override
    public BaseFactory build(BaseFactory... child) {
        children.forEach((e)->{this.convertedString +=e.toString();});

        return this;
    }

    @Override
    public String toString() {
       this.build();
        return this.convertedString;
    }
    
}

