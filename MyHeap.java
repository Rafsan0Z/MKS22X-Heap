public class MyHeap{

  private static void pushDown(int[]data,int size,int index){
    int pos = index;
    index = 2*index + 1;
    while(!inBounds(index)){
      int num1 = data[index];
      if(data[pos] < num1){
        if(inBounds(index+1,data)){
          int num2 = data[index+1];
          if(num1 < num2){}
        }
      }
      index = 2*index + 1;
    }
  }

  private static void pushUp(int[]data,int index){


  }

  public static void heapify(int[]data){


  }


  public static void heapsort(int[]data){


  }

  private boolean inBounds(int index, int[] data){
    return index >= data.length;
  }


}
