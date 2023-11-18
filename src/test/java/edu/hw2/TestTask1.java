package edu.hw2;

import edu.hw2.Task1.Expr;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    void testConstant() {
        var two = new Expr.Constant(2);
        double ans = 2;
        assertThat(ans).isEqualTo(two.evaluate());
    }

    @Test
    void testNegate() {
        var negOne = new Expr.Negate(new Expr.Constant(1));
        double ans = -1;
        assertThat(ans).isEqualTo(negOne.evaluate());
    }

    @Test
    void testExponent() {
        var exp = new Expr.Exponent(new Expr.Constant(-2), 2);
        double ans = 4;
        assertThat(ans).isEqualTo(exp.evaluate());
    }

    @Test
    void testAddition() {
        var two = new Expr.Constant(2);
        var zero = new Expr.Constant(0);
        var sumTwoZero = new Expr.Addition(two, zero);
        double ans = 2;
        assertThat(ans).isEqualTo(sumTwoZero.evaluate());
    }

    @Test
    void testMultiplication() {
        var two = new Expr.Constant(2);
        var negSix = new Expr.Negate(new Expr.Constant(6));
        var mult = new Expr.Multiplication(two, negSix);
        double ans = -12;
        assertThat(ans).isEqualTo(mult.evaluate());
    }

    @Test
    void testAll() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));
        double ans = 37;
        assertThat(ans).isEqualTo(res.evaluate());
    }
}
