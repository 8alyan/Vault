package labreport;

class ComplexNumber {
    int real, image;

    public ComplexNumber(int r, int i) {
        this.real = r;
        this.image = i;
    }

    public void showC() {
        System.out.print(this.real + "+" + this.image + "i");
    }

    public static ComplexNumber add(ComplexNumber n1, ComplexNumber n2) {   //ADDITION FUNCTION
        ComplexNumber res = new ComplexNumber(0, 0);
        res.real = n1.real + n2.real;
        res.image = n1.image + n2.image;
        return res;
    }

    public static ComplexNumber multiply(ComplexNumber n1, ComplexNumber n2) {
        ComplexNumber rest = new ComplexNumber(0, 0);
        rest.real = n1.real * n2.real;
        rest.image = n1.image * n2.image;
        return rest;
    }

    public static ComplexNumber difference(ComplexNumber n1, ComplexNumber n2) {
        ComplexNumber rest1 = new ComplexNumber(0, 0);
        rest1.real = n1.real - n2.real;
        rest1.image = n1.image - n2.image;
        return rest1;
    }

    public static void main(String arg[]) { // creating two complex numbers
        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber c2 = new ComplexNumber(10, 5);
        System.out.print("first Complex number: ");
        c1.showC();
        System.out.print("\nSecond Complex number: ");
        c2.showC();
        ComplexNumber res = add(c1, c2);
        ComplexNumber rest = multiply(c1, c2);
        ComplexNumber rest1 = difference(c1, c2);

        System.out.print("\nAddition is :");
        res.showC();
        System.out.print("\nMultiply is:");
        rest.showC();
        System.out.print("\nDifference is:");
        rest1.showC();
    }
}