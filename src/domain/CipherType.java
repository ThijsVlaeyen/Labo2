package domain;

public enum CipherType {
    CEASERCIPHER("ceasercipher","domain.CeaserStrategy",true),
    MIRROR("Mirror","domain.MirrorStrategy",false),
    AUTOKEY("Autokey","domain.AutokeyStrategy",true),
    RANDOMCIPHER("RandomCipher","domain.RandomCypher",false);

    private final String name;
    private final String className;
    private boolean offset;

    CipherType(String name,String className,boolean offset){
        this.name = name;
        this.className = className;
        this.offset = offset;
    }

    public String getClassName() {
        return className;
    }

    public String getName() {
        return name;
    }

    public boolean isOffset() {
        return offset;
    }
}

