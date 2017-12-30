package org.pbo.ranking.dao.tournament;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pbo.ranking.dao.RankingDAOException;
import org.pbo.ranking.model.tournament.Event;
import org.pbo.ranking.model.tournament.Tournament;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class EventTest extends BaseTournamentDaoTest{

    @Inject
    EventDAO eventDAO;
    @Inject
    TournamentDAO tournamentDAO;


    @Test
    public void testCreateEvent() throws RankingDAOException
    {
        Event s = new Event();
        Assert.assertNotNull("event created",s);

        Tournament t = new Tournament();
        t.setId(1L);
        t = tournamentDAO.find(t);

        s.setName("Eerste provinciale Dames");
        s.setTournament(tournamentDAO.find(t));
        s.setToernooinl_id("F750AAD0-FB8C-4EFB-8A70-100EB0E153B0&draw=14");

        eventDAO.persist(s);

        Event s2 = eventDAO.find(s);

        Assert.assertEquals("Created persons should be equal",s,s2);
    }
}
