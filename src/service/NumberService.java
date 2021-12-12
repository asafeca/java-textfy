package service;

import java.text.DecimalFormat;

import components.numbers.Billion;
import components.numbers.Cents;
import components.numbers.Hundreds;
import components.numbers.Million;
import components.numbers.Thousands;
import components.numbers.Trillion;

 public class NumberService {
    private static NumberService INSTANCE=null;
    private NumberService(){}

   /// DECLARE OUR TEMPLATE TO KNOW AND CONTROL THE
  /// THE Float LENGTH
  private String template="";

  /// StringLineResult IS THE COMPONENT ACTING LIKE A CONTAINER
  /// WE CAN ADD COMPONENTS INSIDE IT
  final StringLineResult stringLineResult = (StringLineResult) StringLineResult.getInstance();

  public static NumberService getInstance(){
    if(null == INSTANCE){

      INSTANCE = new NumberService();

    }
      return INSTANCE;
  }

 public String NumberWatching(Float value) {
    /// FILLING THE TEMPLATE, THE MAXIMUM IS 18. 15 FOR
    /// INTEGERS AND 3 FOR DECIMAL
    DecimalFormat df = new DecimalFormat("0.00");
    String _val = df.format(value);
    for (Integer x = 0; x < 18 - _val.length(); x++) {
      this.template += "0";
    }

    _val = _val.replace(".", "0");
    _val = _val.replace(",", "0");
    this.template += _val;

    /// ALL THE FloatS ARE REPRESENTED AS A CLASS COMPONENT
    /// THEY BELONG TO BASEFACTORY CLASS

    for (Integer k = 0; k <= 15; k += 3) {
      final String _currentValue = String.valueOf(this.template.charAt(k))
       + String.valueOf(this.template.charAt(k + 1)) +
       String.valueOf(this.template.charAt(k + 2));
       if(Float.parseFloat(_currentValue)>0){

        this.stringLineResult.add(new NumberConversion(_currentValue));

       }

     
      if (k == 0) {
        if (Float.parseFloat(_currentValue) > 0) {
          this.stringLineResult.add(new Trillion(Float.parseFloat(_currentValue), this.template));
        }
      } else if (k == 3) {
        if (Float.parseFloat(_currentValue) > 0) {
          this.stringLineResult.add(new Billion(Float.parseFloat(_currentValue), this.template));
        }
      } else if (k == 6) {
        if (Float.parseFloat(_currentValue) > 0) {
          this.stringLineResult.add(new Million(Float.parseFloat(_currentValue), this.template));
        }
      } else if (k == 9) {
        if (Float.parseFloat(_currentValue) > 0) {
          this.stringLineResult.add(new Thousands(Float.parseFloat(_currentValue), this.template));
        }
      } else if (k == 12) {
        if (Float.parseFloat(_currentValue) > 0) {
          this.stringLineResult.add(new Hundreds(Float.parseFloat(_currentValue), this.template));
        }
      } else if (k == 15) {
        final Float _cents = Float.parseFloat(String.valueOf(this.template.charAt(16))) + Float.parseFloat(String.valueOf(this.template.charAt(17)));
        if (_cents > 0) {
          this.stringLineResult.add(new Cents(Float.parseFloat(_currentValue), this.template));
        }
      }
    }

    /// LET"S AVOID PRESENTING => UM MIL WHEN WE HAVE A  THOUSAND
    String _data = this.stringLineResult.toString();

    if (!_data.contains("MILHÃO") && !_data.contains("TRILHÃO") && !_data.contains("BILHÃO")) {
      final Boolean _repeated = (_data.contains("UM") && _data.contains("MIL"));
      if (_repeated) {
        _data = _data.substring(3);
      }
    }

    return _data;
  }
}
