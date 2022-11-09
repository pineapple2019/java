package 多态;

import org.junit.Test;

public interface a {
    void aa();
}

interface b extends a{

}

class c implements b{
    @Override
    public  void aa() {
        System.out.println("111111111");
    }

    public static void main(String[] args) {
        new c().aa();

    }
}
