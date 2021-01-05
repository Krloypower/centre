package rubbish.onjava8.第十一章;

/**
 * @ClassName Sequence
 * @Description TODO
 * @Author ouyangkang
 * @Date 2020/10/19
 * @Version 1.0
 **/
public class Sequence {

    private Integer[] items;

    private int i = 0;

    public void add(Integer item){
        items[i] = item;
        i++;
    }

    public Sequence(int size){
        items = new Integer[size];
    }

    private class SequenceSelector implements Selector {

        private int j = 0;

        @Override
        public Boolean hasNext() {
            return i > j;
        }

        @Override
        public Object next() {
            return items[j++];
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }




}
