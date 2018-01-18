package io.pivotal.pal.tracker;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    List<TimeEntry> timeEntryList = new LinkedList<>();
    long nextId = 1;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(nextId++);
        timeEntryList.add(timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return timeEntryList.stream().filter(te -> te.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntryList;
    }

    @Override
    public TimeEntry update(long id, TimeEntry newEntry) {
        TimeEntry listEntry = find(id);
        listEntry.setDate(newEntry.getDate());
        listEntry.setHours(newEntry.getHours());
        listEntry.setProjectId(newEntry.getProjectId());
        listEntry.setUserId(newEntry.getUserId());
        return listEntry;
    }

    @Override
    public void delete(long id) {
        timeEntryList.remove(find(id));
    }


}
