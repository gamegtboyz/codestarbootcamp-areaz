package areaz;

class Start {
    public static void main(String[] data) {
        int[] a = { 3, 4, 8, 5, 2, 1, 7, 9, 6, 8 };
        int lo = 0, hi = a.length - 1;
        while (true) {
            if (lo >= hi) break;
            if (a[lo] % 2 == 0 && a[hi] % 2 != 0) { hi--; continue; }
            if (a[lo] % 2 != 0 && a[hi] % 2 == 0) { lo++; continue; }
            if (a[lo] % 2 != 0 && a[hi] % 2 != 0) { lo++; hi--; continue; }
            if (a[lo] % 2 == 0 && a[hi] % 2 == 0) { 
            int t = a[lo];
            a[lo] = a[hi];
            a[hi] = t;
            lo++; hi--;
            }
        }
        for (int i = 0; i <= a.length; i++) System.out.print(a[i] + " ");
    }
}

/*
class Start {
    public static void main(String[] data) {
        
        int[] a = { 6, 5, 3, 8, 5, 4, 5, 9, 7 };
        int left = 0;
        int right = a.length - 1;        
        
        
        
        // we copy this part to use in the sorting algorithm
        int pivot = 0;                  //select the first index as partition (we will rand it later)
        int lower = left + 1, upper = right;
        for (int i = left + 1; i <= upper; ) {
            // < == >
            if (a[i] < a[left]) { 
                int t = a[lower];
                a[lower] = a[i];
                a[i] = t;
                lower++;
                i++;
            }
            if (a[i] == a[left]) { i++; }
            if (a[i] > a[left]) { 
                int t = a[upper];
                a[upper] = a[i];
                a[i] = t;
                upper--;            
            }
        }
        // if found larger, move to the right
        // if found smaller, move to the left
        // swap first element to lower
        
        for (int i = left; i <= right; i++) System.out.print(a[i] + " ");
    }
}
*/

/*
    Avoid continue & break
    break = jump out of loop
    continue = get back onto previous loop
*/

/*
Rabbit and turtle, but not sorted yet
class Start {
    public static void main(String[] data) {
        int[] a = { 8, 5, 4, 6, 3, 9, 1, 2, 7, 4, 3, 5 };
        int left = 0;
        int right = a.length -1;
        
        int pivot = (int)(Math.random() * (right - left + 1));  // random if pivot point
        
        //int pivot = 8;      // selected index[8] which is equals 7 this line should be made by random
        
        //swap pivot with the first or last element
        int tmp = a[left];
        a[left] = a[pivot];
        a[pivot] = tmp;     // swap to 7 5 4 6 3 9 1 2 8 4 3 5 >> 5(index[1]) is both turtle and rabbit now. we must defined the next move ment depends on comparison (greater|lesser|equal)
                        
        
        r starts from left to right,
        if (a[R] < pivot) { }
        if (a[R] > pivot) { }
        if (a[R] == pivot) { }
        
        
        int turtle = left;
        for (int i = left + 1; i <= right; i++) {   // index[0] is pivot
            if (a[i] < a[left]) {
                // swap current selection with turtle
                turtle++;
                int glass = a[i];
                a[i] = a[turtle];
                a[turtle] = glass;                
            }   // 7 5 4 6 3 1 2 9 8 4 3 5
            
            
            if (a[i] == a[pivot]) { 
                
            }   
            
            if (a[i] > a[pivot]) { 
            
            }
            
        }
        // swap pivot position with turtle
        tmp = a[pivot];
        a[pivot] = a[turtle];
        a[turtle] = tmp;
        System.out.println("Divider is " +turtle);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
*/

/*
    Gonna rand      15 - 28
    You have ghoice 28 - 15 + 1 = 14 indexes of integer
    Standard Random Math.random(), you will get 0.0000 .... 0.9999
    convert to integer (int *5) = 0 ... 5
    if we need 3 ... 8, you must convert by (int *5 +3)
*/

/*
[Merge sort with sentinels]
class Start {
    public static void main(String[] data) {
        int[] a = {20, 15, 23, 72, 81, 35, 69, 97, 5, 48, 60};
        sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    static void sort(int[] a, int left, int right) {
        if (left == right) return; // only 1 element
        int mid = (left + right) / 2;
        sort(a, left, mid);
        sort(a, mid+1, right);
        // copy to 2 buffers, then merge back
        int[] b = new int[mid - left + 2]; //buffer 1 with sentinel and the first element
        int[] c = new int[right - mid + 1];//buffer 2 with first element
        for (int i = 0; i < b.length - 1; i++)
            b[i] = a[left + i]; // copy to the first buffer
        b[b.length-1] = Integer.MAX_VALUE;
        for (int i = 0; i < c.length - 1; i++)
            c[i] = a[mid + 1 + i]; // copy to the second buffer
        c[c.length-1] = Integer.MAX_VALUE;
        int i = 0;  // define i as index of first buffer
        int j = 0;  // define j as index of second buffer
        for (int k = left; k <= right; k++) {
            // a[k] = mininum value of b[i] and c[j]
            if (b[i] < c[j]) { // to merge each buffer together
                a[k] = b[i];
                i++;
            } else {
                a[k] = c[j];
                j++;
            }
        }
    }
}
*/

/*
import java.util.ArrayList;
class Start {
    public static void main(String[] data) {
        ArrayList[] boxes = new ArrayList[10];       //allocate 10 boxes
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new ArrayList();
        }
        int[] a = {271, 405, 972, 857, 46, 321, 512, 836, 415, 738, 691, 927};
        int digit = 0;
        boolean working = true;
        while (true) {
            for (int i = 0; i < a.length; i++) {
                int box = extract(a[i], digit);
                boxes[box].add(a[1]);
            }
            if(boxes[0].size() == a.length) { working == false; } // all data in the first box, end of loop
            int count = 0;
            for (int i = 0; i < boxes.length; i++ ) {
                for (Object o : boxes[i]) {
                    int element = (int)o;
                    a[count] = element;
                    count++;
                }
                boxes[i].clear();   // remove everything in each box
            }
            digit++;    // move onto next digit
        }
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
        
        
        System.out.println(extract(586917,0)); // 7
        System.out.println(extract(586917,1)); // 1
        System.out.println(extract(586917,2)); // 9
        System.out.println(extract(586917,3)); // 6
        System.out.println(extract(586917,4)); // 8
        System.out.println(extract(586917,5)); // 5
        System.out.println(extract(586917,6)); // 0
        System.out.println(extract(586917,7)); // 0
        
    }
    static int extract(int number, int digit) {
        int right = number % 10;
        for (int i = 0; i < digit; i++) {
            number = number / 10;       //reduce
            right = number % 10;    //right most
        }
        return right;
    }
}
*/

/*
[[Greedy sort]]
class Start {
    public static void main(String[] data) {
        int[] a = {5, 8, 3, 1, 2, 7, 3};
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
            System.out.println();
            
            int best = 0;   //let the first element become best
            for (int j = 1; j <= i; j++) {
                if (a[j] > a[best]) {
                    best = j;
                }
            }
            // interchange a[best] and a[i]
            int tmp = a[i];
            a[i] = a[best];
            a[best] = tmp;
        }
    }
}
*/

/*
[[Find the largest branch]]
package areaz;

class Start {
    public static void main(String[] data) {
        Branch[] a = {new Branch("Siam Square", 45.30),
            new Branch("Rangsit", 75.80),
            new Branch("Bangyai", 120.00),
            new Branch("Bangna", 100)};
        
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].name);
        }
        
        
        int best = 0;                       // assume that the first element is the largest
        for (int i = 0; i < a.length; i++) {
            if (a[i].area > a[best].area) {
                best = i;
            }
        }
        System.out.print(a[best].name);     // this one is to print the largest branch
    }
}

class Branch {
    Branch(String s, double a) {
        name = s;
        area = a;
    }
    String name;
    double area;
}
*/