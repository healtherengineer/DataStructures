
public class MergeSort {

    public void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;
        
        int[] R = new int[n1];
        int[] L = new int[n2];
        for(int i = 0 ; i<n1 ; i++){
          L[i] = arr[l + i ]; // l = 0  0 +0 ,0+1 ,0+2 ... leftten mid e kadar gelen arrayi temp e atadım...
        }
        for(int j = 0 ; j< n2 ; j++){
            R[j] = arr[m+1+j]; // m+1 m+1+1... // m+1 den right a kadar değerli temp e atadım...
        }
        int i = 0 , j=0 ,k=l;
        while(i < n1 && j < n2 ){
            if(R[j] > L[i]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
            
        }
        while(j < n1 ){
            arr[k] = R[j];
            j++;
            k++;
        }
        while(i < n2){
            arr[k] = L[i];
            i++;
            k++;
        }
        System.out.print("-");
this.print(arr);
    }

    public void sort(int[] arr, int l, int r) {

        int m = (l + r) / 2;
        if (l < r) {
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }

    }
    public void print(int[] arr){
         System.out.print("[");
        for(int i = 0 ; i< arr.length ; i++){
            System.out.print( arr[i] +",");
        }
        System.out.print("]");
        System.out.println("");
        
    }

}
