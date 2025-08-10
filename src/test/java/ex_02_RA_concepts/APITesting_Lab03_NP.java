package ex_02_RA_concepts;

public class APITesting_Lab03_NP {

    // No design pattern -> means no Builder pattern is used

    public void step1(){
        System.out.println("Step1");
    }

    public void step2(){
        System.out.println("Step2");
    }

    public void step3(String param1){
        System.out.println("Step3");
    }

    public static void main(String[] args) {
        APITesting_Lab03_NP api = new APITesting_Lab03_NP();
        api.step1();
        api.step2();
        api.step3("Pramod");
    }


}
