package org.pbo.ranking.model.tournament;

import javax.persistence.*;
import org.pbo.ranking.model.tournament.Player;

import java.util.Date;

@Entity
@Table(name="game")
public class Game extends BaseTournamentEntity {

    public enum GameStatus {OK,WALKOVER,FORFEIGHT};

    @ManyToOne(fetch = FetchType.EAGER)
    private Draw draw;

    @ManyToOne(fetch = FetchType.EAGER)
    private Player player1TeamA;
    @ManyToOne(fetch = FetchType.EAGER)
    private Player player2TeamA;
    @ManyToOne(fetch = FetchType.EAGER)
    private Player player1TeamB;
    @ManyToOne(fetch = FetchType.EAGER)
    private Player player2TeamB;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private GameStatus status;

    @Column(name="game_date")
    private Date gameDate;

    @Column(name="game_results")
    String gameResults;

    public Draw getDraw() {
        return draw;
    }

    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    public Player getPlayer1TeamA() {
        return player1TeamA;
    }

    public void setPlayer1TeamA(Player player1TeamA) {
        this.player1TeamA = player1TeamA;
    }

    public Player getPlayer2TeamA() {
        return player2TeamA;
    }

    public void setPlayer2TeamA(Player player2TeamA) {
        this.player2TeamA = player2TeamA;
    }

    public Player getPlayer1TeamB() {
        return player1TeamB;
    }

    public void setPlayer1TeamB(Player player1TeamB) {
        this.player1TeamB = player1TeamB;
    }

    public Player getPlayer2TeamB() {
        return player2TeamB;
    }

    public void setPlayer2TeamB(Player player2TeamB) {
        this.player2TeamB = player2TeamB;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public String getGameResults() {
        return gameResults;
    }

    public void setGameResults(String gameResults) {
        this.gameResults = gameResults;
    }

    @Override
    public boolean equals(Object o) {
        Game d1 = (Game)o;
        if(super.basicEqualsCheck(o)) return true;
        if(draw == null || d1.draw == null || player1TeamA == null || player1TeamB == null) return false;
        return d1.draw.equals(draw) && d1.player1TeamA.equals(player1TeamA) && d1.player1TeamB.equals(player1TeamB);
    }

    @Override
    public int hashCode(){
        return draw.hashCode() + player1TeamA.hashCode() + player1TeamB.hashCode();
    }
}
