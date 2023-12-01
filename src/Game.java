public class Game {
    private Weapon weapon;

    public Game(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void action() {
        if (this.weapon.type == "Gun") {
            System.out.println("Perform Gun attack");
        } else if (this.weapon.type == "Bomb") {
            System.out.println("Perform Bomb attack");
        }
    }
}
