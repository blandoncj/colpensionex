package util;

import models.Contributor;
import java.util.*;

public class Blacklist implements Iterable<Contributor> {
    private List<Contributor> blacklist;

    public Blacklist() {
        this.blacklist = new LinkedList<>();
    }

    public void add(Contributor contributor) {
        blacklist.add(contributor);
    }

    public boolean contains(String id) {
        for (Contributor contributor : blacklist) {
            if (contributor.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<Contributor> iterator() {
        return blacklist.iterator();
    }
}