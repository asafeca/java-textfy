package service;

import factory.BaseFactory;

public class NumberConversion implements BaseFactory {
    private Float value;
    private String stringValue = "";
    private String template;
    
        public NumberConversion(String template){
         this.template = template;
    
        }
    
        @Override
      public   BaseFactory build(BaseFactory... child){
    
            final Integer a = Integer.parseInt(String.valueOf(template.charAt(0)));
            final Integer b = Integer.parseInt(String.valueOf(template.charAt(1)));
            final Integer c = Integer.parseInt(String.valueOf(template.charAt(2)));
    
            if (a == 1) {
                this.stringValue += (b + c) == 0 ? "CEM" : "CENTO";
              } else if (a == 2) {
                this.stringValue += "DUZENTOS";
              } else if (a == 3) {
                this.stringValue += "TREZENTOS";
                
              } else if(a==4){
                this.stringValue += "QUATROCENTOS";
              }
              
              else if (a == 5) {
                this.stringValue += "QUINHENTOS";
              } else if (a == 6) {
                this.stringValue += "SEISCENTOS";
              } else if (a == 7) {
                this.stringValue += "SETECENTOS";
              } else if (a == 8) {
                this.stringValue += "OITOCENTOS";
              } else if (a == 9) {
                this.stringValue += "NOVECENTOS";
              }
    
              if (b == 1) {
                if (c == 0) {
                  this.stringValue += (a > 0 ? " E " : "") + "DEZ";
                }
                if (c == 1) {
                  this.stringValue += (a > 0 ? " E " : "") + "ONZE";
                }
                if (c == 2) {
                  this.stringValue += (a > 0 ? " E " : "") + "DOZE";
                }
                if (c == 3) {
                  this.stringValue += (a > 0 ? " E " : "") + "TREZE";
                }
                if (c == 4) {
                  this.stringValue += (a > 0 ? " E " : "") + "CATORZE";
                }
                if (c == 5) {
                  this.stringValue += (a > 0 ? " E " : "") + "QUINZE";
                }
                if (c == 6) {
                  this.stringValue += (a > 0 ? " E " : "") + "DEZASSEIS";
                }
                if (c == 7) {
                  this.stringValue += (a > 0 ? " E " : "") + "DEZASSETE";
                }
                if (c == 8) {
                  this.stringValue += (a > 0 ? " E " : "") + "DEZOITO";
                }
                if (c == 9) {
                  this.stringValue += (a > 0 ? " E " : "") + "DEZANOVE";
                }
              } else if (b == 2) {
                this.stringValue += (a > 0 ? " E " : "") + "VINTE";
              } else if (b == 3) {
                this.stringValue += (a > 0 ? " E " : "") + "TRINTA";
              } else if (b == 3) {
                this.stringValue += (a > 0 ? " E " : "") + "TRINTA";
              } else if (b == 4) {
                this.stringValue += (a > 0 ? " E " : "") + "QUARENTA";
              } else if (b == 5) {
                this.stringValue += (a > 0 ? " E " : "") + "CINQUENTA";
              } else if (b == 6) {
                this.stringValue += (a > 0 ? " E " : "") + "SESSENTA";
              } else if (b == 7) {
                this.stringValue += (a > 0 ? " E " : "") + "SETENTA";
              } else if (b == 8) {
                this.stringValue += (a > 0 ? " E " : "") + "OITENTA";
              } else if (b == 9) {
                this.stringValue += (a > 0 ? " E " : "") + "NOVENTA";
              }
          
              if (b != 1 && c != 0 && this.stringValue != "") {
                this.stringValue += " E ";
              }
              if (b != 1) {
                if (c == 1) {
                  this.stringValue += "UM";
                } else if (c == 2) {
                  this.stringValue += "DOIS";
                } else if (c == 3) {
                  this.stringValue += "TRÊS";
                } else if (c == 4) {
                  this.stringValue += "QUATRO";
                } else if (c == 5) {
                  this.stringValue += "CINCO";
                } else if (c == 6) {
                  this.stringValue += "SEIS";
                } else if (c == 7) {
                  this.stringValue += "SETE";
                } else if (c == 8) {
                  this.stringValue += "OITO";
                } else if (c == 9) {
                  this.stringValue += "NOVE";
                }
              }
    
    
           
        return this;
        }
    
        @Override
        public String toString(){
            this.build();
    
            return this.stringValue;
    
    
    
        }
        
    }
