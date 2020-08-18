package rubbish.onjava8.第六章;

/**
 * @ClassName TerminationCondition
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-26 10:10
 **/
public class TerminationCondition {
    public static void main(String[] args) throws Exception {
        Book novel = new Book(true);

        novel.checkIn();

        new Book(true);
        System.gc();
        Thread.sleep(1000);
    }


}

class Book{
    private boolean checkout = false;

    public Book(boolean checkout){
        this.checkout = checkout;
    }
    void checkIn(){
        checkout = false;
    }

    public boolean getCheckout(){
        return checkout;
    }

    @Override
    protected void finalize() throws Throwable{
        if (checkout){
            System.out.println("error ");
        }else {
            System.out.println("success");
        }
    }
}
