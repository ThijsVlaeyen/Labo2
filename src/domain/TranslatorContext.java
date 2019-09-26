package domain;

public class TranslatorContext{

   private String input;
   private CodingStrategy codingStrategy;

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

}
