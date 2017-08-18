package org.pbo.ranking.util;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class LogProducer {

    @Produces
    public Logger producer(InjectionPoint ip){
        return LoggerFactory.getLogger(
                ip.getMember().getDeclaringClass().getName());
    }
}