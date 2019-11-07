package domain;

public enum CipherType {
    CEASERCIPHER("ceasercipher","domain.CeaserStrategy"),
    MIRROR("Mirror","domain.MirrorStrategy"),
    AUTOKEY("Autokey","domain.AutokeyStrategy"),
    RANDOMCIPHER("RandomCipher","domain.RandomCypher");

    private final String name;
    private final String className;

    CipherType(String name,String className){
        this.name = name;
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public String getName() {
        return name;
    }
}

