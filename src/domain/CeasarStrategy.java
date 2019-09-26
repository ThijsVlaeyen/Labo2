package domain;

public class CeasarStrategy implements CodingStrategy {

   private int offset;

   public CeasarStrategy(int offset){
      this.offset = offset;
   }

   public void setOffset(int i){
      this.offset = i;
   }

   @Override
   public String encode(String input) {

      StringBuilder result = new StringBuilder();

      for (int i=0; i<input.length(); i++)
      {
         if (Character.isUpperCase(input.charAt(i)))
         {
            char ch = (char)(((int)input.charAt(i) + this.offset - 65) % 26 + 65);
            result.append(ch);
         }
         else
         {
            char ch = (char)(((int)input.charAt(i) + this.offset - 97) % 26 + 97);
            result.append(ch);
         }
      }
      return result.toString();
   }

   @Override
   public String decode(String input) {
      StringBuilder result = new StringBuilder();

      for (int i=0; i<input.length(); i++)
      {
         if (Character.isUpperCase(input.charAt(i)))
         {
            char ch = (char)(((int)input.charAt(i) + -this.offset - 65) % 26 + 65);
            result.append(ch);
         }
         else
         {
            char ch = (char)(((int)input.charAt(i) + -this.offset - 97) % 26 + 97);
            result.append(ch);
         }
      }
      return result.toString();
   }

}
