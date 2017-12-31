package org.pbo.ranking.model.tournament;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="player")
public class Player extends BaseTournamentEntity {

    public enum Gender {M,F};

    @Column(name="playerid")
    public Long playerId;
    @Column(name="profile_id")
    public String profileId;
    @Enumerated(EnumType.STRING)
    public Gender sex;

    @Column(name="firstname")
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

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    @Override
    public boolean equals(Object o) {

        return this.basicEqualsCheck(o) || (playerId != null && ((Player)o).playerId != null && playerId.equals(((Player)o).playerId))
                || (profileId != null && ((Player)o).profileId != null && profileId.equals(((Player)o).profileId));
    }

    public int hashCode() {
        if(playerId != null && !playerId.equals("")) return playerId.hashCode();
        else if(profileId != null & ! profileId.equals("")) return profileId.hashCode();
        else return lastName.hashCode() +31 * firstName.hashCode();
    }

    @Override
    public String toString()
    {
        if(firstName != null && lastName != null)
            return (firstName + " " + lastName + "("+playerId+")");
        else return super.toString();
    }
}
