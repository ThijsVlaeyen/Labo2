package domain;

public class RandomCypherAdaptor implements CodingStrategy {
    RandomCypher randomCypher;

    public RandomCypherAdaptor(RandomCypher randomCypher) {
        this.randomCypher = randomCypher;
    }

    @Override
    public String encode(String input) {
        return randomCypher.encypher(input.toCharArray()).toString();
    }

    @Override
    public String decode(String input) {
        return randomCypher.decypher(input.toCharArray()).toString();
    }
}
