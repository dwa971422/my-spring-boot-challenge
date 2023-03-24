package inclassdemo2.service;

import inclassdemo2.model.Entry;

import java.util.List;

public interface DataFetchService {
    List<Entry> getAllEntries(String url);
    List<Entry> getAllEntriesWithSpecificAuth(String url, String auth);
}
