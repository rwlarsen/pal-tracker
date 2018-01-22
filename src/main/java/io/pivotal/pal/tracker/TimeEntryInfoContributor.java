package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryInfoContributor implements InfoContributor {
    @Autowired TimeEntryRepository repository;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("time Entries",repository.list().size());
    }
}
