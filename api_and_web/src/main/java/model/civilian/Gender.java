package model.civilian;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    OTHER("other");

    public final String title;
    private Gender(String title) {
        this.title = title;
    }
}
