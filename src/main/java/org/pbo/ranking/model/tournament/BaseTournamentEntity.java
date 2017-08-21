package org.pbo.ranking.model.tournament;

import org.pbo.ranking.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
public abstract class BaseTournamentEntity implements Serializable,BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id  @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(TIMESTAMP)
    @Column(name="CREATE_DAT", nullable=false)
    private Date createDate;
    @Temporal(TIMESTAMP)
    @Column(name="LAST_UPDATE_DAT", nullable=false)
    private Date lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void BaseTournamentEnity(){}

    public void BaseTournamentEntity(Long id)
    {
        this.id = id;
    }


    /**
     * Some logic for auto logging insert/updates in db. All tables must contain to the specified fields.
     */
    @PrePersist
    protected void onCreate() {
        createDate = new Date(System.currentTimeMillis());
        onUpdate();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdateDate = (new Date(System.currentTimeMillis()));
    }

    /**
        Force override to implement business keys
     */
    public abstract boolean equals(Object o);
    public abstract int hashCode();

    /**
     * Method to avoid code duplication
     */
    protected boolean basicEqualsCheck(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " id: " +id;
    }
}
