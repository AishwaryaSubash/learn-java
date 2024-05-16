interface GUIFactory {
    Button createButton();
    TextField createTextField();
}

class LightGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public TextField createTextField() {
        return new LightTextField();
    }
}

class DarkGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public TextField createTextField() {
        return new DarkTextField();
    }
}

interface Button {
    void render();
}

class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Light Button is rendered.");
    }
}

class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Dark Button is rendered.");
    }
}

interface TextField {
    void render();
}

class LightTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Light TextField is rendered.");
    }
}

class DarkTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Dark TextField is rendered.");
    }
}

public class Client {
    private GUIFactory guiFactory;
    public Client(GUIFactory guiFactory) {
        this.guiFactory = guiFactory;
    }

    public void createUI() {
        Button button = guiFactory.createButton();
        button.render();

        TextField textField = guiFactory.createTextField();
        textField.render();
    }

    public static void main(String[] args) {
        System.out.println("Creating UI components for light theme:");
        Client lightClient = new Client(new LightGUIFactory());
        lightClient.createUI();
        System.out.println();
        System.out.println("Creating UI components for dark theme:");
        Client darkClient = new Client(new DarkGUIFactory());
        darkClient.createUI();
    }
}
