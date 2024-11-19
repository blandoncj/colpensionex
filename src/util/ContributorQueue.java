package util;

import models.Contributor;
import java.util.*;

public class ContributorQueue {
    private PriorityQueue<Contributor> queue;

    public ContributorQueue() {
        this.queue = new PriorityQueue<>(new ContributorComparator());
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

    private static class ContributorComparator implements Comparator<Contributor> {
        @Override
        public int compare(Contributor c1, Contributor c2) {
            if (c1.getAge() < 35 && c2.getAge() >= 35) {
                return -1;
            } else if (c1.getAge() >= 35 && c2.getAge() < 35) {
                return 1;
            }

            if (c1.getSavings() < 1000 && c2.getSavings() >= 1000) {
                return -1;
            } else if (c1.getSavings() >= 1000 && c2.getSavings() < 1000) {
                return 1;
            }

            // If have the same priority, sort by descending savings
            return Double.compare(c2.getSavings(), c1.getSavings());
        }
    }
}