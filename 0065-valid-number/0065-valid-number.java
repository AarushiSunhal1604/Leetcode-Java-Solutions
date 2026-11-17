class Solution {
    public boolean isNumber(String s) {

        boolean digit = false;
        boolean dot = false;
        boolean exp = false;
        boolean digitAfterE = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If character is a digit
            if (ch >= '0' && ch <= '9') {
                digit = true;

                if (exp) {
                    digitAfterE = true;
                }
            }

            // If character is decimal point
            else if (ch == '.') {

                if (dot || exp) {
                    return false;
                }

                dot = true;
            }

            // If character is e or E
            else if (ch == 'e' || ch == 'E') {

                if (exp || !digit) {
                    return false;
                }

                exp = true;
                digitAfterE = false;
            }

            // If character is + or -
            else if (ch == '+' || ch == '-') {

                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {

                    return false;
                }
            }

            // Any other character is invalid
            else {
                return false;
            }
        }

        return digit && digitAfterE;
    }
}