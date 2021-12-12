package components.numbers;

import factory.BaseFactory;

public class Million  implements BaseFactory{
    private Float value;
    private String template;
    private String stringValue;

    public  Million(Float value, String template){
        this.value = value;
        this.template = template;
    }

    @Override
    public BaseFactory build(BaseFactory... child) {
        final Float next =
      Float.parseFloat(String.valueOf(this.template.charAt(9))) +
      Float.parseFloat(String.valueOf(this.template.charAt(10)) +
      Float.parseFloat(String.valueOf(this.template.charAt(11))))+
      Float.parseFloat(String.valueOf(this.template.charAt(13)))+ 
      Float.parseFloat(String.valueOf(this.template.charAt(14)));

  
    if (this.value == 1) {
      this.stringValue = " MILHÃO " + (next > 0 ? " E " : "");
    } else if (this.value > 1) {
      this.stringValue = " MILHÕES" + (next > 0 ? " E " : "");
    }
        return this;
    }

    @Override
    public String toString() {
        this.build();
        return this.stringValue;
    }
    
}
