public class test {

    public static int genNum(int value, int posIni, int length){
        System.out.println("A --> " + Integer.toString(value,2));
        value = value << (32-(posIni+length));
        System.out.println("B --> " + Integer.toString(value,2));
        return value >>> (32-length);
    }

    public static void main(String[] args) {
        System.out.println("C --> " + Integer.toString(test.genNum(50,2,5),2));
    }
}
