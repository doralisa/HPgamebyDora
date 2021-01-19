package ar.com.ada.online.second.collections.HPgamebyDora;

import java.util.Objects;
import java.util.Set;

public abstract class Character {
    protected String name;
    protected char location;
    protected Integer life = 100;
    protected Integer magicEnergy = 100;
    protected Set<Spell> spellSet;

    //Constructor vacio

    public Character() {
    }

    //getter and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getLocation() {
        return location;
    }

    public void setLocation(char location) {
        this.location = location;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getMagicEnergy() {
        return magicEnergy;
    }

    public void setMagicEnergy(Integer magicEnergy) {
        this.magicEnergy = magicEnergy;
    }

    public Set<Spell> getSpellSet() {
        return spellSet;
    }

    public void setSpellSet(Set<Spell> spellSet) {
        this.spellSet = spellSet;
    }

    public Integer healYourself(Integer recovery) {
        setLife(life += recovery);
        if (life > 100) {
            life = 100;
        }
        return life; //No se si retorna o no
    }

    public void receiveAttack(Integer damage, char position) {
        if (position == getLocation()) {
            this.life = this.life - damage;
            if (this.life < 0) {
                this.life = 0;
            }
            if (isAlive()) {
                System.out.println("Enhorabuena! ha acertado tu ataque y tu oponente ha muerto!");
            } else {
                System.out.println("Enhorabuena! ha acertado tu ataque! causaste " + damage + " de daño");
            }
        } else {
            System.out.println("Oops! haz fallado, suerte para la proxima.");
        }
    }

    public Boolean isAlive() {
        return this.life <= 0;
    }

    public boolean isDarkOrFree() {
        int counter = 0;
        for (Spell spell : spellSet) {
            if (spell instanceof AttackSpell) {
                counter++;
            }
        }
        return counter > 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character that = (Character) obj;
        return location == that.location &&
                name.equals(that.name) &&
                life.equals(that.life) &&
                magicEnergy.equals(that.magicEnergy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, life, magicEnergy);
    }

    @Override
    public String toString() { //cambio de $c a %s porque sino genera error, igual en las subclases.
        return String.format(
                "Character{ name= %s, location= %s, life= %d, magicEnergy= %d, spells = %s}",
                name,
                location,
                life,
                magicEnergy,
                getSpellSet()
        );

    }

}