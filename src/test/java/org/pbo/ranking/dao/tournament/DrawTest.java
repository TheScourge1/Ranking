package org.pbo.ranking.dao.tournament;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pbo.ranking.dao.RankingDAOException;
import org.pbo.ranking.model.tournament.Draw;
import org.pbo.ranking.model.tournament.Event;
import org.pbo.ranking.model.tournament.Tournament;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Arquillian.class)
public class DrawTest extends BaseTournamentDaoTest{

    @Inject
    DrawDAO drawDAO;

    @Inject
    EventDAO eventDAO;


    @Test
    public void testCreateDraw() throws RankingDAOException {
        Draw d = new Draw();

        Event e = new Event();
        e.setId(1L);
        e = eventDAO.find(e);

        d.setName("Fourth created draw");
        d.setDrawType(Draw.DrawType.KO);
        d.setEvent(e);
        d.setSortOrder(4);

        drawDAO.persist(d);

        Draw d2 = drawDAO.find(d);

        assertThat(d2)
                .isNotNull()
                .isEqualTo(d);

        e = eventDAO.find(e);
    }


    @Test
    public void testReadDraw() throws RankingDAOException {
        Draw d = new Draw();
        d.setId(1L);
        d = drawDAO.find(d);

        Event e = new Event();
        e.setId(1L);
        e = eventDAO.find(e);

        assertThat(d.getName())
                .isNotNull()
                .isEqualTo("event 3");

        assertThat(d.getDrawType())
                .isNotNull()
                .isEqualTo(Draw.DrawType.KO);

        assertThat(d.getEvent())
                .isNotNull()
                .isEqualTo(e);
    }
}
