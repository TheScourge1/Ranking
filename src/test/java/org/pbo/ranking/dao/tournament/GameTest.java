package org.pbo.ranking.dao.tournament;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pbo.ranking.dao.RankingDAOException;
import org.pbo.ranking.model.tournament.Draw;
import org.pbo.ranking.model.tournament.Event;
import org.pbo.ranking.model.tournament.Game;
import org.pbo.ranking.model.tournament.Player;

import javax.inject.Inject;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Arquillian.class)
public class GameTest extends BaseTournamentDaoTest{

    @Inject
    DrawDAO drawDAO;
    @Inject
    PlayerDAO playerDAO;
    @Inject
    GameDAO gameDAO;

    @Test
    public void testCreateGame() throws RankingDAOException {
        Game g = new Game();

        Draw d = drawDAO.find(1,Draw.class);
        Player p1 = playerDAO.find(1,Player.class);
        Player p2 = playerDAO.find(2,Player.class);

        g.setDraw(d);
        g.setPlayer1TeamA(p1);
        g.setPlayer2TeamA(p2);
        g.setGameResults("13-21 21-3 0-21");
        g.setGameDate(new Date());

        gameDAO.persist(g);

        Game g2 = gameDAO.find(g);

        assertThat(g2)
                .isNotNull()
                .isEqualTo(g);
    }


    @Test
    public void testReadGame() throws RankingDAOException {
        Game g = gameDAO.find(1,Game.class);
        Draw d = drawDAO.find(1, Draw.class);
        Player p1 = playerDAO.find(1,Player.class);

        assertThat(g.getDraw())
                .isNotNull()
                .isEqualTo(d);

        assertThat(g.getPlayer1TeamA())
                .isNotNull()
                .isEqualTo(p1);

        assertThat(g.getGameResults())
                .isNotNull()
                .isEqualTo("21-5 6-21");
    }
}
