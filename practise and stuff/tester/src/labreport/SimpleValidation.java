package labreport;

public class SimpleValidation {
    public static boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
    public static boolean validateMobile(String mobile) {
        String mobileRegex = "^(\\+\\d{1,3})?\\d{10}$";
        return mobile.matches(mobileRegex);
    }
    public static void main(String[] args) {
        String email = "example@domain.com";
        String inemail = "sahil@domain.com,,";
        String mobile = "+911234567890";
        if (validateEmail(email)) {
            System.out.println("Valid email: " + email);
        } else {
            System.out.println("Invalid email: " + email);
        }
        if (validateEmail(inemail)) {
            System.out.println("Valid email: " + inemail);
        } else {
            System.out.println("Invalid email: " + inemail);
        }
        if (validateMobile(mobile)) {
            System.out.println("Valid mobile number: " + mobile);
        } else {
            System.out.println("Invalid mobile number: " + mobile);
        }
    }
}