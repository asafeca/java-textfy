package components.numbers;

import factory.BaseFactory;

public class Thousands implements BaseFactory{
    private Float value;
    private String template;
    private String stringValue;

    public Thousands(Float value, String template){
        this.value = value;
        this.template = template;

    }

    @Override
    public BaseFactory build(BaseFactory... child) {
        final Float _next =
        Float.parseFloat(String.valueOf(this.template.charAt(12))) +
        Float.parseFloat(String.valueOf(this.template.charAt(13))) +
        Float.parseFloat(String.valueOf(this.template.charAt(14))) +
        Float.parseFloat(String.valueOf(this.template.charAt(15))) +
        Float.parseFloat(String.valueOf(this.template.charAt(16))) +
        Float.parseFloat(String.valueOf(this.template.charAt(17))) ;
     
    this.stringValue = " MIL " + (_next > 0 ? " E " : "");
        return this;
    }

    @Override
    public String toString() {
        this.build();

        return this.stringValue;
        
    }
    
}

