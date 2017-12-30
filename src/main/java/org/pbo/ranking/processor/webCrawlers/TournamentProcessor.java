package org.pbo.ranking.processor.webCrawlers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.pbo.ranking.model.tournament.Event;
import org.pbo.ranking.model.tournament.Tournament;
import org.pbo.ranking.util.ToernooiNLDateParser;

import java.util.ArrayList;
import java.util.List;

public class TournamentProcessor {
    private static final String BASE_URL = "http://badmintonvlaanderen.toernooi.nl/sport/";
    private static final String URL_SUFFIX = "tournament.aspx";
    private static final String TOURNAMENT_TITLE_QUERY = "#divTournamentHeader > .title > h3";
    private static final String TOURNAMENT_DATE_QUERY = "h3:contains(Toernooidagen) + p";
    private static final String TOURNAMENT_EVENTS_QUERY = "table.tournamentEvents > tbody > tr > td > a[href]";

    Tournament getTournamentDetails(String id) throws WebCrawlerException {
        String tournamentUrl = BASE_URL + URL_SUFFIX+"?id="+id;

        Tournament tournament = new Tournament();
        try{
            Document doc = Jsoup.connect(tournamentUrl).get();
            tournament.setName(doc.select(TOURNAMENT_TITLE_QUERY).first().text());
            if(tournament.getName() == null || tournament.getName().equals(""))
            {
                throw new Exception("No tournament name found with query: "+TOURNAMENT_TITLE_QUERY);
            }
            tournament.setToernooinl_id(id);
            String tournamentStartDate = doc.select(TOURNAMENT_DATE_QUERY).text();
            tournament.setStartDate(ToernooiNLDateParser.ParseLongDescriptionDate(tournamentStartDate));

            Elements eventsQuery = doc.select(TOURNAMENT_EVENTS_QUERY);
            List<String> eventUrls = new ArrayList<>();
            for(Element e : eventsQuery){
                eventUrls.add(BASE_URL+e.attr("href"));
            }
            loadEvents(eventUrls);


        }catch(Exception e) {
           throw new WebCrawlerException("Error loading tournament page "+tournamentUrl,e);
        }

        return tournament;
    }

    private List<Event> loadEvents(List<String> eventUrls){
        List<Event> eventList = new ArrayList<>();


        return eventList;
    }
}
