package org.pbo.ranking.model.tournament;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tournament")
public class Tournament extends BaseTournamentEntity {


    @Column(name="name")
    String name;
    @Column(name="url")
    String url;
    @Column(name="start_dat")
    Date startDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {

        return this.basicEqualsCheck(o) ||
                (startDate.equals(((Tournament)o).startDate) &&  name.equals(((Tournament)o).name)) ;
    }

    public int hashCode() {
        if(name == null || startDate == null) return 0;
        int hashCode = startDate.hashCode();
        hashCode += 31* name.hashCode();
        return hashCode;
    }

    @Override
    public String toString()
    {
        if(name != null)
            return (name +  "("+this.getId()+")");
        else return super.toString();
    }
}
