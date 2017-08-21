package org.pbo.ranking.dao.tournament;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pbo.ranking.dao.RankingDAOException;
import org.pbo.ranking.model.tournament.Player;
import org.pbo.ranking.model.tournament.Tournament;

import javax.inject.Inject;
import java.util.Date;

@RunWith(Arquillian.class)
public class TournamentTest extends BaseTournamentDaoTest{

    @Inject
    TournamentDAO tournamentDAO;


    @Test
    public void testCreateTournament() throws RankingDAOException
    {
        Tournament t = new Tournament();
        Assert.assertNotNull("tournament instantiated",t);

        t.setName("Test Toernooi");
        t.setStartDate(new Date());
        t.setUrl("http://badmintonvlaanderen.toernooi.nl/sport/tournament.aspx?id=F750AAD0-FB8C-4EFB-8A70-100EB0E153B0");

        tournamentDAO.persist(t);

        Tournament t2 = tournamentDAO.find(t);

        Assert.assertEquals("Created tournaments should be equal",t,t2);
    }
}
