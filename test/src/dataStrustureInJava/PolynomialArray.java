package dataStrustureInJava;

public class PolynomialArray {
    private int[] coefficient;

    PolynomialArray() {
        this.coefficient = new int[]{0}; //직접 저장, 초기화
        //this(new int[] {0}); // 생성자 1번을 통해서 초기화
    }

    PolynomialArray(int[] myCoef) { //생성자 1번 constructor
        this.coefficient = myCoef;
    }

    public void setCofficient(int[] myCoef) { //coefficient의 getter
        this.coefficient = myCoef;
    }

    public int[] getCoefficient() { //coefficient의 setter
        return this.coefficient;
    }

    // 교차 영(zero) 항을 모두 제거
    private void eraseZero() {
        int numofzero = this.countFrontZero();
        int[] newCoefficient = new int[this.getCoefficient().length - numofzero];

        for (int i = 0; i < newCoefficient.length; ++i) {
            newCoefficient[i] = this.coefficient[i + numofzero];
        }

        this.coefficient = newCoefficient;
    }

    private boolean isZero() {
        for (int i = 0; i < this.coefficient.length; i++) {
            if (coefficient[i] == 0) {
                return false;
            }
        }

        return true;
    }

    // 개수가 영(zero)인 교차 항 갯수를 검사
    private int countFrontZero() {
        int i;

        for (i = 0; i < this.coefficient.length; i++) {
            if (coefficient[i] == 0) {
                break;
            }

        }
        return i;
    }

    public PolynomialArray neg() {  //모든 계수 부호를 반대(+ > -, - > +)로 변환
        PolynomialArray resultArray = new PolynomialArray();
//      resultArray.coefficient = new int [this.coefficient.length];

        int[] newArray = new int[this.coefficient.length];
        resultArray.setCofficient(newArray);

        for (int i = 0; i < this.coefficient.length; i++) {
            if (this.coefficient[i] != 0) {
                resultArray.coefficient[i] = -1 * this.coefficient[i];
            }
        }
        return resultArray;
    }

    public PolynomialArray add(PolynomialArray aPoly) {
        int gab = Math.abs(this.getCoefficient().length - aPoly.getCoefficient().length);

        int resultLength = Math.max(this.getCoefficient().length, aPoly.getCoefficient().length);
        int[] resultArray = new int[resultLength];

        int count;
        if (this.getCoefficient().length == aPoly.getCoefficient().length) {      // 두식이 동일한 차수
            for (count = 0; count < resultLength; ++count)
                resultArray[count] = this.coefficient[count] + aPoly.coefficient[count];
        } else if (this.getCoefficient().length > aPoly.getCoefficient().length) {   // 첫번째 차수가 크다
            for (count = 0; count < gab; ++count) resultArray[count] = this.coefficient[count];
            for (; count < resultLength; ++count)
                resultArray[count] = this.coefficient[count] + aPoly.coefficient[count - gab];
        } else if (this.getCoefficient().length < aPoly.getCoefficient().length) {   // 두번째 차수가 크다
            for (count = 0; count < gab; ++count) resultArray[count] = aPoly.coefficient[count];
            for (; count < resultLength; ++count)
                resultArray[count] = this.coefficient[count - gab] + aPoly.coefficient[count];
        }

        return new PolynomialArray(resultArray);
    }

    public PolynomialArray sub(PolynomialArray aPoly) {
        int gab = Math.abs(this.getCoefficient().length - aPoly.getCoefficient().length);
        int resultLength = Math.max(this.getCoefficient().length, aPoly.getCoefficient().length);
        int[] resultArray = new int[resultLength];

        int count;
        if (this.getCoefficient().length == aPoly.getCoefficient().length) {  // 두 식이 동일한 차수
            for (count = 0; count < resultLength; ++count)
                resultArray[count] = this.coefficient[count] - aPoly.coefficient[count];
        } else if (this.getCoefficient().length > aPoly.getCoefficient().length) {   // 첫번째 차수가 크다
            for (count = 0; count < gab; ++count) resultArray[count] = this.coefficient[count];
            for (; count < resultLength; ++count)
                resultArray[count] = this.coefficient[count] - aPoly.coefficient[count - gab];
        } else {   // 두번째 차수가 크다
            for (count = 0; count < gab; ++count) resultArray[count] = -aPoly.coefficient[count];
            for (; count < resultLength; ++count)
                resultArray[count] = this.coefficient[count - gab] - aPoly.coefficient[count];
        }

        // 모든 계수가 0인 경우를 처리
        boolean isZero = true;
        for (int coeff : resultArray) {
            if (coeff != 0) {
                isZero = false;
                break;
            }
        }

        // 만약 결과가 모두 0이면, 배열을 {0}으로 설정
        if (isZero) {
            resultArray = new int[] {0};
        }

        return new PolynomialArray(resultArray);
    }

    public PolynomialArray mul(PolynomialArray aPoly) {
        int resultLength = this.coefficient.length + aPoly.getCoefficient().length - 1;
        int[] resultArray = new int[resultLength];

        for (int i = 0; i < this.coefficient.length; i++) {
            for (int j = 0; j < aPoly.getCoefficient().length; j++) {
                resultArray[i + j] += this.coefficient[i] * aPoly.coefficient[j];
            }
        }

        return new PolynomialArray(resultArray);
    }

    public PolynomialArray differential() {
        if (this.coefficient.length == 1) {
            return new PolynomialArray(new int[]{0});  // 상수항일 경우 미분 결과는 0
        }

        int[] resultArray = new int[this.coefficient.length - 1];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = this.coefficient[i] * (this.coefficient.length - 1 - i);
        }

        return new PolynomialArray(resultArray);
    }

    public PolynomialArray integral() {
        int[] resultArray = new int[this.coefficient.length + 1];  // 적분 후 차수가 증가하므로 배열 크기를 하나 더 늘림

        for (int i = 0; i < this.coefficient.length; i++) {
            resultArray[i] = this.coefficient[i] / (this.coefficient.length - i);  // 차수에 1을 더한 값으로 나눔
        }

        resultArray[this.coefficient.length] = 0;  // 적분 상수 C, 임의로 0 설정

        return new PolynomialArray(resultArray);
    }

    /**
     * 객체를 문자열로 표시
     *
     * @return 다항식 표현 문자열
     */
    public String toString() {
        int thisDegree = this.coefficient.length - 1;

        // 모든 항이 0일 경우
        if (thisDegree == 0 && coefficient[0] == 0) {
            return "0";
        }

        StringBuilder buff = new StringBuilder();
        for (int i = 0; i <= thisDegree; i++) {
            if (this.coefficient[i] != 0) {
                if (i == thisDegree) {
                    buff.append(" + ").append(coefficient[i]);  // 상수항
                } else if (i == thisDegree - 1) {
                    buff.append(" + ").append(coefficient[i]).append("x");  // 1차항
                } else {
                    buff.append(" + ").append(coefficient[i]).append("x^").append(thisDegree - i);
                }
            }
        }

        String result = buff.toString().replace(" 1x", " x").replace("-1x", "-x");
        result = result.substring(3);  // 앞의 " + " 제거
        result = result.replace("+ -", "- ");

        return result.isEmpty() ? "0" : result;
    }
}