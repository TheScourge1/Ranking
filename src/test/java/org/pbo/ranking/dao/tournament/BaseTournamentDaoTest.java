package org.pbo.ranking.dao.tournament;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.pbo.ranking.util.BaseDaoTest;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import java.io.File;
import java.util.Arrays;

public class BaseTournamentDaoTest extends BaseDaoTest {

    @Deployment
    public static WebArchive createDeployment() {

        //Configure to load maven libraries
        File[] files = Maven.resolver().loadPomFromFile("pom.xml")
                .importRuntimeDependencies().resolve().withTransitivity().asFile();

        File[] testFiles = Maven.resolver().loadPomFromFile("pom.xml").importTestDependencies().resolve().withTransitivity().asFile();

        testFiles = Arrays.stream(testFiles)
                            .filter(file -> file.getName().toLowerCase().contains("assertj"))
                            .toArray(File[]::new);

        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addPackages(true,"org.pbo.ranking.dao")
                .addPackages(true,"org.pbo.ranking.model")
                .addPackages(true,"org.pbo.ranking.util")
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("META-INF/create.sql")
                .addAsResource("META-INF/drop.sql")
                .addAsResource("META-INF/load.sql")
                .addAsLibraries(files)
                .addAsLibraries(testFiles);
        System.out.println(war.toString(true));
        return war;
    }
}
