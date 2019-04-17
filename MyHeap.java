pubic class MyHeap{

  private static void pushDown(int[]data,int size,int index){
    while(!inBounds(index)){
      index = 2*(index+1);
    }

  }

  private static void pushUp(int[]data,int index){


  }

  public static void heapify(int[]){


  }


  public static void heapsort(int[]){


  }

  private boolean inBounds(int index, int[] data){
    return index >= data.length;
  }


}
