class Sandwich {
    private String bread;
    private String vegetables;
    private String meats;
    private String sauces;

    public Sandwich(String bread, String vegetables, String meats, String sauces) {
        this.bread = bread;
        this.vegetables = vegetables;
        this.meats = meats;
        this.sauces = sauces;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", vegetables='" + vegetables + '\'' +
                ", meats='" + meats + '\'' +
                ", sauces='" + sauces + '\'' +
                '}';
    }
}

interface SandwichBuilder {
    SandwichBuilder addBread(String bread);

    SandwichBuilder addVegetables(String vegetables);

    SandwichBuilder addMeats(String meats);

    SandwichBuilder addSauces(String sauces);

    Sandwich build();
}

class MySandwichBuilder implements SandwichBuilder {
    private String bread;
    private String vegetables;
    private String meats;
    private String sauces;

    @Override
    public SandwichBuilder addBread(String bread) {
        this.bread = bread;
        return this;
    }

    @Override
    public SandwichBuilder addVegetables(String vegetables) {
        this.vegetables = vegetables;
        return this;
    }

    @Override
    public SandwichBuilder addMeats(String meats) {
        this.meats = meats;
        return this;
    }

    @Override
    public SandwichBuilder addSauces(String sauces) {
        this.sauces = sauces;
        return this;
    }

    @Override
    public Sandwich build() {
        return new Sandwich(bread, vegetables, meats, sauces);
    }
}

class SandwichMaker {
    private SandwichBuilder sandwichBuilder;

    public SandwichMaker(SandwichBuilder sandwichBuilder) {
        this.sandwichBuilder = sandwichBuilder;
    }

    public Sandwich makeSandwich(String bread, String vegetables, String meats, String sauces) {
        return sandwichBuilder
                .addBread(bread)
                .addVegetables(vegetables)
                .addMeats(meats)
                .addSauces(sauces)
                .build();
    }

    public static void main(String[] args) {
        SandwichMaker sandwichMaker = new SandwichMaker(new MySandwichBuilder());
        Sandwich vegSandwich = sandwichMaker.makeSandwich("Whole Wheat", "Lettuce, Tomato, Onion", "", "Mayonnaise");
        System.out.println("Vegetable Sandwich: " + vegSandwich);
        Sandwich chickenSandwich = sandwichMaker.makeSandwich("Multigrain", "Lettuce, Tomato", "Grilled Chicken",
                "Barbecue Sauce");
        System.out.println("Chicken Sandwich: " + chickenSandwich);
        Sandwich clubSandwich = sandwichMaker.makeSandwich("White Bread", "Lettuce, Tomato, Bacon", "Turkey, Ham",
                "Mustard, Mayonnaise");
        System.out.println("Club Sandwich: " + clubSandwich);
    }
}
