package school;

public class poa276 {
    static int call = 0;
    public static void main(String[] args) {
        fib(7);
        System.out.println("call = " + call);
    }

    public static int fib(int n){
        call++;
        System.out.println("n = " + n);
        if(n<=1){
            return n;
        }
        return fib(n-2)+fib(n-1);
    }
}
