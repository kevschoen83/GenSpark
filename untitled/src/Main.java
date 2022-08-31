import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws Exception {

        CheckExitExample demoWindow = new CheckExitExample();
        demoWindow.setVisible(true);

//        new BoxLayoutExample();
//        new BorderLayoutExample();
//        new GridLayoutExample();
//        new FlowLayoutExample();

/*        Runnable initFrame = new Runnable() {
            @Override
            public void run() {
                new HelloFrame();
            }
        };

        SwingUtilities.invokeAndWait(initFrame);*/
    }

    // Closing Window Confirmation Dialog
    public static class CheckExitExample extends JFrame {

        public CheckExitExample() {
            setSize(300, 300);
            setTitle("Window Listener");
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new CheckOnExit());
        }

        private static class CheckOnExit extends WindowAdapter {
            public void windowClosing(WindowEvent e) {
                ConfirmWindow checker = new ConfirmWindow();
                checker.setVisible(true);
            }
        }
    }

    private static class ConfirmWindow extends JFrame implements ActionListener {

        public ConfirmWindow() {
            setSize(250, 100);
            setLayout(new BorderLayout());

            JLabel confirmLabel = new JLabel(
                    "Are you sure you want to exit?", SwingConstants.CENTER);
            add(confirmLabel, BorderLayout.CENTER);

            JLabel buttonPanel = new JLabel();
            buttonPanel.setLayout(new FlowLayout());

            JButton exitButton = new JButton("Yes");
            exitButton.addActionListener(this);
            buttonPanel.add(exitButton);

            JButton cancelButton = new JButton("No");
            cancelButton.addActionListener(this);
            buttonPanel.add(cancelButton);

            add(buttonPanel, BorderLayout.SOUTH);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            if (action.equals("Yes")) {
                System.exit(0);
            } else if (action.equals("No")) {
                dispose();
            }
        }

    }






    public static class BoxLayoutExample extends JFrame {

        public BoxLayoutExample() {
            super("Box Layout Example");

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 300);
            setLocationRelativeTo(null);

            add(new JButton("First"));
            add(new JButton("Second"));
            add(new JButton("Third"));
            add(new JButton("Fourth"));
            add(new JButton("Fifth"));

            // getContentPane() - common container for all components
            setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
            setVisible(true);
        }

    }

    public static class BorderLayoutExample extends JFrame {

        public BorderLayoutExample() {
            super("Border Layout");

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 300);
            setLocationRelativeTo(null);

            setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.add(new JButton("One"));
            panel.add(new JButton("Two"));
            add(panel, BorderLayout.NORTH);

//            add(new JButton("North"), BorderLayout.NORTH);
            add(new JButton("East"), BorderLayout.EAST);
            add(new JButton("South"), BorderLayout.SOUTH);
            add(new JButton("West"), BorderLayout.WEST);
            add(new JButton("Center"), BorderLayout.CENTER);

            setVisible(true);
        }

    }

    public static class GridLayoutExample extends JFrame {

        public GridLayoutExample() {
            super("Grid Layout Example");

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 300);
            setLocationRelativeTo(null);

            add(new JButton("First"));
            add(new JButton("Second Button"));
            add(new JTextField("Enter your text here"));
            add(new JLabel("This is a long label"));
            add(new JButton("Third"));
            add(new JLabel("This is another label"));

            setLayout(new GridLayout(3, 2, 5, 5));
            setVisible(true);
        }

    }

    public static class FlowLayoutExample extends JFrame {

        public FlowLayoutExample() {
            super("Flow Layout Example");

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 300);
            setLocationRelativeTo(null);

            add(new JButton("First"));
            add(new JButton("Second"));
            add(new JTextField("Enter your text here"));
            add(new JLabel("This is a long label"));
            add(new JButton("Third"));

            setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
            setVisible(true);
        }

    }

    public static class HelloFrame extends JFrame {

        public HelloFrame() {
            // Window
            super("Hello App");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(300, 300);
            setLocationRelativeTo(null);
            setLayout(null);

            // Text
            JLabel nameLabel = new JLabel("Your Name");
            nameLabel.setBounds(40, 20, 100, 30);
            add(nameLabel);

            // Input TextBox
            JTextField nameTextField = new JTextField();
            nameTextField.setBounds(160, 20, 100, 30);
            add(nameTextField);

            // JPanel with a label and a button
            JPanel greenPanel = new JPanel();
            greenPanel.setBounds(40, 150, 220, 70);
            greenPanel.setLayout(new BorderLayout());
            greenPanel.setBackground(Color.GREEN);
            add(greenPanel);

            JLabel helloLabel = new JLabel("Hello");
            helloLabel.setBounds(50, 20, 100, 30);
            helloLabel.setHorizontalAlignment(SwingConstants.CENTER);
            helloLabel.setVerticalAlignment(SwingConstants.CENTER);

            Font font = new Font("Courier", Font.BOLD, 12);
            helloLabel.setFont(font);
            helloLabel.setFont(helloLabel.getFont().deriveFont(16f));

            greenPanel.add(helloLabel);

            // JButton
            JButton acceptButton = new JButton("Accept");
            acceptButton.setBounds(100, 70, 100, 30);
            add(acceptButton);

            acceptButton.addActionListener(e -> {
                String helloText = "Hello";
                String name = nameTextField.getText();
                if (name != null && name.trim().length() > 0) {
                    helloText += String.format(", %s", name);
                }
                helloLabel.setText(helloText);
            });

/*            acceptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String helloText = "Hello";
                    String name = nameTextField.getText();
                    if (name != null && name.trim().length() > 0) {
                        helloText += String.format(", %s", name);
                    }
                    helloLabel.setText(helloText);
                }
            });*/

            setVisible(true);
        }
    }

}

/*class NonGenericClass {

    Object val;

    NonGenericClass(Object val) {
        this.val = val;
    }

    Object get() {
        return val;
    }

}*/

/*class GenericType<T> {
    T t;

*//*    T method(T t) {
        this.t = t;
        return t;
    }*//*

    GenericType(T t) {
        this.t = t;
    }

    T set(T t) {
        this.t = t;
        return this.t;
    }

}*/

/*        // Setup inside array
        int[] a0 = new int[]{1, 2};
        int[] a1 = new int[]{2, 3};

        //hash factor
        int p = 2;

        // Initialize hash result for inside arrays
        int hash_a0 = 0;
        int hash_a1 = 0;

        // Calculate hash by iterating through following formula:
        //    hash = hash_previous * p + element
        for (int i = 0; i < 2; i++) {
            hash_a0 = hash_a0 * p + a0[i];
            hash_a1 = hash_a1 * p + a1[i];
        }

        // Calculate hash for outside array
        int hash_b0 = 0 * p + hash_a0;
        int hash_b1 = hash_b0 * p + hash_a1;

        // Print results
        System.out.println("Inside array hash: " + "[" + hash_a0 + ", " + hash_a1 + "]");
        System.out.println("Outside array hash: " + "[" + hash_b0 + ", " + hash_b1 + "]");
        System.out.println("Hash Result (last computed value): " + hash_b1);*/

/*        NonGenericClass instance = new NonGenericClass("Hello");
        NonGenericClass instance1 = new NonGenericClass(125);

        System.out.println(instance.get());
        System.out.println(instance1.get());*/

//        List<String> collection = new ArrayList<>();

/*        collection.add("Kevin");
        collection.add("Mary");
        collection.add("Eli");

        collection.forEach(System.out::println);
        collection.removeIf(elem -> elem.startsWith("K"));
        System.out.println();
        collection.forEach(System.out::println);*/
//        LinkedList<Integer> list = new LinkedList<>(new ArrayList<>());
//        ArrayList<Integer> list = new ArrayList<>();

// *** LAMBDA EXPRESSIONS INTO ***
//        BiFunction<Integer, Integer, Integer> mult = (x, y) -> x * y;

/*        int result1 = mult.apply(5, 2);
        int result2 = mult.apply(6, 10);

        System.out.println(result1);
        System.out.println(result2);*/
