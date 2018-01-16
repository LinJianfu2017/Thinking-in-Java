package com.linjianfu.chapter12;

class Annoyance extends RuntimeEx {
}

class Sneeze extends Annoyance {
}

class WrapCheckedException {
    void throwRuntimeException(int i) {
        try {
            switch (i) {
                case 0:
                    throw new Annoyance();
                case 1:
                    throw new Sneeze();
                case 2:
                    throw new RuntimeEx();
                case 3:
                    throw new RuntimeException();
                default:
                    return;
            }
        } catch (RuntimeEx e) {
            throw new RuntimeException(e);
        }
    }
}

public class Twelve30 {
    public static void main(String[] args) {
        WrapCheckedException w = new WrapCheckedException();
        for (int i = 0; i < 5; i++) {
            try {
                if (i < 4) w.throwRuntimeException(i);
                else throw new MyException();
            } catch (MyException e) {
                System.out.println("MyException: " + e);
            } catch (RuntimeException ex) {
                try {
                    throw ex.getCause();//，把getCause()包装的原始异常抛出，捕获并处理特定的异常
                } catch (Sneeze e) {
                    System.out.println("Sneeze: " + e);
                } catch (Annoyance e) {
                    System.out.println("Annoyance: " + e);
                } catch (RuntimeEx e) {
                    System.out.println("RuntimeEx: " + e);
                } catch (Throwable e) {//RuntimeException extends Exception,Exception extends Throwable.
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}
