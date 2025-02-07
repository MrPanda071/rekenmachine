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
  static JLabel Label= new JLabel("testing 123");
  static JFrame frame = new JFrame("rekenmachine");
  public static void main(String[] args) {
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        if (a !="") {
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

  public static void createbutton(ActionListener buttonListener,String displaytext , Integer gridx, Integer gridy) {
        //* create a new button */
        GridBagConstraints gbc = new GridBagConstraints();
        //* set the display text */
        JButton num = new JButton(displaytext);
        //* set the data */
        num.setPreferredSize(buttonsize);
        num.setFont(buttonfont);
        num.addActionListener(buttonListener);
        //* position the button */
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        //* add the button */
        frame.add(num, gbc);
    }
        public static void updatenumdisplay() {
        Label.setText(String.format("%s %s %s", a, op, b));
    }
}

    /*
    JLabel label = new JLabel("hoi");
    label.setBounds(150, 50 ,100 ,20);

    JLabel label1 = new JLabel("");
    label.setBounds(150, 150 ,100 ,20);

    JButton eenknop = new JButton("1");
    eenknop.setBounds(250, 100, 100, 30);

    JButton tweeknop = new JButton("2");
    tweeknop.setBounds(350, 100, 100, 30);

    JButton drieknop = new JButton("3");
    drieknop.setBounds(450, 100, 100, 30);


    JButton vierknop = new JButton("4");
    vierknop.setBounds(250, 200, 100, 30);

    JButton vijfknop = new JButton("5");
    vijfknop.setBounds(350, 200, 100, 30);

    JButton zesknop = new JButton("6");
    zesknop.setBounds(450, 200, 100, 30);


    JButton zevenknop = new JButton("7");
    zevenknop.setBounds(250, 300, 100, 30);

    JButton achtknop = new JButton("8");
    achtknop.setBounds(350, 300, 100, 30);

    JButton negenknop = new JButton("9");
    negenknop.setBounds(450, 300, 100, 30);


    JButton nulknop = new JButton("0");
    nulknop.setBounds(450, 400, 100, 30);

    JButton plusknop = new JButton("+");
    plusknop.setBounds(350, 400, 100, 30);

    JButton isknop = new JButton("=");
    isknop.setBounds(250, 400, 100, 30);

    eenknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "1";
        label.setText(b);
        }else{
        a = a +"1";
         label.setText(a);
        }
      }
    });
    tweeknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "2";
        label.setText(b);
        }else{
        a = a +"2";
         label.setText(a);
        }
      }
    });
    drieknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "3";
        label.setText(b);
        }else{
        a = a +"3";
         label.setText(a);
        }
      }
    });

        vierknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "4";
        label.setText(b);
        }else{
        a = a +"4";
         label.setText(a);
        }
      }
    });
    vijfknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "5";
        label.setText(b);
        }else{
        a = a +"5";
         label.setText(a);
        }
      }
    });
    zesknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "6";
        label.setText(b);
        }else{
        a = a +"6";
         label.setText(a);
        }
      }
    });
            zevenknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "7";
        label.setText(b);
        }else{
        a = a +"7";
         label.setText(a);
        }
      }
    });
    achtknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "8";
        label.setText(b);
        }else{
        a = a +"8";
         label.setText(a);
        }
      }
    });
    negenknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "9";
        label.setText(b);
        }else{
        a = a +"9";
         label.setText(a);
        }
      }
     });
    nulknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (toB == 1){
        b = b + "0";
        label.setText(b);
        }else{
        a = a +"0";
         label.setText(a);
        }
      }
     });

      plusknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        op = "+";
        label.setText(op); 
        toB = toB + 1;
      }
     });
      isknop.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if(toB == 1 ){
          andw = Integer.parseInt(a) + Integer.parseInt(b);
          label1.setText(String.valueOf(andw));
          label.setText(String.format("%s %s %s" ,a , op ,b));
        }
      }
     });

    frame.add(eenknop);
    frame.add(tweeknop);
    frame.add(drieknop);

    frame.add(vierknop);
    frame.add(vijfknop);
    frame.add(zesknop);

    frame.add(zevenknop);
    frame.add(achtknop);
    frame.add(negenknop);

    frame.add(nulknop);
    frame.add(plusknop);
    frame.add(isknop);

    frame.add(label);
    frame.add(label1);
    frame.setVisible(true);
  }
}*/
