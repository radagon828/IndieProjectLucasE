package persistance;

import entity.Run;

import java.util.*;

public final class RunSort {
    public static List<Run> sortByTime(Set<Run> runs) {
        List<Run> runList = new ArrayList<>();
        runList.addAll(runs);
        Collections.sort(runList, new Comparator<Run>() {
            public int compare(Run run, Run t1) {
                return run.getTime().compareTo(t1.getTime());
            }
        });
        return runList;
    }
}
