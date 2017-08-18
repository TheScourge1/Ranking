package org.pbo.ranking.dao.tournament;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.pbo.ranking.util.BaseDaoTest;

public class BaseTournamentDaoTest extends BaseDaoTest {

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addPackages(true,"org.pbo.ranking.dao")
                .addPackages(true,"org.pbo.ranking.model")
                .addPackages(true,"org.pbo.ranking.util")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/create.sql")
                .addAsResource("META-INF/drop.sql")
                .addAsResource("META-INF/load.sql");
        System.out.println(war.toString(true));
        return war;
    }
}
