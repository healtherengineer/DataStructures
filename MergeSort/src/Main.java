
public class Main {
    public static void main(String[] args) {
        int[] givenArray = {111,23,453,12,43,2,1,120};
        MergeSort ms = new MergeSort();
         ms.print(givenArray);
        ms.sort(givenArray, 0, givenArray.length-1);
        ms.print(givenArray);
//        System.out.print("[");
//        for(int i = 0 ; i< givenArray.length ; i++){
//            System.out.print( givenArray[i] +",");
//        }
//        System.out.print("]");
//        System.out.println("");
        
    }
    
}
