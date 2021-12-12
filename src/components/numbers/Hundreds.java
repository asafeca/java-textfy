package components.numbers;

import factory.BaseFactory;

public class Hundreds implements BaseFactory {
    private String template;
    private String stringValue="";
     public Hundreds(Float value, String template){
         this.template = template;
 
     }
 
     @Override
     public BaseFactory build(BaseFactory... child) {
 
       final Float next = Float.parseFloat(String.valueOf(this.template.charAt(16)))+ 
       Float.parseFloat(String.valueOf(this.template.charAt(17)));
     this.stringValue = next > 0 ? " E " : "";
 
         return this;
     }
 
     @Override
     public String toString() {
      this.build();
 
      return this.stringValue;
     }
     
 }
