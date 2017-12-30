package org.pbo.ranking.processor.webCrawlers;

public class WebCrawlerException extends Exception{

    WebCrawlerException(String message,Exception e)
    {
        super(message,e);
    }
}
