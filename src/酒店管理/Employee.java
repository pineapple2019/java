package 酒店管理;

public abstract class Employee {
   private String name;
   private int nums;
   public Employee(){}
   public Employee(String name,int nums){
       this.name = name;
       this.nums = nums;
   }
   abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }
}
