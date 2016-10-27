import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 332. Reconstruct Itinerary
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

 Note:
 If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.

 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class SolutionCCCXXXII {
    private Map<String, List<String>> adjList = new HashMap<String, List<String>>();
    private LinkedList<String> route = new LinkedList<String>();
    private int numTickets = 0;
    private int numTicketsUsed = 0;
    public List<String> findItinerary(String[][] tickets) {
        // 1. set up the graph and sort the adj list
        // 2. dfs
        if (tickets == null || tickets.length==0) return route;
        // build graph
        numTickets = tickets.length;
        for (int i = 0; i < numTickets; i++) {
            if (!adjList.containsKey(tickets[i][0])) {
                List<String> list = new LinkedList<String>();
                list.add(tickets[i][1]);
                adjList.put(tickets[i][0], list);
            } else {
                adjList.get(tickets[i][0]).add(tickets[i][1]);
            }
        }

        // sort in lexical
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) Collections.sort(entry.getValue());

        // dfs
        route.add("JFK");
        dfsRoute("JFK");
        return route;
    }
    public void dfsRoute(String source) {
        // base case: source is not in any adj list, so we reach end
        if (!adjList.containsKey(source)) return;
        List<String> list = adjList.get(source);
        for (int i = 0; i < list.size(); i++) {
            String neighbour = list.get(i);
            // remove this neighbour
            list.remove(i);
            route.add(neighbour);
            numTicketsUsed++;

            dfsRoute(neighbour);
            // only return when we have used all tickets
            if (numTicketsUsed==numTickets) return;

            list.add(i, neighbour);
            route.removeLast();
            numTicketsUsed--;
        }
    }
}
