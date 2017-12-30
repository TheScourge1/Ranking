package org.pbo.ranking.model.tournament;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="event")
public class Event extends BaseTournamentEntity {

    @Column(name="name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tournament tournament;

    @Column(name="toernooinl_id")
    String toernooinl_id;

    @Column(name="sortorder")
    private int sortOrder;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "event")
    @OrderBy("sortOrder asc")
    private List<Draw> draws;

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

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getToernooinl_id() {
        return toernooinl_id;
    }

    public void setToernooinl_id(String url) {
        this.toernooinl_id = url;
    }

    public List<Draw> getDraws() {
        return draws;
    }

    public void setDraws(List<Draw> draws) {
        this.draws = draws;
    }

    @Override
    public boolean equals(Object o) {

        return this.basicEqualsCheck(o) ||
                (tournament.equals(((Event)o).tournament) && name.equals(((Event) o).name));
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
