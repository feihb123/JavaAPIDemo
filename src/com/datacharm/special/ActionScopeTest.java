package com.datacharm.special;

class ActionScope {
    private static int var1=1;
    static int  var2=2;
    protected static int var3=3;
    public  static int var4=4;
}

class Action extends ActionScope{
    public int var5=5;
    //若在外部包且类为public，可以访问var3,var4
}

public class ActionScopeTest {
    public static void main(String[] args) {
        //private只能定义类中访问
        //defalut 能在本包类访问，外包不可访问
        //protected 能在子类及本包中类可以访问
        //即相比默认还可以在外部包的子类中访问
        //public 所有类可以访问
        System.out.println(ActionScope.var2+ActionScope.var3+ActionScope.var4);
    }

}
