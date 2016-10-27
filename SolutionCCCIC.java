import java.util.HashMap;

/**
 * 399. Evaluate Division
 *
 * Equations are given in the format A / B = k,
 * where A and B are variables represented as strings,
 * and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return -1.0.

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is:
 vector<pair<string, string>> equations,
 vector<double>& values,
 vector<pair<string, string>> queries ,
 where equations.size() == values.size(), and the values are positive.
 This represents the equations.
 Return vector<double>.

 According to the example above:

 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
public class SolutionCCCIC {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // Floyd-Warshall Graph Algorithm
        /**
         *      a   b   c
         *   -------------
         *   a 1.0 2.0 6.0
         *   b 0.5 1.0 3.0
         *   c .16 .33 1.0
         */
        HashMap<String, HashMap<String, Double>> graph = new HashMap<String, HashMap<String, Double>>();
        for (int i = 0; i < equations.length; i++) {
            String s = equations[i][0];
            String d = equations[i][1];
            if (!graph.containsKey(s)) graph.put(s, new HashMap<String, Double>());
            if (!graph.containsKey(d)) graph.put(d, new HashMap<String, Double>());
            graph.get(s).put(s, 1.0);
            graph.get(d).put(d, 1.0);
            graph.get(s).put(d, values[i]);
            graph.get(d).put(s, 1/values[i]);
        }
        for (String m : graph.keySet()) {
            for (String s : graph.get(m).keySet()) {
                for (String d : graph.get(m).keySet()) {
                    double val = graph.get(s).get(m) * graph.get(m).get(d);
                    graph.get(s).put(d, val);
                }
            }
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < result.length; i++) {
            if (!graph.containsKey(queries[i][0])) result[i] = -1.0;
            else result[i] = graph.get(queries[i][0]).get(queries[i][1]) == null ? -1.0 : graph.get(queries[i][0]).get(queries[i][1]);
        }
        return result;
    }
}
