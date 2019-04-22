import java.util.*;

public class HeapPrinter {

	// call like this: HeapPrinter.print(<array>);
	// warning! large heaps will be very big and hard to read!
	// also, try to stick to 1, maybe 2 digit numbers to make it easier to read

	/*public static String toString(int[] array) {

		if (array.length == 0) return "";
		int largest = array[0];
		for (int j = 1; j < array.length; j++)
			if (Math.abs(largest) < Math.abs(array[j])) largest = array[j];

		int size = 1;
		while (size <= array.length) size <<= 1;
		int buffer = (size>>1)*(int)(Math.log(Math.abs(largest))/Math.log(10)+(largest > 0 ? 1 : 2));

		StringBuilder sb = new StringBuilder();

		int i = 0;
		for (int row = 2; row <= size; row <<= 1) {

			for (; i < row-1 && i < array.length; i++) {
				int numlength = array[i] == 0 ? 1 : (int)(Math.log(Math.abs(array[i]))/Math.log(10))+(array[i] > 0 ? 1 : 2);
				for (int j = numlength; j < buffer; j++) {
					sb.append(" ");
				}
				sb.append(array[i]);
				for (int j = 0; j < buffer; j++) sb.append(" ");
			}
			if (row != size) sb.append("\n");
			buffer = buffer>>1;
		}

		return new String(sb);
	}*/

	private static final String SPACES = "                                                                                                                                                    ";
	public static String toString(int [] arr){ //very large arrays will not work due to SPACES running out of space :o
	//as the visual representation of the tree is generated from the bottom to the top, if one of you number's suddenly has many digits you run the risk of an error being thrown
		if (arr.length == 0){return "";}
		int height = (int)(Math.log(arr.length) / Math.log(2)) + 1;
		String lastRow = ""; String edge = ""; String out = "";
		for (int i = (int)Math.pow(2,height-1) - 1; i < arr.length; i++){ //make the last row of numbers
			String space = " ";
			if (i % 2 == 1){space = "   ";}
			lastRow += arr[i] + space;
		}
		out+=lastRow;
		for (int level = height-2; level >= 0; level--){
			edge = ""; boolean first = false; // first - alternate placement
			for (int o = 0; o < lastRow.length();o++){ // make the edges
				if (o > 0  && !first&& !lastRow.substring(o-1,o).equals(" ") && lastRow.substring(o,o+1).equals(" ")){
					edge+="/"; first = true;
				}
				else if (o < lastRow.length()-1 &&first&&lastRow.substring(o,o+1).equals(" ") && !lastRow.substring(o+1,o+2).equals(" ")){
					edge += "\\ "; o++; //o is one behind the spaces
					while (o < lastRow.length() && !lastRow.substring(o,o+1).equals(" ")){edge+=" ";o++;} //o move ahead by one
					first = false; //for no odd placement
				}   //works!!!
				else{edge+=" ";}
			}
			out = edge+"\n"+out;
			lastRow = ""; //clear last row to make room for next one
			int originalLength = edge.length();
			for (int e = 0; e < (int)Math.pow(2,level); e++){ //place the numbers
				int num = arr[(int)Math.pow(2,level) - 1 + e];
				String beforeSpace = ""; String afterSpace = "";
				int firstIndex = edge.indexOf("/");
				int secondIndex = firstIndex;
				if (edge.indexOf("\\") != -1){secondIndex = edge.indexOf("\\");}
				int avg = (int) Math.round((firstIndex + secondIndex)/2.0);
				if (firstIndex != -1) {avg-= (num+"").length()/2;}
				if (firstIndex == -1){
					beforeSpace = "   ";
					afterSpace = " ";
				}
				else {
					if (avg > 0){beforeSpace = SPACES.substring(0,avg);}else {avg = 0;}
					if (secondIndex < avg){throw new IllegalArgumentException("sorry one of your numbers is too big and too far down the tree. Beats me why you would try that anyway");}
					afterSpace = SPACES.substring(0,secondIndex - avg);
				}
				String newPart = beforeSpace + num + afterSpace;
				int secondSlash = edge.indexOf("/") + edge.substring(edge.indexOf("/")+1).indexOf("/") + 1;
				if (newPart.length() > secondSlash){newPart = beforeSpace + num + " ";}
				lastRow += newPart;
				if (newPart.length() < edge.length()) {edge = edge.substring(newPart.length());}
				else {edge = "";}
			}
			out= lastRow + "\n" + out;
		}
		//System.out.println("**********************************");
		return out;
	}
	public static boolean isValidHeap(int[] data) { //checks if it is a valid heap
		for (int i = data.length - 1; i >= 0; i--){
			if (data[i] > data[(i-1)/2]){return false;}
		}
		return true;
	}

	public static void print(int[] array) {
		System.out.println(toString(array));
	}

	public static void main(String[] args){
		System.out.println(toString(new int[]{1,2,3,4,5}));
	}
}
