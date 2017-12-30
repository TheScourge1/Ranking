package org.pbo.ranking.model.tournament;

import javax.persistence.*;

@Entity
@Table(name="draw")
public class Draw extends BaseTournamentEntity {

    public enum DrawType {POULE,KO};

    @Column(name="name")
    private String name;

    @Column(name="sortorder")
    private int sortOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    private Event event;

    @Enumerated(EnumType.STRING)
    @Column(name="draw_type")
    private DrawType drawType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public DrawType getDrawType() {
        return drawType;
    }

    public void setDrawType(DrawType drawType) {
        this.drawType = drawType;
    }

    @Override
    public boolean equals(Object o) {
        Draw d = (Draw)o;
        return d.event.equals(event) && d.name.equals(name);
    }

    @Override
    public int hashCode() {
        return event.hashCode() + 31*name.hashCode();
    }
}
