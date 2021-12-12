package components.numbers;

import factory.BaseFactory;

public class Cents implements BaseFactory{

    private  Float value;
    private String template;
    private String stringValue="";

    public Cents(Float value, String template){
        this.value = value;
        this.template = template;

    }

    @Override
    public BaseFactory build(BaseFactory... child) {
        if (this.value == 1) {
            this.stringValue = " CENTAVO";
          } else if (this.value > 1) {
            this.stringValue = " CENTAVOS";
          }
      
          return this;
    }

    @Override
    public String toString() {
        this.build();


        return this.stringValue;
    }
}
