package org.pbo.ranking.dao.tournament;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pbo.ranking.dao.RankingDAOException;
import org.pbo.ranking.model.tournament.Event;
import org.pbo.ranking.model.tournament.Tournament;

import javax.inject.Inject;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Arquillian.class)
public class TournamentTest extends BaseTournamentDaoTest{

    @Inject
    TournamentDAO tournamentDAO;
    @Inject
    EventDAO eventDAO;


    @Test
    public void testCreateTournament() throws RankingDAOException
    {
        Tournament t = new Tournament();
        Assert.assertNotNull("tournament instantiated",t);

        t.setName("Test Toernooi");
        t.setStartDate(new Date());
        t.setCompetitionType(Tournament.CompetitionType.COMPETITION);
        t.setToernooinl_id("F750AAD0-FB8C-4EFB-8A70-100EB0E153B0");

        tournamentDAO.persist(t);

        Tournament t2 = tournamentDAO.find(t);

        Assert.assertEquals("Created tournaments should be equal",t,t2);
    }

    @Test
    public void testLoadTournament() throws RankingDAOException
    {
        Tournament t = new Tournament();
        t.setId(1L);
        t = tournamentDAO.find(t);

        Event event1 = new Event();
        event1.setId(1L);
        event1 = eventDAO.find(event1);

        assertThat(t.getName())
                .isNotNull()
                .isEqualTo("testToernooi");

        assertThat(t.getCompetitionType())
                .isNotNull()
                .isEqualTo(Tournament.CompetitionType.TOURNAMENT);

        assertThat(t.getEventList())
                .isNotNull()
                .isNotEmpty()
                .hasSize(4)
                .contains(event1);

        assertThat(t.getEventList().get(0).getSortOrder())
                .isEqualTo(1);
        assertThat(t.getEventList().get(2).getSortOrder())
                .isEqualTo(3);


    }
}
