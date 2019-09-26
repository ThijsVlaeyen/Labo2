package domain;

public class MirrorStrategy implements CodingStrategy {

   @Override
   public String encode(String input) {
      String encoded = "";
      for (int i = input.length()-1; i >=0; i--) {
         encoded += input.charAt(i);
      }
      return encoded.toLowerCase();
   }

   @Override
   public String decode(String input) {
      return encode(input).toLowerCase();
   }

   @Override
   public String toString(){
      return "MirrorStrategy";
   }
}
