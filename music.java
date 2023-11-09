import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


class Quiz extends JFrame implements ActionListener {
    JPanel panel;
    JRadioButton choice1;
    JRadioButton choice2;
    JRadioButton choice3;
    JRadioButton choice4;
    ButtonGroup bg;
    JLabel lblmess;
    JButton btnext;
    String[][] qpa;
    String[][] qca;
    int qaid;
    HashMap<Integer, String> map;

    Quiz() {
        initializedata();
        setTitle("Quiz Program");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(430, 350);
        setLocation(300, 100);
        setResizable(false);
        Container cont = getContentPane();
        cont.setLayout(null);
        cont.setBackground(Color.PINK);
        bg = new ButtonGroup();
        choice1 = new JRadioButton("Choice1", true);
        choice2 = new JRadioButton("Choice2", false);
        choice3 = new JRadioButton("Choice3", false);
        choice4 = new JRadioButton("Choice4", false);
        bg.add(choice1);
        bg.add(choice2);
        bg.add(choice3);
        bg.add(choice4);
        lblmess = new JLabel("Choose a correct answer");
        lblmess.setForeground(Color.BLACK);
        lblmess.setFont(new Font("Arial", Font.BOLD, 11));
        btnext = new JButton("Next");
        btnext.setForeground(Color.BLACK);
        btnext.addActionListener(this);
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLocation(10, 10);
        panel.setSize(400, 300);
        panel.setLayout(new GridLayout(6, 2));
        panel.add(lblmess);
        panel.add(choice1);
        panel.add(choice2);
        panel.add(choice3);
        panel.add(choice4);
        panel.add(btnext);
        cont.add(panel);
        setVisible(true);
        qaid = 0;
        readqa(qaid);
    }

    public void actionPerformed(ActionEvent e) {
        if (btnext.getText().equals("Next")) {
            if (qaid < 9) {
                map.put(qaid, getSelection());
                qaid++;
                readqa(qaid);
            }
            else {
                map.put(qaid, getSelection());
                btnext.setText("Show answers");
            }
        }
        else if (btnext.getText().equals("Show answers")) {
            new Report();
        }
    }

    public void initializedata() {
        //qpa stores pairs of question and its possible answers
        qpa = new String[10][5];

        qpa[0][0] = "What is the musical term for a group of notes played together?";
        qpa[0][1] = "Harmony";
        qpa[0][2] = "Melody";
        qpa[0][3] = "Rhythm";
        qpa[0][4] = "Chord";

        qpa[1][0] = "Who is often referred to as the King of Pop?";
        qpa[1][1] = "Michael Jackson";
        qpa[1][2] = "Elvis Presley";
        qpa[1][3] = "Maddonna";
        qpa[1][4] = "None of the above";

        qpa[2][0] = "Which music streaming service was founded in 2006?";
        qpa[2][1] = "Apple Music";
        qpa[2][2] = "Spotify";
        qpa[2][3] = "Prime Music";
        qpa[2][4] = "Youtube Music";

        qpa[3][0] = "Which female artist released the album \"Folklore\" in 2020?";
        qpa[3][1] = "Ariana Grande";
        qpa[3][2] = "Cardi B";
        qpa[3][3] = "Taylor Swift";
        qpa[3][4] = "Clairo";

        qpa[4][0] = "What is the stage name of the American singer Abel Tesfaye?";
        qpa[4][1] = "Eminem";
        qpa[4][2] = "Quavo";
        qpa[4][3] = "Chance";
        qpa[4][4] = "The Weeknd";

        qpa[5][0] = "In music, what does the term \"fortissimo\" (ff) indicate?";
        qpa[5][1] = "Play very softly";
        qpa[5][2] = "Play very loudly";
        qpa[5][3] = "Be silent";
        qpa[5][4] = "Play in a falsetto";

        qpa[6][0] = "Who is known for playing the electric guitar with his teeth?";
        qpa[6][1] = "John Lennon";
        qpa[6][2] = "Eric Clapton";
        qpa[6][3] = "Jimi Hendrix";
        qpa[6][4] = "None of the above";

        qpa[7][0] = "Which genre of music originated in Jamaica?";
        qpa[7][1] = "Reggae";
        qpa[7][2] = "Jazz";
        qpa[7][3] = "Pop";
        qpa[7][4] = "R&B";

        qpa[8][0] = "What is the name of the Korean boy band with songs like \"Dynamite\"?";
        qpa[8][1] = "EXO";
        qpa[8][2] = "BLACKPINK";
        qpa[8][3] = "NCT";
        qpa[8][4] = "BTS";

        qpa[9][0] = "Who won the MTV Video Music Award for Artist of the Year in 2020?";
        qpa[9][1] = "Billie Eilish";
        qpa[9][2] = "Ariana Grande";
        qpa[9][3] = "Taylor Swift";
        qpa[9][4] = "Lady Gaga";


        //qca stores pairs of question and its correct answer
        qca = new String[10][2];

        qca[0][0] = "What is the musical term for a group of notes played together?";
        qca[0][1] = "Chord";

        qca[1][0] = "Who is often referred to as the King of Pop?";
        qca[1][1] = "Michael Jackson";

        qca[2][0] = "Which music streaming service was founded in 2006?";
        qca[2][1] = "Spotify";

        qca[3][0] = "Which female artist released the album \"Folklore\" in 2020?";
        qca[3][1] = "Taylor Swift";

        qca[4][0] = "What is the stage name of the American singer Abel Tesfaye?";
        qca[4][1] = "The Weeknd";

        qca[5][0] = "In music, what does the term \"fortissimo\" (ff) indicate?";
        qca[5][1] = "Play very loudly";

        qca[6][0] = "Who is known for playing the electric guitar with his teeth?";
        qca[6][1] = "Jimi Hendrix";

        qca[7][0] = "Which genre of music originated in Jamaica?";
        qca[7][1] = "Reggae";

        qca[8][0] = "What is the name of the Korean boy band with songs like \\\"Dynamite\\\"?";
        qca[8][1] = "BTS";

        qca[9][0] = "Who won the MTV Video Music Award for Artist of the Year in 2020?";
        qca[9][1] = "Taylor Swift";


        //create a map object to store pairs of question and selected answer
        map = new HashMap<>();
    }

    public String getSelection() {
        String selectedChoice = null;
        Enumeration<AbstractButton> buttons = bg.getElements();
        while (buttons.hasMoreElements()) {
            JRadioButton temp = (JRadioButton) buttons.nextElement();
            if (temp.isSelected()) {
                selectedChoice = temp.getText();
            }
        }
        return (selectedChoice);
    }

    public void readqa(int qid) {
        lblmess.setText("  " + qpa[qid][0]);
        choice1.setText(qpa[qid][1]);
        choice2.setText(qpa[qid][2]);
        choice3.setText(qpa[qid][3]);
        choice4.setText(qpa[qid][4]);
        choice1.setSelected(true);
    }

    public void reset() {
        qaid = 0;
        map.clear();
        readqa(qaid);
        btnext.setText("Next");
    }

    public int calCorrectAnswer() {
        int qnum = 10;
        int count = 0;
        for (int qid = 0; qid < qnum; qid++) {
            if (qca[qid][1].equals(map.get(qid))) {
                count++;
            }
        }
        return count;
    }

    public class Report extends JFrame {
        Report() {
            setTitle("Answers");
            setSize(850, 550);
            setBackground(Color.GREEN);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                    reset();
                }
            });
            Draw d = new Draw();
            add(d);
            setVisible(true);
        }

	    class Draw extends Canvas {
	        public void paint(Graphics g) {
	            int qnum = 10;
	            int x = 10;
	            int y = 20;
	            for (int i = 0; i < qnum; i++) {
	                //print the 1st column
	                g.setColor(Color.BLACK);
	                g.setFont(new Font("Arial", Font.BOLD, 12));
	                g.drawString(i + 1 + ". " + qca[i][0], x, y);
	                y += 30;
	                g.setFont(new Font("Arial", Font.PLAIN, 12));
	                g.drawString("      Correct answer:" + qca[i][1], x, y);
	                y += 30;
	                g.drawString("      Your answer:" + map.get(i), x, y);
	                y += 30;
	                //print the 2nd column
	                if (y > 400) {
	                    y = 20;
	                    x = 450;
	                }
	            }
                //show number of correct answers
                int numc = calCorrectAnswer();
                g.setColor(Color.BLUE);
                g.setFont(new Font("Arial", Font.BOLD, 14));
                g.drawString("Number of correct answers:" + numc, 300, 500);
	        }
        }
    }
}


public class music{
    public static void main(String args[]) {
		new Quiz();
	}
}
