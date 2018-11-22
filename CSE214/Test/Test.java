public class Test {
    public static void main(String[] args) {
        String num = " Auction ID |      Bid   |        Seller         |          Buyer          |    Time   |  Item Info";
        String[] arr = num.split("\\|");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " length: " + arr[i].length());
        }
    }
}
