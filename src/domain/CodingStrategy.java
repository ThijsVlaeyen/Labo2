package domain;

public interface CodingStrategy {
   String encode(String input);
   String decode(String input);
}
