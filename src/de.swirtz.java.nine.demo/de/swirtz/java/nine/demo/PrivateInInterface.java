package de.swirtz.java.nine.demo;


public interface PrivateInInterface {

    boolean isJava9();

    default boolean isJava8() {
        return getVersion().equals("1.8");
    }

    private String getVersion() {
        return "1.9";
    }

}

class Impl implements PrivateInInterface {

    @Override
    public boolean isJava9() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Impl().isJava8());
    }

}