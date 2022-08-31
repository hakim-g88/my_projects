package model.civilian;

public enum Occupation {
    PEASANT("peasant"),
    SHERIFF("sheriff"),
    CARPENTER("carpenter"),
    DOCTOR("doctor"),
    WITCH("witch"),
    SHOEMAKER("shoemaker"),
    WEAVER("weaver"),
    SHEPPARD("sheppard"),
    OTHER("other");

    public final String title;
    private Occupation(String title) {
        this.title = title;
    }
}
