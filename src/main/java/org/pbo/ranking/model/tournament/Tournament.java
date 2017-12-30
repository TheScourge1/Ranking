package org.pbo.ranking.model.tournament;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tournament")
public class Tournament extends BaseTournamentEntity {

    public static enum CompetitionType { TOURNAMENT, COMPETITION};

    @Column(name="name")
    String name;
    @Column(name="toernooinl_id")
    String toernooinl_id;
    @Column(name="start_dat")
    Date startDate;

    @Convert(converter = CompetitionTypeConverter.class)
    @Column(name="type")
    CompetitionType competitionType;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tournament")
    @OrderBy("sortOrder asc")
    List<Event> eventList;

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToernooinl_id() {
        return toernooinl_id;
    }

    public void setToernooinl_id(String url) {
        this.toernooinl_id = url;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
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

    @Converter
    public static class CompetitionTypeConverter implements AttributeConverter<CompetitionType, String> {

        @Override
        public String convertToDatabaseColumn(CompetitionType attribute) {
            switch (attribute) {
                case TOURNAMENT:
                    return "T";
                case COMPETITION:
                    return "C";
                default:
                    throw new IllegalArgumentException("CompetitionType not mapped to db attribute" + attribute);
            }
        }

        @Override
        public CompetitionType convertToEntityAttribute(String dbData) {
            switch (dbData) {
                case "T":
                    return CompetitionType.TOURNAMENT;
                case "C":
                    return CompetitionType.COMPETITION;
                default:
                    throw new IllegalArgumentException("Unknown competitiontype found in DB (expect T or C)" + dbData);
            }
        }
    }
}
