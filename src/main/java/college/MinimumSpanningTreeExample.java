package college;

class MinimumSpanningTreeExample {
  private static final int countOfVertices = 9;

  int findMinKeyVertex(int keys[], Boolean setOfMST[]) {
    // Initialize min value and its index
    int minimum_index = -1;
    int minimum_value = Integer.MAX_VALUE;
    for (int vertex = 0; vertex < countOfVertices; vertex++)
      if (setOfMST[vertex] == false && keys[vertex] < minimum_value) {
        minimum_value = keys[vertex];
        minimum_index = vertex;
      }

    return minimum_index;
  }

  void showMinimumSpanningTree(int mstArray[], int graphArray[][]) {
    System.out.println("Edge \t\t Weight");
    for (int j = 1; j < countOfVertices; j++)
      System.out.println(mstArray[j] + " <-> " + j + "\t \t" + graphArray[j][mstArray[j]]);
  }

  void designMST(int graphArray[][]) {

    int mstArray[] = new int[countOfVertices];

    int keys[] = new int[countOfVertices];

    Boolean setOfMST[] = new Boolean[countOfVertices];

    // set the value of the keys to infinite
    for (int j = 0; j < countOfVertices; j++) {
      keys[j] = Integer.MAX_VALUE;
      setOfMST[j] = false;
    }

    keys[0] = 0; // it select as first vertex
    mstArray[0] = -1; // set first value of mstArray to -1 to make it root of MST

    for (int i = 0; i < countOfVertices - 1; i++) {

      int edge = findMinKeyVertex(keys, setOfMST);

      // Add the selected minimum key vertex to the setOfMST
      setOfMST[edge] = true;

      for (int vertex = 0; vertex < countOfVertices; vertex++)
        if (graphArray[edge][vertex] != 0
            && setOfMST[vertex] == false
            && graphArray[edge][vertex] < keys[vertex]) {
          mstArray[vertex] = edge;
          keys[vertex] = graphArray[edge][vertex];
        }
    }
    // print the constructed Minimum Spanning Tree
    showMinimumSpanningTree(mstArray, graphArray);
  }

  // main() method start
  public static void main(String[] args) {

    MinimumSpanningTreeExample mst = new MinimumSpanningTreeExample();
    int graphArray[][] =
        new int[][] {
          {0, 4, 0, 0, 0, 0, 0, 8, 0},
          {4, 0, 8, 0, 0, 0, 0, 11, 0},
          {0, 8, 0, 7, 0, 4, 0, 0, 2},
          {0, 0, 7, 0, 9, 14, 0, 0, 0},
          {0, 0, 0, 9, 0, 10, 0, 0, 0},
          {0, 0, 4, 14, 10, 0, 2, 0, 0},
          {0, 0, 0, 0, 0, 2, 0, 1, 6},
          {8, 11, 0, 0, 0, 0, 1, 0, 7},
          {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
    mst.designMST(graphArray);
  }
}
