import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
  static short width = 600;
  static short height = 700;
  static String a = "0";
  static String b = "0";
  static String op = "0";
  static int toB = 0;
  static int andw = 0;
  static Dimension buttonsize = new Dimension((width - 60) / 3, (height - 60) / 6);
  static Font buttonfont = new Font("Arial", Font.PLAIN, 40);
  static JLabel Label = new JLabel("testing 123");
  static JFrame frame = new JFrame("rekenmachine");

  public static void main(String[] args) {
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(width, height);

    frame.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 3;
    gbc.gridheight = 1;
    frame.add(Label, gbc);
    Label.setPreferredSize(new Dimension(width - 60, (height - 60) / 6));

    addnumbutton(1, 0, 1);
    addnumbutton(2, 1, 1);
    addnumbutton(3, 2, 1);
    addnumbutton(4, 0, 2);
    addnumbutton(5, 1, 2);
    addnumbutton(6, 2, 2);
    addnumbutton(7, 0, 3);
    addnumbutton(8, 1, 3);
    addnumbutton(9, 2, 3);
    addnumbutton(0, 0, 4);

    addopperatorbutton("+", 1, 4);
    addopperatorbutton("*", 1, 5);
    addopperatorbutton("/", 2, 5);
    addopperatorbutton("-", 2, 4);

    addcalculatebutton(0, 5);

  }

  public static void addnum(String buttonInput) {
    if (op != "" || a == "") {
      b += buttonInput;
    }
    updatenumdisplay();
  }

  public static Integer getnumber(String number) {
    if (number == "") {
      return 0;
    } else {
      return Integer.parseInt(number);
    }
  }

  public static void setoperator(String buttonInput) {
    if (a != "") {
      calculate();
    }
    op = buttonInput;
    updatenumdisplay();
  }

  public static void calculate() {
    System.out.println(String.format("%s %s %s", a, op, b));
    if (op == "*") {
      a = String.valueOf(getnumber(a) * getnumber(a));
    } else if (op == "/" && getnumber(b) != 0) {
      a = String.valueOf(getnumber(a) / getnumber(b));
    } else if (op == "+") {
      a = String.valueOf(getnumber(a) + getnumber(b));
    } else if (op == "-") {
      a = String.valueOf(getnumber(a) - getnumber(b));
    } else if (op == "" && a == "") {
      a = b;
    }
    b = "";
    op = "";
    System.out.println(String.format("result calculated: %s %s %s", a, op, b));
    updatenumdisplay();
  }

  public static void addnumbutton(Integer nummer, Integer gridx, Integer gridy) {
    ActionListener buttonListener = e -> addnum(((JButton) e.getSource()).getText());
    createbutton(buttonListener, String.valueOf(nummer), gridx, gridy);
  }

  public static void addopperatorbutton(String operator, Integer gridx, Integer gridy) {
    ActionListener buttonListener = e -> setoperator(((JButton) e.getSource()).getText());
    createbutton(buttonListener, operator, gridx, gridy);
  }

  public static void addcalculatebutton(Integer gridx, Integer gridy) {
    ActionListener buttonListener = e -> calculate();
    createbutton(buttonListener, "=", gridx, gridy);
  }

  public static void createbutton(ActionListener buttonListener, String displaytext, Integer gridx, Integer gridy) {
    // * create a new button */
    GridBagConstraints gbc = new GridBagConstraints();
    // * set the display text */
    JButton num = new JButton(displaytext);
    // * set the data */
    num.setPreferredSize(buttonsize);
    num.setFont(buttonfont);
    num.addActionListener(buttonListener);
    // * position the button */
    gbc.gridx = gridx;
    gbc.gridy = gridy;
    // * add the button */
    frame.add(num, gbc);
  }

  public static void updatenumdisplay() {
    Label.setText(String.format("%s %s %s", a, op, b));
  }
}