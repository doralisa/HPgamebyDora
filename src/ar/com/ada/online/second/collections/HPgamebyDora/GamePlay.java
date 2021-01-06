package ar.com.ada.online.second.collections.HPgamebyDora;

import java.util.*;

public class GamePlay {
    private Character playerOne;
    private Character playerTwo;
    Scanner keyboard = new Scanner(System.in);

    public void choosePlayer() {
        System.out.println("Seleccione al jugador uno: ");
        playerOne = chooseCharacter();
        System.out.println("\n");
        System.out.println("Seleccione al jugador dos: ");
        playerTwo = chooseCharacter();
    }

    private Character chooseCharacter() {
        System.out.println("Seleccione 1 si quiere jugar como un MAGO");
        System.out.println("Seleccione 2 si quiere jugar como un ELFO");
        int answer = keyboard.nextInt();
        Character character = null;
        switch (answer) {
            case 1:
                character = chooseWizard();
                break;
            case 2:
                character = chooseElf();
                break;
        }
        return character;
    }

    private Wizard chooseWizard() {
        Wizard wizard = new Wizard();
        System.out.println("Seleccione un mago de la lista: ");
        List<String> wizardsNames = Arrays.asList("Harry Potter", "Draco Malfoy", "Hermione Granger", "Albus Dumbledore", "Severus Snape");//Metodo estatico
        for (int i = 0; i < wizardsNames.size(); i++) {
            System.out.println("\t" + (i + 1) + " " + wizardsNames.get(i));
        }

        int option = keyboard.nextInt();
        switch (option) {
            case 1:
                String name1 = wizardsNames.get(0);
                wizard.setName(name1);
                break;
            case 2:
                String name2 = wizardsNames.get(1);
                wizard.setName(name2);
                break;
            case 3:
                String name3 = wizardsNames.get(2);
                wizard.setName(name3);
                break;
            case 4:
                String name4 = wizardsNames.get(3);
                wizard.setName(name4);
                break;
            case 5:
                String name5 = wizardsNames.get(4);
                wizard.setName(name5);
                break;
            default:
                System.out.println("Debe elegir una opcion valida");
                wizard = null;

        }
        Wand wand = selectionOfWand();
        wizard.setWand(wand);
        wizard.getLocation();
        wizard.setLocation(getLocation());
        return wizard;
    }

    private Elf chooseElf() {
        Elf elf = new Elf();
        System.out.println("Seleccione un Elfo de la lista: ");
        List<String> elfNames = Arrays.asList("Dobby", "Kreacher", "Hokey", "Winky");
        for (int i = 0; i < elfNames.size(); i++) {
            System.out.println("\t" + (i + 1) + " " + elfNames.get(i));
        }

        int option = keyboard.nextInt();

        switch (option) {
            case 1:
                String name1 = elfNames.get(0);
                elf.setName(name1);
                break;
            case 2:
                String name2 = elfNames.get(1);
                elf.setName(name2);
                break;
            case 3:
                String name3 = elfNames.get(2);
                elf.setName(name3);
                break;
            case 4:
                String name4 = elfNames.get(3);
                elf.setName(name4);
                break;
            default:
                System.out.println("Debe elegir una opcion valida");
                elf = null;
        }
        elf.getLocation();
        elf.setLocation(getLocation());
        return elf;
    }

    private char getLocation() { //Comente el do - while porque se metia en un loop eterno. CHECK
        char location;
        do {
            System.out.println("Seleccione su ubicacion: ");
            System.out.println("A B C");
            location = keyboard.next().charAt(0);
            if (location == 'A' || location == 'B' || location == 'C') {
                System.out.println("Usted eligio la locacion " + location);
            } else {
                System.out.println("Opcion incorrecta");
            }
        } while (location != 'A' && location != 'B' && location != 'C'); //cambio de "o" por "y" para que no se produjera bucle en el do
        return location;
    }

    public Wand selectionOfWand() {
        Wand wand = new Wand();
        Random rand = new Random(System.nanoTime());
        System.out.println("\nLa varita escoge al mago...");
        int random = rand.nextInt(7);
        int option = random;
        switch (option) {
            case 1:
                wand.setName("Varita de Sauco");
                wand.setPower(5);
                break;
            case 2:
                wand.setName("Varita de Pluma de fénix");
                wand.setPower(4);
                break;
            case 3:
                wand.setName("Varita de Fresno");
                wand.setPower(3);
                break;
            case 4:
                wand.setName("Varita de Madera de serpiente");
                wand.setPower(2);
                break;
            case 5:
                wand.setName("Varita de Abedul");
                wand.setPower(1);
                break;
            case 6:
                wand.setName("Varita de Espino");
                wand.setPower(4);
                break;
            default:
                wand.setName("Varita de Palisandro");
                wand.setPower(3);
                break;
        }
        System.out.println("\t Te ha escogido la " + wand.getName() + " que te añade " + wand.getPower() + " puntos de poder al atacar." + "\n");
        if (playerOne instanceof Wizard){
            ((Wizard) playerOne).setWand(wand);
        } else if (playerTwo instanceof Wizard){
            ((Wizard) playerTwo).setWand(wand);
        }
        return wand;
    }

    public void loadSpellCharacters() { // hacer que se continue la elección de hechizos cuando se repite de hechizos.
        System.out.println("\n\tJugador 1... Escoge 6 hechizos: \n");
        System.out.println("(No puedes repetir el mismo hechizo)");
        loadSpellByCharacters(playerOne);
        System.out.println("\n\tJugador 2... Escoge 6 hechizos: \n");
        System.out.println("(No puedes repetir el mismo hechizo)");
        loadSpellByCharacters(playerTwo);
    }

    public void loadSpellByCharacters(Character character) {
        chooseSpells(character);
        if (character.isDarkOrFree()) {
            if (character instanceof Elf) {
                System.out.println("Eres un Elfo Libre porque elegiste mas de tres hechizos de ataque! \n");
                System.out.println("Al usar un hechizo de cualquier tipo, este incrementa 5 puntos sobre lo que aporta el hechizo.");
            } else if (character instanceof Wizard) {
                System.out.println("Eres un Mago Oscuro porque elegiste mas de tres hechizos de ataque! \n");
                System.out.println(" \n Se te incrementara 10 puntos sobre lo que aporta el hechizo de ataque, pero disminuye 10 puntos en los hechizos de defensa.\n");
            }
        } else {
            if (character instanceof Wizard) {
                System.out.println("Para los magos blancos (no oscuros), al usar un hechizo de recuperación, este incrementa 10 puntos sobre lo que aporta el hechizo, solo si su nivel de vida es menor o igual a 35 puntos.\n");
            }
        }
    }

    public void chooseSpells(Character character) {
        Set<Spell> spells = new HashSet<>();
        boolean aux;
        spellFor:
        for (int i = 0; i < 6; i++) {
            do {
                aux = false;
                System.out.println("Por favor ingrese una categoria de hechizos: \n");
                System.out.println("\t1)Hechizos de Ataque\n");
                System.out.println("\t2)Hechizos de Sanacion\n");
                System.out.println("\t3)Hechizos de Recuperacion\n");
                int option = keyboard.nextInt();

                switch (option) {
                    case 1:
                        AttackSpell attackSpell = getAttackSpells(keyboard);
                        spells.add(attackSpell);
                        break;
                    case 2:
                        HealingSpell healingSpell = getHealingSpells(keyboard);
                        spells.add(healingSpell);
                        break;
                    case 3:
                        RecoverySpell recoverySpell = getRecoverySpells(keyboard);
                        spells.add(recoverySpell);
                        break;
                    default:
                        aux = true;
                        System.out.println("Opcion incorrecta.");
                }

            } while (aux);

            System.out.println("Desea agregar otro Hechizo?: \n\t1) Si\n\t2) No");
            int toBeContinue = keyboard.nextInt();
            if (toBeContinue == 2) break spellFor;
        }
        character.setSpellSet(spells); //se agrego correctamente el metodo
    }

    private AttackSpell getAttackSpells(Scanner keyboard) {
        AttackSpell spell = new AttackSpell();

        System.out.println("\nHechizos de ataque:");
        System.out.println("\t1) Avada Kedravra: \n 100pts de daño, 90pts energia magica requerida.");
        System.out.println("\t2) Imperius: \n 90pts de daño, 80pts de energia magica requerida.");
        System.out.println("\t3) Cruciatus: \n 90pts de daño, 80pts de energia magica requerida.");
        System.out.println("\t4) Expulso: \n 25pts de daño, 15pts de energia magica requerida.");
        System.out.println("\t5) Expelliarmus: \n 20pts de daño, 10pts de energia magica requerida.");
        System.out.println("\t6) Sectum: \n 15pts de daño, 8pts de energia magica requerida.");
        System.out.println("\t7) Desmaius: \n 15pts de daño, 10pts de energia magica requerida.");
        System.out.println("\t8) Petrificus totalus: \n 10 pts de daño, 5pts de energia magica requerida.");

        int option = keyboard.nextInt();
        switch (option) {
            case 1:
                spell.setName("Avada Kedravra");
                spell.setDamage(100);
                spell.setMagicPower(90);
                break;
            case 2:
                spell.setName("Imperius");
                spell.setDamage(90);
                spell.setMagicPower(80);
                break;
            case 3:
                spell.setName("Cruciatus");
                spell.setDamage(90);
                spell.setMagicPower(80);
                break;
            case 4:
                spell.setName("Expulso");
                spell.setDamage(25);
                spell.setMagicPower(15);
                break;
            case 5:
                spell.setName("Expelliarmus");
                spell.setDamage(20);
                spell.setMagicPower(10);
                break;
            case 6:
                spell.setName("Sectum");
                spell.setDamage(15);
                spell.setMagicPower(8);
                break;
            case 7:
                spell.setName("Desmaius");
                spell.setDamage(15);
                spell.setMagicPower(10);
                break;
            case 8:
                spell.setName("Petrificus totalus");
                spell.setDamage(10);
                spell.setMagicPower(5);
                break;
            default:
                System.out.println("Opcion incorrecta.");
        }
        return spell;
    }

    private HealingSpell getHealingSpells(Scanner keyboard) {
        HealingSpell spell = new HealingSpell();
        System.out.println("\nHechizos de Sanacion: ");
        System.out.println("\t1) Anapneo: \n 20pts de sanacion, 15pts energia magica requerida.");
        System.out.println("\t2) Tergeo: \n 20pts de sanacion, 15pts de energia magica requerida.");
        System.out.println("\t3) Ferula: \n 15pts de sanacion, 10pts de energia magica requerida.");
        System.out.println("\t4) Reparifors: \n 10pts de sanacion, 5pts de energia magica requerida.");
        System.out.println("\t5) Episkey: \n 5pts de sanacion, 3pts de energia magica requerida.");
        System.out.println("\t6) Vulnera Sanentur: \n 5pts de sanacion, 3pts de energia magica requerida.");
        int option = keyboard.nextInt();
        switch (option) {
            case 1:
                spell.setName("Anapneo");
                spell.setRecovery(20);
                spell.setMagicPower(15);
                break;
            case 2:
                spell.setName("Tergeo");
                spell.setRecovery(20);
                spell.setMagicPower(15);
                break;
            case 3:
                spell.setName("Ferula");
                spell.setRecovery(15);
                spell.setMagicPower(10);
                break;
            case 4:
                spell.setName("Reparifors");
                spell.setRecovery(10);
                spell.setMagicPower(5);
                break;
            case 5:
                spell.setName("Episkey");
                spell.setRecovery(5);
                spell.setMagicPower(3);
                break;
            case 6:
                spell.setName("Vulnera Sanentur");
                spell.setRecovery(5);
                spell.setMagicPower(3);
                break;
            default:
                System.out.println("Opcion incorrecta.");
        }
        return spell;
    }

    private RecoverySpell getRecoverySpells(Scanner keyboard) {
        RecoverySpell spells = new RecoverySpell();
        System.out.println("\nHechizos de Recuperacion: ");
        System.out.println("\t1) Contorsione: \n 15pts de sanacion, 8pts energia magica requerida.");
        System.out.println("\t2) Taenia: \n 15pts de sanacion, 8pts de energia magica requerida.");
        System.out.println("\t3) Ventriculum: \n 15pts de sanacion, 8pts de energia magica requerida.");
        System.out.println("\t4) Cortisem detraho: \n 15pts de sanacion, 8pts de energia magica requerida.");
        System.out.println("\t5) Enervate: \n 15pts de sanacion, 8pts de energia magica requerida.");
        System.out.println("\t6) Reparifors: \n 15pts de sanacion, 8pts de energia magica requerida.");
        int option = keyboard.nextInt();

        switch (option) {
            case 1:
                spells.setName("Contorsione");
                spells.setMagicPowerRecoverySpell(15);
                spells.setMagicPower(8);
                break;
            case 2:
                spells.setName("Taenia");
                spells.setMagicPowerRecoverySpell(15);
                spells.setMagicPower(8);
                break;
            case 3:
                spells.setName("Ventriculum");
                spells.setMagicPowerRecoverySpell(15);
                spells.setMagicPower(8);
                break;
            case 4:
                spells.setName("Cortisem detraho");
                spells.setMagicPowerRecoverySpell(15);
                spells.setMagicPower(8);
                break;
            case 5:
                spells.setName("Enervate");
                spells.setMagicPowerRecoverySpell(15);
                spells.setMagicPower(8);
                break;
            case 6:
                spells.setName("Reparifors");
                spells.setMagicPowerRecoverySpell(15);
                spells.setMagicPower(8);
                break;
            default:
                System.out.println("Opcion incorrecta.");
        }
        return spells;
    }

    public void goToFight() {
        do {
            System.out.println("Turno del jugador 1");
            turn(playerOne, playerTwo);
            if (playerTwo.isAlive()) break;

            System.out.println("Turno del jugador 2");
            turn(playerTwo, playerOne);
            if (playerOne.isAlive()) break;
        } while (true); // o (playerOne.isAlive())
    }

    public void turn(Character playerInTurn, Character opponent) {
        do {
            showStatus(playerInTurn);
            getPlayersActions(playerInTurn, opponent);
        } while (playerInTurn.isAlive());

    }

    public void getPlayersActions(Character playerInTurn, Character opponent) {
        boolean aux;
        do {
            aux = false;
            System.out.println("Que accion desea realizar?: \n");
            System.out.println("\t1)Atacar\n");
            System.out.println("\t2)Sanarse\n");
            System.out.println("\t3)Recuperarse\n");
            int option = keyboard.nextInt();

            switch (option) {
                case 1:
                    attackOpponent(playerInTurn, opponent);
                    break;
                case 2:
                    healYourself(playerInTurn);
                    break;
                case 3:
                    recoverYourself(playerInTurn);
                    break;
                default:
                    aux = true;
                    System.out.println("Opcion incorrecta.");
            }

        } while (aux);

        System.out.println("Quiere cambiar de ubicacion? \n\t 1) Si \n\t 2) No");
        int answer = keyboard.nextInt();
        if (answer == 1)
            playerInTurn.setLocation(getLocation());

    }

    private void attackOpponent(Character playerInTurn, Character opponent) {
        List<Spell> attackSpells = new ArrayList<>();
        Set<Spell> spells = playerInTurn.getSpellSet();

        for (Spell spell : spells) {
            if (spell instanceof AttackSpell)
                attackSpells.add(spell);
        }
        if (attackSpells.size() == 0) {
            System.out.println("No tiene  hechizos de Ataque\n");
        } else {
            System.out.println("Elija un hechizo: ");
            for (int i = 0; i < attackSpells.size(); i++) {
                System.out.println((i + 1) + ") " + attackSpells.get(i).getName() + " " + attackSpells.get(i).getDamage() + "  de daño, y  " + attackSpells.get(i).getMagicPower() + "   energia magica requerida.");
            }
        }

        Spell spell = null;
        int option = keyboard.nextInt();
        if (option <= attackSpells.size() + 1) {
            spell = attackSpells.get(option - 1);
        }

        System.out.println("A que posicion desea realizar el ataque? (A, B, C) ");
        char position = keyboard.next().charAt(0);
        //Esto se hace para restar la energia magica del hechizo con la energia magica del personaje
        //
        if (playerInTurn.magicEnergy < spell.getMagicPower()) {
            if (playerInTurn.magicEnergy < 0) {
                playerInTurn.magicEnergy = 0;
                System.out.println("No tienes nivel de energia magica suficiente para ejecutar este hechizo, se te añadiran 10 ptos de energia magica adicionales por esto");
                playerInTurn.magicEnergy = playerInTurn.magicEnergy + 10;
            } else {
                System.out.println("No tienes nivel de energia magica suficiente para ejecutar este hechizo, se te añadiran 10 ptos de energia magica adicionales por esto");
                playerInTurn.magicEnergy = playerInTurn.magicEnergy + 10;
            }
        } else {
            playerInTurn.magicEnergy -= spell.magicPower;
        }
        if (playerInTurn.isDarkOrFree()) {
            if (playerInTurn instanceof Wizard) {
                Wand wand = ((Wizard) playerInTurn).getWand();
                System.out.println("Se te sumaran 10 puntos a tu ataque por ser un Mago Oscuro, mas " + wand.getPower() + " puntos por tu varita " + wand.getName() + "\n");
                opponent.receiveAttack(spell.getDamage() + 10 + ((Wizard) playerInTurn).getWand().getPower(), position);
            } else { //Por si es un elfo
                System.out.println("Se te suman 5 puntos a tu ataque por ser un Elfo libre!");
                opponent.receiveAttack(spell.getDamage() + 5, position); //TODO: REVISAR ESTE METODO NO ESTA DEVOLVIENDO LO QUE DEBE
            }
        } else {
            opponent.receiveAttack(spell.getDamage(), position);
        }
    }

    private void healYourself(Character playerInTurn) {
        List<Spell> healingSpells = new ArrayList<>();
        Set<Spell> spells = playerInTurn.getSpellSet();
        int counter = 0;
        for (Spell spell : spells) {
            if (spell instanceof HealingSpell) {
                healingSpells.add(spell);
                counter++;
            }
        }

        if (counter == 0) {
            System.out.println("No tiene  hechizos de sanacion\n");
        } else {

            System.out.println("Elija un hechizo: ");
            for (int i = 0; i < healingSpells.size(); i++) {
                System.out.println((i + 1) + ") " + healingSpells.get(i).getName() + " " + healingSpells.get(i).getRecovery() + " de sanacion, y " + healingSpells.get(i).getMagicPower() + " energia magica requerida.");
            }

            //Recordar que los puntos de vida no pueden superar los 100 puntos
            Spell spell = null;
            int option = keyboard.nextInt();
            if (option <= healingSpells.size() + 1) {
                spell = healingSpells.get(option - 1);
            }
            if (playerInTurn.magicEnergy < spell.getMagicPower()) {
                if (playerInTurn.magicEnergy < 0) {
                    playerInTurn.magicEnergy = 0;
                    System.out.println("No tienes nivel de energia magica suficiente para ejecutar este hechizo, se te añadiran 10 ptos de energia magica adicionales por esto");
                    playerInTurn.magicEnergy = playerInTurn.magicEnergy + 10;
                } else {
                    System.out.println("No tienes nivel de energia magica suficiente para ejecutar este hechizo, se te añadiran 10 ptos de energia magica adicionales por esto");
                    playerInTurn.magicEnergy = playerInTurn.magicEnergy + 10;
                }
            } else {
                playerInTurn.magicEnergy -= spell.magicPower;
            }
            if (playerInTurn.isDarkOrFree()) {
                if (playerInTurn instanceof Elf) {
                    System.out.println("Se te añaden 5 puntos a este hechizo por ser un Elfo Libre");
                    playerInTurn.healYourself(spell.getMagicPower() + 5);
                }
            } else {
                playerInTurn.healYourself(spell.getMagicPower() + 5);
            }
        }
    }

    private void recoverYourself(Character playerInTurn) {
        List<Spell> recoverySpells = new ArrayList<>();
        Set<Spell> spells = playerInTurn.getSpellSet();
        int counter = 0;
        for (Spell spell : spells) {
            if (spell instanceof RecoverySpell) {
                recoverySpells.add(spell);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No tiene  hechizos de Recuperacion\n");
        } else {

            System.out.println("Elija un hechizo: ");
            for (int i = 0; i < recoverySpells.size(); i++) {
                System.out.println((i + 1) + ") " + recoverySpells.get(i).getName() + " " + recoverySpells.get(i).getRecovery() + " de sanacion, y " + recoverySpells.get(i).getMagicPower() + " energia magica requerida.");
            }
            //Recordar que los puntos de energia magica no pueden superar los 100 puntos
            Spell spell = null;
            int option = keyboard.nextInt();
            if (option <= recoverySpells.size() + 1) {
                spell = recoverySpells.get(option - 1); //SE HIZO UN CASTEO PARA QUE NO ME DE ERROR AL CAMBIAR EL TIPO DE DATO QUE ES SPELL
            }
            if (playerInTurn.magicEnergy < spell.getMagicPower()) {
                if (playerInTurn.magicEnergy < 0) {
                    playerInTurn.magicEnergy = 0;
                    System.out.println("No tienes nivel de energia magica suficiente para ejecutar este hechizo, se te añadiran 10 ptos de energia magica adicionales por esto");
                    playerInTurn.magicEnergy = playerInTurn.magicEnergy + 10;
                } else {
                    System.out.println("No tienes nivel de energia magica suficiente para ejecutar este hechizo, se te añadiran 10 ptos de energia magica adicionales por esto");
                    playerInTurn.magicEnergy = playerInTurn.magicEnergy + 10;
                }
            } else {
                playerInTurn.magicEnergy -= spell.magicPower;
            }

            if (playerInTurn.isDarkOrFree()) {
                if (playerInTurn instanceof Wizard) {
                    System.out.println("Se te restaran 10 puntos en este hechizo por ser un Mago Oscuro");
                    playerInTurn.recoverYourself(spell.getMagicPowerRecoverySpell() - 10);
                } else {//Si es Elfo Libre
                    playerInTurn.recoverYourself(spell.getMagicPowerRecoverySpell() + 5);
                }
            } else if (playerInTurn instanceof Wizard) {
                if (playerInTurn.getLife() <= 35) {
                    System.out.println("Tu nivel de vida es menor o igual a 35 pts, se sumaran 10 pts al hechizo que seleccionaste. ");
                    playerInTurn.recoverYourself(spell.getMagicPowerRecoverySpell() + 10);
                } else {
                    playerInTurn.recoverYourself(spell.getMagicPowerRecoverySpell());
                }
            } else { //Si es elfo en cautiverio
                System.out.println("Se te incrementaran 10 ptos en este hechizo");
                playerInTurn.recoverYourself(spell.getMagicPowerRecoverySpell() + 10);
            }
        }
    }

    public void showStatus(Character character) {
        System.out.println("\nPersonaje: \t" + character.getName());
        System.out.println("Vida: \t" + character.getLife());
        System.out.println("Energia magica: \t" + character.getMagicEnergy() + "\n"); //se agrego la invocación del metedod de energia magica.
    }

    public void showWinner() {
        //Muestra por pantalla el nombre del jugador que ganó
        Character winner;
        if (playerOne.isAlive()) {
            winner = playerTwo;
        } else {
            winner = playerOne;
        }
        //Character winner = playerOne.isAlive() ? playerTwo : playerOne;
        System.out.println("El ganador es " + winner.getName());
        System.out.println("\n \t Estado del jugador 1:\n");
        showStatus(playerOne);
        System.out.println("\n \t Estado del jugador 2:\n");
        showStatus(playerTwo);
    }
}
