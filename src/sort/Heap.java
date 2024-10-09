package sort;

public class Heap<E extends Comparable>{
    private E[] A;
    private int numItems;

    public Heap(int arraySize){
        A = (E[])new Comparable[arraySize];
        numItems = 0;
    }

    public Heap(E[] arr){
        A = arr;
        numItems = arr.length;
    }

    public int size(){
        return this.numItems;
    }

    public E max(){
        return (E)A[0];
    }

    public void insert(E newItem){
        if(numItems <A.length){
            A[numItems] = newItem;
            percolateUp(numItems);
            numItems++;
        }
    }

    public boolean isEmpty(){
        return A.length == 0;
    }

    public E deleteMax(){
        if(!isEmpty()){
            E max = A[0];
            A[0] = A[numItems-1];
            numItems--;
            percolateDown(0);
            return max;
        }else{
            throw new RuntimeException("MAX DELETE ERROR");
        }
    }

    public void percolateUp(int i){
        int parent = (i-1) / 2;
        // A[i] 는 자식 노드
        // if A[i].compareTo(A[parent])>0 -> 자식이 부모보다 크다면 교환
        if(parent>=0 && A[i].compareTo(A[parent])>0){
            E tmp = A[i];
            A[i] = A[parent];
            A[parent] = tmp;
            percolateUp(parent);
        }
    }

    public void percolateDown(int i){
        int child = (2*i) +1;
        int rightChild = (2*i)+2;
        if(child<=numItems-1){
            if(rightChild <= numItems-1 && A[child].compareTo(A[rightChild])<0)
                // 두 자식 중에 더 큰 자식의 인덱스를 가져와
                child = rightChild;
            if(A[i].compareTo(A[child])<0){
                E tmp = A[i];
                A[i] = A[child];
                A[child] = tmp;
                percolateDown(child);
            }
        }
    }

    public void buildHeap(){
        if(numItems>=2){
            for(int i=(numItems-2)/2; i>=0; i--){
                percolateDown(i);
            }
        }
    }
}
