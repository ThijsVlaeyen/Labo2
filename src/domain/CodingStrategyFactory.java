package domain;

public class CodingStrategyFactory {

      public CodingStrategy createObject(String type){
         CipherType taalEnum = CipherType.valueOf(type);
         String className = taalEnum.getClassName();
         CodingStrategy encoder = null;

         try {
            Class dbClassName = Class.forName(className);
            Object encoderObject = dbClassName.newInstance();
            encoder = (CodingStrategy) encoderObject;
         } catch (Exception e) {
            System.out.println(e.getMessage());
         } //G2 will win worlds
         return encoder;

      }
}
