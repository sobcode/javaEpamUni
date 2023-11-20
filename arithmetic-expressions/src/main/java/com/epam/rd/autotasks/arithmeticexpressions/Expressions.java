package com.epam.rd.autotasks.arithmeticexpressions;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        return new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if(value < 0){
                    return "(" + value + ")";
                }
                return String.valueOf(value);
            }
        };
    }

    public static Expression sum(Expression... members){
        return new Expression() {
            private int countSum(){
                int sum = 0;
                for(Expression i : members){
                    sum += i.evaluate();
                }
                return sum;
            }
            @Override
            public int evaluate() {
                return countSum();
            }

            @Override
            public String toExpressionString() {
                String result = "(" + members[0].toExpressionString();
                for(int i = 1; i < members.length; i++){
                    result += " + " + members[i].toExpressionString();
                }
                result += ")";
                return result;
            }
        };
    }

    public static Expression product(Expression... members){
        return new Expression() {
            private int countProd(){
                int prod = 1;
                for(Expression i : members){
                    prod *= i.evaluate();
                }
                return prod;
            }
            @Override
            public int evaluate() {
                return countProd();
            }

            @Override
            public String toExpressionString() {
                String result = "(" + members[0].toExpressionString();
                for(int i = 1; i < members.length; i++){
                    result += " * " + members[i].toExpressionString();
                }
                result += ")";
                return result;
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        return new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        return new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";
            }
        };
    }

}
