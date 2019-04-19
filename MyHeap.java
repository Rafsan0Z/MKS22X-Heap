pubic class MyHeap{

  private static void pushDown(int[]data,int size,int index){
    int pos = index;
    index = 2*(index+1);
    while(!inBounds(index)){
      int num2 = data[index];
      int num1 = data[index-1];
      if(data[pos] < num1){
        if(num1 < num2){}
      }
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
