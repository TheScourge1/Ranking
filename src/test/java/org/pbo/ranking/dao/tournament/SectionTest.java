package org.pbo.ranking.dao.tournament;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pbo.ranking.dao.RankingDAOException;
import org.pbo.ranking.model.tournament.Player;
import org.pbo.ranking.model.tournament.Section;
import org.pbo.ranking.model.tournament.Tournament;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class SectionTest extends BaseTournamentDaoTest{

    @Inject
    SectionDAO sectionDAO;
    TournamentDAO tournamentDAO;


    @Test
    public void testCreatePlayer() throws RankingDAOException
    {
        Section s = new Section();
        Assert.assertNotNull("section created",s);

        Tournament t = new Tournament();
        t.setId(1L);
        t = tournamentDAO.find(t);

        s.setName("Eerste provinciale Dames");
        s.setTournament(tournamentDAO.find(t));
        s.setUrl("http://badmintonvlaanderen.toernooi.nl/sport/draw.aspx?id=F750AAD0-FB8C-4EFB-8A70-100EB0E153B0&draw=14");

        sectionDAO.persist(s);

        Section s2 = sectionDAO.find(s);

        Assert.assertEquals("Created persons should be equal",s,s2);
    }
}
