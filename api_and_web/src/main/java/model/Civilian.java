package model;

import model.civilian.Occupation;
import model.civilian.Gender;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;


public class Civilian implements Serializable {
    @Min(0)
    private int age;

    @Size(min=1)
    private String firstName;

    @Size(min=1)
    private String secondName;

    private Integer id;

    @NotNull
    private Occupation occupation;

    @NotNull
    private Gender gender;

    public Civilian(String firstName, String secondName, Occupation occupation, Gender gender, int age) {
        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
        this.occupation = occupation;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Civilian{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", id=" + id +
                ", occupation=" + occupation +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Civilian civilian = (Civilian) o;
        return age == civilian.age && id == civilian.id && firstName.equals(civilian.firstName) && secondName.equals(civilian.secondName) && occupation == civilian.occupation && gender == civilian.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, firstName, secondName, id, occupation, gender);
    }
}