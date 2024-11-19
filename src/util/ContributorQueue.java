package util;

import models.Contributor;
import java.util.*;

public class ContributorQueue {
    private PriorityQueue<Contributor> queue;

    public ContributorQueue() {
        this.queue = new PriorityQueue<>(Comparator.comparing(Contributor::getSavings).reversed());
    }

    public void addContributor(Contributor cotizante) {
        queue.offer(cotizante);
    }

    public Contributor removeContributor() {
        return queue.poll();
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    public long getSize() {
        return queue.size();
    }
}