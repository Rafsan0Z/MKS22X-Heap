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

  }

  public static void heapify(int[]data){


  }


  public static void heapsort(int[]data){


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
    int[] test = new int[]{2,3,18,9,5,4,20,6,1,5,7,3};
    System.out.println(toString(test));
    pushDown(test,test.length,0);
    System.out.println(toString(test));
    System.out.println(Position(test,0));
  }

}
