package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double x) implements Expr {

        @Override
        public double evaluate() {
            return x;
        }

    }

    public record Negate(Expr expression) implements Expr {

        @Override
        public double evaluate() {
            return -expression.evaluate();
        }
    }

    public record Exponent(Expr expression, double power) implements Expr {

        @Override
        public double evaluate() {
            return Math.pow(expression.evaluate(), power);
        }
    }

    public record Addition(Expr x, Expr y) implements Expr {

        @Override
        public double evaluate() {
            return x.evaluate() + y.evaluate();
        }
    }

    public record Multiplication(Expr x, Expr y) implements Expr {

        @Override
        public double evaluate() {
            return x.evaluate() * y.evaluate();
        }
    }
}
