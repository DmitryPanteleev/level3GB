package lesson1;

public class Task1<T> {

    private T[] obj;
    private T[] obj2;
    private int item1;
    private int item2;

    public Task1(T[] obj, int item1, int item2)throws Exception {
        this.obj = obj;
        if (item1 < obj.length)this.item1 = item1;else throw new Exception("число больше длины массива");
        if (item2 < obj.length)this.item2 = item2;else throw new Exception("число больше длины массива");
        replasement();
    }

    private void replasement(){
        obj2 = obj.clone();
        obj[item1] = obj[item2];
        obj[item2] = obj2[item1];

        for (Object o :
                obj) {
            System.out.println(o);
        }
    }


}
