public class MyHeap{

  private static void pushDown(int[]data,int size,int index){
    int pos = index;
    index = 2*index + 1;
    while(index < size){
      int num1 = data[index];
      int max = num1;
      if(index+1<size){
        int num2 = data[index+1];
        if(num2 > num1){
          max = num2;
          index++;
        }
      }
      if(data[pos] < max){
        exchange(pos,index,data);
        pos = index;
      }
      else{
        return;
      }
      index = 2*pos + 1;
    }
  }

  private static void pushUp(int[]data,int index){
    int level = Position(index);
    while(level > 1){
      int swap = (int)Math.pow(2,level-1) - 2;
      if(data[swap] < data[index]){
      exchange(swap,index,data);
      index = swap;
      level--;
    }
    else{return;}
    }
  }

  public static void heapify(int[]data){
    int size = data.length - 1;
    int limit = Position(size);
    int level = limit-1;
    while(level > 0){
      int stop = (int)Math.pow(2,level-1) - 1;
      int start = (int)Math.pow(2,level) - 2;
      for(int i = start; i >= stop; i--){
        pushDown(data,data.length,i);
      }
      level--;
    }
  }


  public static void heapsort(int[]data){
    heapify(data);
    int pivot = data.length-1;
    while(pivot > 0){
      exchange(0,pivot,data);
      pushDown(data,pivot,0);
      pivot--;
    }
  }

  private static void exchange(int num1, int num2, int[] data){
    int temp = data[num1];
    data[num1] = data[num2];
    data[num2] = temp;
  }

  private static int Position(int index){
    if(index == 0){return 1;}
    int level = 0;
    int counter = 1;
    while(index > 0){
      level++;
      index -= counter;
      counter *= 2;
    }
    return level;
  }

  private static boolean isHeap(int[] data){}

  public static String toString(int[] ary) {
    String result = "[";
    for (int i = 0; i < ary.length ; i++) {
      result += " " + ary[i];
      if (i != ary.length - 1) {
        result += ",";
      }
    }
    return result + "]";
  }

  public static void main(String[] args){
    int[] test = new int[]{5,9,-5,-67,-45,-13,77,567,-32,-45,-213,90,34,56,76,54,-43,23,41,20,97,568,-214,0,0,0};
    System.out.println(toString(test));
    //pushDown(test,test.length,0);
    //heapify(test);
    //System.out.println(toString(test));
    //pushUp(test,3);
    heapsort(test);
    System.out.println(toString(test));
    System.out.println(HeapPrinter.toString(test));
  }

}
