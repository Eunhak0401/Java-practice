public class Gisafirst {
    public static void main(String[] args) {
        Gisafirst gt = new Gisafirst();
        gt.cat();
        gt.cat("2");
    }
    public void cat(){
        System.out.println("1234");
    }
    public void cat(int c){
        System.out.print(c++);
    }
    public void cat(String c){
        System.out.println("문자");
    }
}

