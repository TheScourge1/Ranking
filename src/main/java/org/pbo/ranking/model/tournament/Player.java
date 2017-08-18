package org.pbo.ranking.model.tournament;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="player")
public class Player extends BaseTournamentEntity {

    public enum Gender {M,F};

    public Long playerId;
    @Enumerated(EnumType.STRING)
    public Gender sex;
    public String firstName;
    @Column(name="name", nullable=false)
    public String lastName;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Override
    public boolean equals(Object o) {

        return this.basicEqualsCheck(o) || playerId.equals(((Player)o).playerId);
    }

    public int hashCode() {
        return playerId.hashCode();
    }

    @Override
    public String toString()
    {
        if(firstName != null && lastName != null)
            return (firstName + " " + lastName + "("+playerId+")");
        else return super.toString();
    }
}
