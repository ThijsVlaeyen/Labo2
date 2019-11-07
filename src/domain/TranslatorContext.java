package domain;

import java.util.ArrayList;
import java.util.List;

public class TranslatorContext{

   private String input;
   private CodingStrategy codingStrategy;
   private CipherType cipherType;

   public TranslatorContext(CodingStrategy coding, String text){
      this.input = text;
      this.codingStrategy = coding;
   }

   public void setCodingStrategy(CodingStrategy codingStrategy){
      this.codingStrategy = codingStrategy;
   }

   public void setInput(String input){
       this.input = input;
   }

   public String encode(){
      return codingStrategy.encode(input);
   }

   public String decode(){
      return codingStrategy.decode(input);
   }

   @Override
   public String toString(){
      String out = "";
      out += "\nInput text: " + input;
      out += "\nEncoded text: " + this.encode();
      return out;
   }

   public List<String> getStrategies(){
      List<String> list = new ArrayList<>();
      for (CipherType cipher:this.cipherType.values()) {
         list.add(cipher.getName());
      }
      return list;
   }

}
