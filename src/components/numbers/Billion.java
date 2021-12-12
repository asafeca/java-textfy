package components.numbers;

import factory.BaseFactory;

public class Billion  implements BaseFactory{
    private  Float value;
    private String template;
    private String stringValue="";

    public Billion(Float value, String template){
        this.value = value;
        this.template = template;

    }

    @Override
    public BaseFactory build(BaseFactory... child) {
        final Float next =
      Float.parseFloat(String.valueOf(this.template.charAt(6))) +
      Float.parseFloat(String.valueOf(this.template.charAt(7))) +
      Float.parseFloat(String.valueOf(this.template.charAt(8))) +
      Float.parseFloat(String.valueOf(this.template.charAt(9))) +
      Float.parseFloat(String.valueOf(this.template.charAt(10))) +
      Float.parseFloat(String.valueOf(this.template.charAt(11))) +
      Float.parseFloat(String.valueOf(this.template.charAt(12))) +
      Float.parseFloat(String.valueOf(this.template.charAt(13))) +
      Float.parseFloat(String.valueOf(this.template.charAt(14)));
      
    if (this.value == 1) {
      this.stringValue = " BILHÃO" + (next > 0 ? " E " : "");
    } else if (this.value > 1) {
      this.stringValue = " BILHÕES" + (next > 0 ? " E " : "");
    }
    return this;
    }

    @Override
    public String toString() {
        this.build();


        return this.stringValue;
    }
    
}
