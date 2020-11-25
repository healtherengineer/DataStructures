
public class Main {
 
    public static void main(String[] args) {
        
        System.out.println(frog(0,11));
    }
    
public static int frog(int fs , int pl){
    if(fs == pl){
        return 0;
    }
    else{
        return 1+ frog(fs+2 ,pl+1);
    }
    
}    
}

