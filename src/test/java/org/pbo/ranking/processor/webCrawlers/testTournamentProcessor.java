package org.pbo.ranking.processor.webCrawlers;

import org.junit.Test;
import org.pbo.ranking.model.tournament.Tournament;
import org.pbo.ranking.util.ToernooiNLDateParser;

import static org.assertj.core.api.Assertions.assertThat;

public class testTournamentProcessor {

    public final String PBOCOMP2017_ID = "2EE16507-FBD1-4124-A79E-0E90BD7902E4";

    @Test
    public void testGetTournamentDetails() throws WebCrawlerException, Exception
    {
        TournamentProcessor tProcessor = new TournamentProcessor();
        Tournament t = tProcessor.getTournamentDetails(PBOCOMP2017_ID);

        assertThat(t).as("No tournament found").isNotNull();
        assertThat(t.getName())
                .as("No tournament name found").isNotNull()
                .as("Check name retrieved").isEqualTo("PBO Jeugdcup Badminton Buggenhout 2017");

        assertThat(t.getStartDate())
                .as("No tournament start date found").isNotNull()
                .as("Check date retrieved").isEqualTo(ToernooiNLDateParser.ParseLongDescriptionDate("zaterdag 23 december 2017"));
    }
}
