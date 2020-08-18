package rubbish.onjava8.第十三章;

/**
 * @ClassName UnboundMethodReference
 * @Description TODO
 * @Author ouyangkang
 * @Date 2019-07-26 11:35
 **/
public class UnboundMethodReference {
    public static void main(String[] args) {
        X x= new X();
        MakeString makeString = ()->"sssss";

        TransformX transformX = X::f;
        transformX.transform(x);
        makeString.make();
    }
}

interface MakeString{
    String make();
}

interface TransformX{
    String transform(X x);
}

class X{
    String f(){
        return "x:f()";
    }
}