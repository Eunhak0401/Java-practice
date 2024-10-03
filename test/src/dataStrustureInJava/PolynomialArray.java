package dataStrustureInJava;

public class PolynomialArray {
    private int[] coefficient;

    PolynomialArray(){
        this.coefficient = new int[] {0}; //직접 저장, 초기화
        //this(new int[] {0}); // 생성자 1번을 통해서 초기화
    }
    PolynomialArray(int [] myCoef){ //생성자 1번 constructor
        this.coefficient = myCoef;
    }
    public void setCofficient(int[] myCoef){ //coefficient의 getter
        this.coefficient = myCoef;
    }
    public int [] getCofficient(){ //coefficient의 setter
        return this.coefficient;
    }

    public PolynomialArray neg(){  //모든 계수 부호를 반대(+ > -, - > +)로 변환
        PolynomialArray resultArray = new PolynomialArray();
        resultArray.coefficient = new int [this.coefficient.length];

        for (int i = 0; i < this.coefficient.length; i++) {
            if (this.coefficient[i] != 0){
                resultArray.coefficient[i] = -1 * this.coefficient[i];
            }
        }
        return resultArray;
    }

    public PolynomialArray add(PolynomialArray other) {
        int maxLength = Math.max(this.coefficient.length, other.coefficient.length);
        int[] resultCoefficients = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            int thisCoef = (i < this.coefficient.length) ? this.coefficient[i] : 0;
            int otherCoef = (i < other.coefficient.length) ? other.coefficient[i] : 0;
            resultCoefficients[i] = thisCoef + otherCoef;
        }

        return new PolynomialArray(resultCoefficients);
    }

    public PolynomialArray sub(PolynomialArray other) {
        int maxLength = Math.max(this.coefficient.length, other.coefficient.length);
        int[] resultCoefficients = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            int thisCoef = (i < this.coefficient.length) ? this.coefficient[i] : 0;
            int otherCoef = (i < other.coefficient.length) ? other.coefficient[i] : 0;
            resultCoefficients[i] = thisCoef - otherCoef;
        }

        return new PolynomialArray(resultCoefficients);
    }

    public PolynomialArray mul(PolynomialArray other) {
        int[] resultCoefficients = new int[this.coefficient.length + other.coefficient.length - 1];

        for (int i = 0; i < this.coefficient.length; i++) {
            for (int j = 0; j < other.coefficient.length; j++) {
                resultCoefficients[i + j] += this.coefficient[i] * other.coefficient[j];
            }
        }

        return new PolynomialArray(resultCoefficients);
    }

    public PolynomialArray differential() {
        if (this.coefficient.length == 1) {
            return new PolynomialArray(new int[]{0});  // 상수항일 때 결과는 0
        }

        int[] resultCoefficients = new int[this.coefficient.length - 1];
        for (int i = 0; i < resultCoefficients.length; i++) {
            resultCoefficients[i] = this.coefficient[i] * (this.coefficient.length - 1 - i);
        }

        return new PolynomialArray(resultCoefficients);
    }

    public String toString() {
        int thisDegree = this.coefficient.length - 1;

        if (thisDegree == 0)
            return "" + coefficient[0];      // 영(zero) 상수항

        String buff = "";
        for (int i = 0; i < thisDegree + 1; i++)
            if (this.coefficient[i] != 0) {
                if      (i == thisDegree)     buff += " + " + coefficient[i];         // 상수항
                else if (i == thisDegree - 1) buff += " + " + coefficient[i] + "x";      // 1차항
                else                          buff += " + " + coefficient[i] + "x^" + (thisDegree - i);
            }

        buff = buff.replace(" 1x",  " x");
        buff = buff.replace("-1x", "-x");
        buff = buff.substring(3);
        buff = buff.replace("+ -",  "- ");

        return buff;
    }
}
