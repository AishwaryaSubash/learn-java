interface Character {
    void attack();

    void defend();
}

class Warrior implements Character {
    @Override
    public void attack() {
        System.out.println("Warrior attacks with sword.");
    }

    @Override
    public void defend() {
        System.out.println("Warrior defends with shield.");
    }
}

class Mage implements Character {
    @Override
    public void attack() {
        System.out.println("Mage casts fireball spell.");
    }

    @Override
    public void defend() {
        System.out.println("Mage creates magical barrier for defense.");
    }
}

class Archer implements Character {
    @Override
    public void attack() {
        System.out.println("Archer shoots arrows with precision.");
    }

    @Override
    public void defend() {
        System.out.println("Archer dodges attacks with agility.");
    }
}

interface CharacterFactory {
    Character createCharacter();
}

class WarriorFactory implements CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Warrior();
    }
}

class MageFactory implements CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Mage();
    }
}

class ArcherFactory implements CharacterFactory {
    @Override
    public Character createCharacter() {
        return new Archer();
    }
}

class Game {
    private CharacterFactory characterFactory;

    public Game(CharacterFactory characterFactory) {
        this.characterFactory = characterFactory;
    }

    public void play() {
        Character character = characterFactory.createCharacter();
        System.out.println("Player chooses:");
        character.attack();
        character.defend();
    }

    public static void main(String[] args) {
        CharacterFactory warriorFactory = new WarriorFactory();
        CharacterFactory mageFactory = new MageFactory();
        CharacterFactory archerFactory = new ArcherFactory();
        Game warriorGame = new Game(warriorFactory);
        Game mageGame = new Game(mageFactory);
        Game archerGame = new Game(archerFactory);
        System.out.println("Warrior Game:");
        warriorGame.play();
        System.out.println("\nMage Game:");
        mageGame.play();
        System.out.println("\nArcher Game:");
        archerGame.play();
    }
}
