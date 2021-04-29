package test;

public class Test extends Test1{
    @Override
    public void animal() {
        super.animal();
        System.out.println("我是猫");
    }



    public static void main(String[] args) {
        try{
            int[] a = new int[2];
            a[2] = 1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("请修改数组下标");
        }
    }
}

