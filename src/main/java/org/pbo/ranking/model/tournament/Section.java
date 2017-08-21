package org.pbo.ranking.model.tournament;

import javax.persistence.*;
import org.pbo.ranking.model.tournament.Tournament;

@Entity
@Table(name="section")
public class Section extends BaseTournamentEntity {

    @Column(name="name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tournament tournament;

    @Column(name="url")
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {

        return this.basicEqualsCheck(o) ||
                (tournament.equals(((Section)o).tournament) && name.equals(((Section) o).name));
    }

    public int hashCode() {
        if(tournament == null || name == null) return 0;
        int hashCode = tournament.hashCode();
        hashCode += 31* name.hashCode();
        return hashCode;
    }

    @Override
    public String toString()
    {
        if(tournament != null && name != null)
            return (tournament.getName() + " - " + name + "("+this.getId()+")");
        else return super.toString();
    }
}
