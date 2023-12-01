package SolidPrinciple;

public class SolidPrinciplesExamples {
}

class Keyboard{

}

class Mouse{

}

 class MacBook {

    private final Keyboard keyboard;
    private final Mouse mouse;

    public MacBook(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
 }