import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame implements ActionListener {
    //Primary Variables
    JPanel mainPnl, controlPnl, statsPnl, resultsPnl;
    JButton rockBtn, paperBtn, scissorsBtn, quitBtn;
    JLabel pwLbl, cqLbl, tieLbl;
    JTextField pwTf, cqTf, tieTf;
    JTextArea resultsTA;
    JScrollPane scroller;
    boolean outcomeDetermined = false;
    int tieCount = 0;
    int playerWinCount = 0;

    //Computer Variables - Rock = 1, Paper = 2 Scissors = 3
    int computerWinCount = 0;
    Random rand = new Random();
    private int computerChoice() {
        return rand.nextInt(4);
    } int comCho = computerChoice();

    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);

        createControlPnl();
        createStatsPnl();
        createResultsPnl();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        do {
            if (e.getSource() == rockBtn || e.getSource() == paperBtn || e.getSource() == scissorsBtn) {
                computerChoice();
                if((comCho == 1 && e.getSource() == rockBtn) || (comCho == 2 && e.getSource() == paperBtn) || (comCho == 3 && e.getSource() == scissorsBtn)) {
                    resultsTA.append("It's a tie!\n");
                    tieCount++;
                    tieTf.setText(tieCount + "");
                    tieLbl.setText("Ties: " + tieCount);
                    computerChoice();
                    System.out.println("tie");
                } else if (comCho == 1 && e.getSource() == paperBtn) { //user paper win
                    resultsTA.append("Paper covers Rock (Player Wins)\n");
                    playerWinCount++;
                    pwTf.setText(playerWinCount + "");
                    pwLbl.setText("Player Wins: " + playerWinCount);
                    computerChoice();
                    System.out.println(playerWinCount + "P");
                } else if (comCho == 2 && e.getSource() == scissorsBtn) { //user scissors win
                    resultsTA.append("Scissors cut Paper (Player Wins)\n");
                    playerWinCount++;
                    pwTf.setText(playerWinCount + "");
                    pwLbl.setText("Player Wins: " + playerWinCount);
                    computerChoice();
                    System.out.println(playerWinCount + "S");
                } else if (comCho == 3 && e.getSource() == rockBtn) { //user rock win
                    resultsTA.append("Rock breaks Scissors (Player Wins)\n");
                    playerWinCount++;
                    pwTf.setText(playerWinCount + "");
                    pwLbl.setText("Player Wins: " + playerWinCount);
                    computerChoice();
                    System.out.println(playerWinCount + "R");
                } else if (comCho == 1 && e.getSource() == scissorsBtn) { //computer rock win
                    resultsTA.append("Rock breaks Scissors (Computer Wins)\n");
                    computerWinCount++;
                    cqTf.setText(computerWinCount + "");
                    cqLbl.setText("Computer Wins: " + computerWinCount);
                    computerChoice();
                    System.out.println(computerWinCount + "R");
                } else if (comCho == 2 && e.getSource() == rockBtn) { //computer paper win
                    resultsTA.append("Paper covers Rock (Computer Wins)\n");
                    computerWinCount++;
                    cqTf.setText(computerWinCount + "");
                    cqLbl.setText("Computer Wins: " + computerWinCount);
                    computerChoice();
                    System.out.println(computerWinCount + "P");
                } else if (comCho == 3 && e.getSource() == paperBtn) { //computer scissors win
                    resultsTA.append("Scissors cut Paper (Computer Wins)\n");
                    computerWinCount++;
                    cqTf.setText(computerWinCount + "");
                    cqLbl.setText("Computer Wins: " + computerWinCount);
                    computerChoice();
                    System.out.println(computerWinCount + "S");
                }
            } outcomeDetermined = true;
        } while(outcomeDetermined == false);
        outcomeDetermined = false;
    }

    private void createControlPnl() {
        controlPnl = new JPanel();

        rockBtn = new JButton();
        rockBtn.setPreferredSize(new Dimension(200, 200));
        rockBtn.setIcon(new ImageIcon(getClass().getResource("istockphoto-684455306-612x612.jpg")));
        rockBtn.addActionListener(this);

        paperBtn = new JButton();
        paperBtn.setPreferredSize(new Dimension(200, 200));
        paperBtn.setIcon(new ImageIcon(getClass().getResource("Paper_450x450.jpg")));
        paperBtn.addActionListener(this);

        scissorsBtn = new JButton();
        scissorsBtn.setPreferredSize(new Dimension(200, 200));
        scissorsBtn.setIcon(new ImageIcon(getClass().getResource("Pair_of_scissors_with_black_handle,_2015-06-07.jpg")));
        scissorsBtn.addActionListener(this);

        quitBtn = new JButton();
        quitBtn.setPreferredSize(new Dimension(200, 200));
        quitBtn.setIcon(new ImageIcon(getClass().getResource("quit.jpg copy.jpg")));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(rockBtn);
        controlPnl.add(paperBtn);
        controlPnl.add(scissorsBtn);
        controlPnl.add(quitBtn);
        mainPnl.add(controlPnl, BorderLayout.NORTH);
    }

    private void createStatsPnl() {
        statsPnl = new JPanel();

        pwLbl = new JLabel("Player Wins: " + playerWinCount);
        pwTf = new JTextField(3);


        statsPnl.add(pwLbl);

        cqLbl = new JLabel("Computer Wins: " + computerWinCount);
        cqTf = new JTextField(3);


        statsPnl.add(cqLbl);

        tieLbl = new JLabel("Ties: " + tieCount);
        tieTf = new JTextField(3);


        statsPnl.add(tieLbl);

        mainPnl.add(statsPnl, BorderLayout.CENTER);
    }

    private void createResultsPnl() {
        resultsPnl = new JPanel();
        resultsTA = new JTextArea(10,45);
        scroller = new JScrollPane(resultsTA);
        resultsPnl.add(scroller);
        mainPnl.add(resultsPnl, BorderLayout.SOUTH);
    }
}
