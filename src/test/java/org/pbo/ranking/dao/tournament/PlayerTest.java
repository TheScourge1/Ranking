package org.pbo.ranking.dao.tournament;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pbo.ranking.dao.RankingDAOException;
import org.pbo.ranking.model.tournament.Player;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class PlayerTest extends BaseTournamentDaoTest{

    @Inject
    PlayerDAO playerDAO;


    @Test
    public void testCreatePlayer() throws RankingDAOException
    {
        Player p = new Player();
        Assert.assertNotNull("player created",p);

        p.setFirstName("Koen");
        p.setLastName("Tourné");
        p.setPlayerId(5000001L);
        p.setSex(Player.Gender.M);

        playerDAO.persist(p);

        Player p2 = playerDAO.find(p);

        Assert.assertEquals("Created persons should be equal",p,p2);
    }
}
