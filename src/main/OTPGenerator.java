package main;

public class OTPGenerator {
    public static void main(String[] args) {
        final OTPGenerator otp = new OTPGenerator();
        for(int i=0;i<10;i++){
            System.out.println(otp.generate());
        }

    }
    //retruns string of length 4, containing 0-9
    private String generate() {
        String time = Long.toString(System.nanoTime());
        return time.substring(time.length()-4);
    }
}

