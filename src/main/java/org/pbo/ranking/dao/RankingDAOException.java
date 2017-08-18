package org.pbo.ranking.dao;

public class RankingDAOException extends Exception {


    public RankingDAOException (String message) {
        super(message);
    }

    public RankingDAOException (Throwable cause) {
        super (cause);
    }

    public RankingDAOException (String message, Throwable cause) {
        super (message, cause);
    }



}
