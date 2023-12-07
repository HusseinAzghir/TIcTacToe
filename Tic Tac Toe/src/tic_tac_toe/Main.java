
package tic_tac_toe;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    JPanel startPage;
    JButton startPage_singlePlayer;
    JButton startPage_multiPlayer;
    JButton startPage_settings;
    JButton startPage_about;
    JButton startPage_exit;

    JPanel singlePlayerPage;
    JLabel singlePlayerPage_label;
    JTextField singlePlayerPage_playerName;
    JButton singlePlayerPage_start;
    JButton singlePlayerPage_back;

    JPanel multiPlayerPage;
    JLabel multiPlayerPage_firstLabel;
    JLabel multiPlayerPage_secondLabel;
    JTextField multiPlayerPage_firstPlayerName;
    JTextField multiPlayerPage_secondPlayerName;
    JButton multiPlayerPage_start;
    JButton multiPlayerPage_back;

    JPanel settingsPage;
    JLabel settingsPage_selectedBoardLabel;
    JComboBox settingsPage_selectedBoardValue;
    JLabel settingsPage_selectedFontSizeLabel;
    JComboBox settingsPage_selectedFontSizeValue;
    JButton settingsPage_reset;
    JButton settingsPage_back;

    JPanel gamePage;
    JPanel gamePage_boardPanel;
    JLabel[] gamePage_boardLabels;
    JLabel gamePage_boardBackground;
    JLabel gamePage_firstPlayerName;
    JLabel gamePage_secondPlayerName;
    JLabel gamePage_firstPlayerScore;
    JLabel gamePage_secondPlayerScore;
    JLabel gamePage_currentPlayerIcon;
    JButton gamePage_back;
    JButton gamePage_restart;

    Font defaultFont = new Font("Arial", Font.BOLD, 16);
    Color defaultButtonBackgroundColor = Color.lightGray;
    Color defaultButtonTextColor = Color.black;
    Color xForeground = Color.blue;
    Color oForeground = Color.red;
    Color winnerSquaresBackground = Color.yellow;

    boolean challengeComputer = false;

    // سنستخدم هذا المتغير لتحديد دور من في اللعب
    boolean isFirstPlayerTurn = true;

    int XOCounter = 0;

    boolean isGameEnds = false;

    Random random = new Random();
    int randomNumber;


    private void setNewFont(Font font) {

        startPage_singlePlayer.setFont(font);
        startPage_multiPlayer.setFont(font);
        startPage_settings.setFont(font);
        startPage_about.setFont(font);
        startPage_exit.setFont(font);
        singlePlayerPage_label.setFont(font);
        singlePlayerPage_playerName.setFont(font);
        singlePlayerPage_start.setFont(font);
        singlePlayerPage_back.setFont(font);
        multiPlayerPage_firstLabel.setFont(font);
        multiPlayerPage_secondLabel.setFont(font);
        multiPlayerPage_firstPlayerName.setFont(font);
        multiPlayerPage_secondPlayerName.setFont(font);
        multiPlayerPage_start.setFont(font);
        multiPlayerPage_back.setFont(font);
        settingsPage_selectedBoardLabel.setFont(font);
        settingsPage_selectedBoardValue.setFont(font);
        settingsPage_selectedFontSizeLabel.setFont(font);
        settingsPage_selectedFontSizeValue.setFont(font);
        settingsPage_reset.setFont(font);
        settingsPage_back.setFont(font);
        gamePage_boardPanel.setFont(font);
        gamePage_firstPlayerName.setFont(font);
        gamePage_secondPlayerName.setFont(font);
        gamePage_firstPlayerScore.setFont(font);
        gamePage_secondPlayerScore.setFont(font);
        gamePage_back.setFont(font);
        gamePage_restart.setFont(font);

    }


    private void setThemeColors(Color textColor, Color backgroundColor) {

        startPage_singlePlayer.setForeground(textColor);
        startPage_multiPlayer.setForeground(textColor);
        startPage_settings.setForeground(textColor);
        startPage_about.setForeground(textColor);
        startPage_exit.setForeground(textColor);
        startPage_singlePlayer.setBackground(backgroundColor);
        startPage_multiPlayer.setBackground(backgroundColor);
        startPage_settings.setBackground(backgroundColor);
        startPage_about.setBackground(backgroundColor);
        startPage_exit.setBackground(backgroundColor);

        singlePlayerPage_label.setForeground(textColor);
        singlePlayerPage_playerName.setForeground(textColor);
        singlePlayerPage_start.setForeground(textColor);
        singlePlayerPage_back.setForeground(textColor);
        singlePlayerPage_start.setBackground(backgroundColor);
        singlePlayerPage_back.setBackground(backgroundColor);

        multiPlayerPage_firstLabel.setForeground(textColor);
        multiPlayerPage_firstPlayerName.setForeground(textColor);
        multiPlayerPage_secondLabel.setForeground(textColor);
        multiPlayerPage_secondPlayerName.setForeground(textColor);
        multiPlayerPage_start.setForeground(textColor);
        multiPlayerPage_back.setForeground(textColor);
        multiPlayerPage_start.setBackground(backgroundColor);
        multiPlayerPage_back.setBackground(backgroundColor);

        gamePage_firstPlayerName.setForeground(textColor);
        gamePage_secondPlayerName.setForeground(textColor);
        gamePage_firstPlayerScore.setForeground(textColor);
        gamePage_secondPlayerScore.setForeground(textColor);
        gamePage_back.setForeground(textColor);
        gamePage_restart.setForeground(textColor);
        gamePage_restart.setBackground(backgroundColor);
        gamePage_back.setBackground(backgroundColor);

        settingsPage_selectedBoardLabel.setForeground(textColor);
        settingsPage_selectedBoardValue.setForeground(textColor);
        settingsPage_selectedFontSizeLabel.setForeground(textColor);
        settingsPage_selectedFontSizeValue.setForeground(textColor);
        settingsPage_reset.setForeground(textColor);
        settingsPage_back.setForeground(textColor);
        settingsPage_reset.setBackground(backgroundColor);
        settingsPage_back.setBackground(backgroundColor);

    }


    private void createStartPage() {

        startPage = new JPanel(null);
        startPage_singlePlayer = new JButton("Single Spieler");
        startPage_multiPlayer = new JButton("Multi Spieler");
        startPage_settings = new JButton("Einstellung");
        startPage_about = new JButton("About");
        startPage_exit = new JButton("Exit");

        startPage.add(startPage_singlePlayer);
        startPage.add(startPage_multiPlayer);
        startPage.add(startPage_settings);
        startPage.add(startPage_about);
        startPage.add(startPage_exit);

        startPage_singlePlayer.setBounds(80, 110, 240, 40);
        startPage_multiPlayer.setBounds(80, 170, 240, 40);
        startPage_settings.setBounds(80, 230, 240, 40);
        startPage_about.setBounds(80, 290, 240, 40);
        startPage_exit.setBounds(80, 350, 240, 40);

    }


    private void createSinglePlayerPage() {

        singlePlayerPage = new JPanel(null);
        singlePlayerPage_label = new JLabel("Spieler Name");
        singlePlayerPage_playerName = new JTextField("Spieler");
        singlePlayerPage_start = new JButton("Start");
        singlePlayerPage_back = new JButton("zurück");

        singlePlayerPage.add(singlePlayerPage_label);
        singlePlayerPage.add(singlePlayerPage_playerName);
        singlePlayerPage.add(singlePlayerPage_start);
        singlePlayerPage.add(singlePlayerPage_back);


        singlePlayerPage_label.setBounds(80, 170, 100, 30);
        singlePlayerPage_playerName.setBounds(190, 170, 130, 30);
        singlePlayerPage_start.setBounds(80, 220, 240, 40);
        singlePlayerPage_back.setBounds(80, 280, 240, 40);

    }


    private void createMultiPlayerPage() {


        multiPlayerPage = new JPanel(null);
        multiPlayerPage_firstLabel = new JLabel("Spieler X");
        multiPlayerPage_secondLabel = new JLabel("Spieler O");
        multiPlayerPage_firstPlayerName = new JTextField("Spieler 1", 8);
        multiPlayerPage_secondPlayerName = new JTextField("Spieler 2", 8);
        multiPlayerPage_start = new JButton("Start");
        multiPlayerPage_back = new JButton("zurück");

        multiPlayerPage.add(multiPlayerPage_firstLabel);
        multiPlayerPage.add(multiPlayerPage_secondLabel);
        multiPlayerPage.add(multiPlayerPage_firstPlayerName);
        multiPlayerPage.add(multiPlayerPage_secondPlayerName);
        multiPlayerPage.add(multiPlayerPage_start);
        multiPlayerPage.add(multiPlayerPage_back);

        multiPlayerPage_firstLabel.setBounds(80, 130, 70, 30);
        multiPlayerPage_firstPlayerName.setBounds(160, 130, 160, 30);
        multiPlayerPage_secondLabel.setBounds(80, 190, 70, 30);
        multiPlayerPage_secondPlayerName.setBounds(160, 190, 160, 30);
        multiPlayerPage_start.setBounds(80, 250, 240, 40);
        multiPlayerPage_back.setBounds(80, 310, 240, 40);

    }


    private void createSettingsPage() {

        settingsPage = new JPanel(null);
        settingsPage_selectedBoardLabel = new JLabel("Spiel Board");
        settingsPage_selectedBoardValue = new JComboBox(new String[]{"Board 1", "Board 2", "Board 3", "Board 4"});
        settingsPage_selectedFontSizeLabel = new JLabel("Font Size");
        settingsPage_selectedFontSizeValue = new JComboBox(new String[]{"Small", "Meduim", "Large"});
        settingsPage_selectedFontSizeValue.setSelectedIndex(1);
        settingsPage_reset = new JButton("Standardeinstellungen zurücksetzen");
        settingsPage_back = new JButton("zurück");

        settingsPage.add(settingsPage_selectedBoardLabel);
        settingsPage.add(settingsPage_selectedBoardValue);
        settingsPage.add(settingsPage_selectedFontSizeLabel);
        settingsPage.add(settingsPage_selectedFontSizeValue);
        settingsPage.add(settingsPage_reset);
        settingsPage.add(settingsPage_back);

        settingsPage_selectedBoardLabel.setBounds(80, 130, 100, 30);
        settingsPage_selectedBoardValue.setBounds(200, 130, 120, 30);
        settingsPage_selectedFontSizeLabel.setBounds(80, 190, 100, 30);
        settingsPage_selectedFontSizeValue.setBounds(200, 190, 120, 30);
        settingsPage_reset.setBounds(80, 250, 240, 40);
        settingsPage_back.setBounds(80, 310, 240, 40);

    }



    private void createGamePage() {


        gamePage = new JPanel(null);
        gamePage_firstPlayerName = new JLabel("", JLabel.CENTER);
        gamePage_secondPlayerName = new JLabel("", JLabel.CENTER);
        gamePage_firstPlayerScore = new JLabel("0", JLabel.CENTER);
        gamePage_secondPlayerScore = new JLabel("0", JLabel.CENTER);
        gamePage_currentPlayerIcon = new JLabel("", JLabel.CENTER);
        gamePage_boardPanel = new JPanel(new GridLayout(3, 3, 8, 8));
        gamePage_boardLabels = new JLabel[9];
        gamePage_back = new JButton("zurück");
        gamePage_restart = new JButton("Neu starten");
        gamePage_boardBackground = new JLabel();

        gamePage_boardBackground.setIcon(new ImageIcon(this.getClass().getResource("../images/board_1.png")));


        for (int i = 0; i < gamePage_boardLabels.length; i++) {
            gamePage_boardLabels[i] = new JLabel("", JLabel.CENTER);
            gamePage_boardLabels[i].setFont(new Font("Arial", Font.BOLD, 40));
            gamePage_boardLabels[i].setBackground(winnerSquaresBackground);
            gamePage_boardPanel.add(gamePage_boardLabels[i]);
        }


        setCurrentPlayerIcon();

        gamePage.add(gamePage_firstPlayerName);
        gamePage.add(gamePage_secondPlayerName);
        gamePage.add(gamePage_firstPlayerScore);
        gamePage.add(gamePage_secondPlayerScore);
        gamePage.add(gamePage_currentPlayerIcon);
        gamePage.add(gamePage_boardBackground);
        gamePage.add(gamePage_boardPanel);
        gamePage.add(gamePage_back);
        gamePage.add(gamePage_restart);

        gamePage_firstPlayerName.setBounds(0, 10, 150, 30);
        gamePage_secondPlayerName.setBounds(250, 10, 150, 30);
        gamePage_firstPlayerScore.setBounds(0, 40, 150, 30);
        gamePage_secondPlayerScore.setBounds(250, 40, 150, 30);
        gamePage_currentPlayerIcon.setBounds(120, 25, 150, 30);
        gamePage_boardBackground.setBounds(45, 105, 300, 300);
        gamePage_boardPanel.setBounds(45, 105, 300, 300);
        gamePage_back.setBounds(20, 475, 140, 30);
        gamePage_restart.setBounds(230, 475, 140, 30);

    }


    private void colorBackgroundWinnerLabels(JLabel l1, JLabel l2, JLabel l3) {
        l1.setOpaque(true);
        l2.setOpaque(true);
        l3.setOpaque(true);
        isGameEnds = true;
    }

    private void checkIfThereIsAWinner() {

        String c0 = gamePage_boardLabels[0].getText();
        String c1 = gamePage_boardLabels[1].getText();
        String c2 = gamePage_boardLabels[2].getText();
        String c3 = gamePage_boardLabels[3].getText();
        String c4 = gamePage_boardLabels[4].getText();
        String c5 = gamePage_boardLabels[5].getText();
        String c6 = gamePage_boardLabels[6].getText();
        String c7 = gamePage_boardLabels[7].getText();
        String c8 = gamePage_boardLabels[8].getText();

        int firstPlayerScore = Integer.valueOf(gamePage_firstPlayerScore.getText());
        int secondPlayerScore = Integer.valueOf(gamePage_secondPlayerScore.getText());

        if (c0.equals(c1) && c0.equals(c2) && !c0.equals("")) {
            if (c0.equals("X"))
                gamePage_firstPlayerScore.setText((firstPlayerScore+1)+"");
            else
                gamePage_secondPlayerScore.setText((secondPlayerScore+1)+"");
            colorBackgroundWinnerLabels(gamePage_boardLabels[0], gamePage_boardLabels[1], gamePage_boardLabels[2]);
        }

        if (c3.equals(c4) && c3.equals(c5) && !c3.equals("")) {
            if (c3.equals("X"))
                gamePage_firstPlayerScore.setText((firstPlayerScore+1)+"");
            else
                gamePage_secondPlayerScore.setText((secondPlayerScore+1)+"");
            colorBackgroundWinnerLabels(gamePage_boardLabels[3], gamePage_boardLabels[4], gamePage_boardLabels[5]);
        }

        if (c6.equals(c7) && c6.equals(c8) && !c6.equals("")) {
            if (c6.equals("X"))
                gamePage_firstPlayerScore.setText((firstPlayerScore+1)+"");
            else
                gamePage_secondPlayerScore.setText((secondPlayerScore+1)+"");
            colorBackgroundWinnerLabels(gamePage_boardLabels[6], gamePage_boardLabels[7], gamePage_boardLabels[8]);
        }

        if (c0.equals(c3) && c0.equals(c6) && !c0.equals("")) {
            if (c0.equals("X"))
                gamePage_firstPlayerScore.setText((firstPlayerScore+1)+"");
            else
                gamePage_secondPlayerScore.setText((secondPlayerScore+1)+"");
            colorBackgroundWinnerLabels(gamePage_boardLabels[0], gamePage_boardLabels[3], gamePage_boardLabels[6]);
        }

        if (c1.equals(c4) && c1.equals(c7) && !c1.equals("")) {
            if (c1.equals("X"))
                gamePage_firstPlayerScore.setText((firstPlayerScore+1)+"");
            else
                gamePage_secondPlayerScore.setText((secondPlayerScore+1)+"");
            colorBackgroundWinnerLabels(gamePage_boardLabels[1], gamePage_boardLabels[4], gamePage_boardLabels[7]);
        }

        if (c2.equals(c5) && c2.equals(c8) && !c2.equals("")) {
            if (c2.equals("X"))
                gamePage_firstPlayerScore.setText((firstPlayerScore+1)+"");
            else
                gamePage_secondPlayerScore.setText((secondPlayerScore+1)+"");
            colorBackgroundWinnerLabels(gamePage_boardLabels[2], gamePage_boardLabels[5], gamePage_boardLabels[8]);
        }

        if (c0.equals(c4) && c0.equals(c8) && !c0.equals("")) {
            if (c0.equals("X"))
                gamePage_firstPlayerScore.setText((firstPlayerScore+1)+"");
            else
                gamePage_secondPlayerScore.setText((secondPlayerScore+1)+"");
            colorBackgroundWinnerLabels(gamePage_boardLabels[0], gamePage_boardLabels[4], gamePage_boardLabels[8]);
        }

        if (c2.equals(c4) && c2.equals(c6) && !c2.equals("")) {
            if (c2.equals("X"))
                gamePage_firstPlayerScore.setText((firstPlayerScore+1)+"");
            else
                gamePage_secondPlayerScore.setText((secondPlayerScore+1)+"");
            colorBackgroundWinnerLabels(gamePage_boardLabels[2], gamePage_boardLabels[4], gamePage_boardLabels[6]);
        }

        gamePage.repaint();
    }


    private boolean isTowPlayerGameEnds(JLabel pressedLabel) {

        if (pressedLabel.getText().equals("")) {

            if (isFirstPlayerTurn == true) {
                pressedLabel.setText("X");
                pressedLabel.setForeground(xForeground);
                isFirstPlayerTurn = false;
            } else {
                pressedLabel.setText("O");
                pressedLabel.setForeground(oForeground);
                isFirstPlayerTurn = true;
            }

            gamePage.repaint();
            checkIfThereIsAWinner();

            XOCounter++;

            if (XOCounter == 9 || isGameEnds == true) {
                removeXOListener();
                XOCounter = 0;
            }
        }

        return isGameEnds;
    }


    private boolean isOnePlayerGameEnds(JLabel pressedLabel) {

        if (XOCounter < 9 && pressedLabel.getText().equals("")) {

            pressedLabel.setText("X");
            pressedLabel.setForeground(xForeground);

            XOCounter++;

            repaint();
            checkIfThereIsAWinner();

            if (XOCounter < 9 && isGameEnds == false) {
                for (;;) {
                    randomNumber = random.nextInt(9);
                    if (gamePage_boardLabels[randomNumber].getText().equals("")) {

                        gamePage_boardLabels[randomNumber].setText("O");
                        gamePage_boardLabels[randomNumber].setForeground(oForeground);

                        gamePage.repaint();

                        XOCounter++;
                        checkIfThereIsAWinner();
                        break;
                    }
                }
            }

        }

        if (XOCounter >= 9 || isGameEnds == true) {
            removeXOListener();
            repaint();
            return true;
        }

        return false;

    }

    private void removeXOListener() {
        for (JLabel gamePage_boardLabel : gamePage_boardLabels) {
            gamePage_boardLabel.removeMouseListener(XOListener);
        }
    }

    private void setCurrentPlayerIcon() {
        if (isFirstPlayerTurn == true) {
            gamePage_currentPlayerIcon.setText("X");
            gamePage_currentPlayerIcon.setForeground(xForeground);
        }
        else {
            gamePage_currentPlayerIcon.setText("O");
            gamePage_currentPlayerIcon.setForeground(oForeground);
        }
        repaint();
    }


    MouseListener XOListener = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel pressedLabel = (JLabel) e.getSource();
            if (isGameEnds == false) {
                if (challengeComputer == true)
                    isOnePlayerGameEnds(pressedLabel);
                else if (challengeComputer == false)
                    isTowPlayerGameEnds(pressedLabel);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    };


    private void startNewGame() {

        isGameEnds = false;
        XOCounter = 0;

        setCurrentPlayerIcon();

        gamePage_boardLabels[0].setOpaque(false);
        gamePage_boardLabels[1].setOpaque(false);
        gamePage_boardLabels[2].setOpaque(false);
        gamePage_boardLabels[3].setOpaque(false);
        gamePage_boardLabels[4].setOpaque(false);
        gamePage_boardLabels[5].setOpaque(false);
        gamePage_boardLabels[6].setOpaque(false);
        gamePage_boardLabels[7].setOpaque(false);
        gamePage_boardLabels[8].setOpaque(false);

        gamePage_boardLabels[0].setText("");
        gamePage_boardLabels[1].setText("");
        gamePage_boardLabels[2].setText("");
        gamePage_boardLabels[3].setText("");
        gamePage_boardLabels[4].setText("");
        gamePage_boardLabels[5].setText("");
        gamePage_boardLabels[6].setText("");
        gamePage_boardLabels[7].setText("");
        gamePage_boardLabels[8].setText("");

        repaint();

        gamePage_boardLabels[0].addMouseListener(XOListener);
        gamePage_boardLabels[1].addMouseListener(XOListener);
        gamePage_boardLabels[2].addMouseListener(XOListener);
        gamePage_boardLabels[3].addMouseListener(XOListener);
        gamePage_boardLabels[4].addMouseListener(XOListener);
        gamePage_boardLabels[5].addMouseListener(XOListener);
        gamePage_boardLabels[6].addMouseListener(XOListener);
        gamePage_boardLabels[7].addMouseListener(XOListener);
        gamePage_boardLabels[8].addMouseListener(XOListener);

    }


    public Main() {
        createAndShowGUI();
    }


    private void createAndShowGUI() {

        createStartPage();
        createSinglePlayerPage();
        createMultiPlayerPage();
        createSettingsPage();
        createGamePage();

        CardLayout card = new CardLayout();
        Container container = getContentPane();
        container.setLayout(card);

        add(startPage);
        add(singlePlayerPage);
        add(multiPlayerPage);
        add(settingsPage);
        add(gamePage);

        container.getLayout().addLayoutComponent("startPage", startPage);
        container.getLayout().addLayoutComponent("singlePlayerPage", singlePlayerPage);
        container.getLayout().addLayoutComponent("multiPlayerPage", multiPlayerPage);
        container.getLayout().addLayoutComponent("settingsPage", settingsPage);
        container.getLayout().addLayoutComponent("gamePage", gamePage);

        setThemeColors(defaultButtonTextColor, defaultButtonBackgroundColor);
        setNewFont(defaultFont);


        for (JLabel gamePage_boardLabel : gamePage_boardLabels) {
            gamePage_boardLabel.addMouseListener(XOListener);
        }


        startPage_singlePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "singlePlayerPage");
            }
        });


        startPage_multiPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "multiPlayerPage");
            }
        });


        startPage_settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "settingsPage");
            }
        });


        startPage_about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aboutGame
                        = "<html>"
                        + "<big>TIC TAC TOE</big><br><br>"
                        + "<p>Prepared by a <b>Mhamad Harmush</b><br><br>"
                        + "If you have any comments, ideas.. just let know<br><br>"
                        + "email:   mhamad.harmush@gmail.com<br>"
                        + "twitter & facebook:   @MhamadHarmush<br><br>"
                        + "<u>Note</u><br>"
                        + "I used JDK 1.8 to compile the source code.<br><br><br>"
                        + "<p><i>© Copyright 2017 harmash.com - All Rights Reserved</i></p>"
                        + "<html>";

                JOptionPane.showMessageDialog(getContentPane(), aboutGame, "About Tic Tac Toe", JOptionPane.PLAIN_MESSAGE);
            }
        });


        startPage_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        singlePlayerPage_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePage_firstPlayerName.setText("X - " + singlePlayerPage_playerName.getText());
                gamePage_secondPlayerName.setText("O - Computer");
                challengeComputer = true;
                gamePage_firstPlayerScore.setText("0");
                gamePage_secondPlayerScore.setText("0");
                card.show(container, "gamePage");
            }
        });

        singlePlayerPage_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "startPage");
            }
        });


        multiPlayerPage_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePage_firstPlayerName.setText("X - " + multiPlayerPage_firstPlayerName.getText());
                gamePage_secondPlayerName.setText("O - " + multiPlayerPage_secondPlayerName.getText());
                challengeComputer = false;
                gamePage_firstPlayerScore.setText("0");
                gamePage_secondPlayerScore.setText("0");
                card.show(container, "gamePage");
            }
        });


        multiPlayerPage_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "startPage");
            }
        });


        gamePage_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (challengeComputer == true) {
                    card.show(container, "singlePlayerPage");
                } else {
                    card.show(container, "multiPlayerPage");
                }
                startNewGame();
            }
        });


        gamePage_restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });


        settingsPage_selectedBoardValue.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                String imageName = "";

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = e.getItem().toString();

                    switch (selectedItem) {
                        case "Board 1":
                            imageName = "board_1.png";
                            break;
                        case "Board 2":
                            imageName = "board_2.png";
                            break;
                        case "Board 3":
                            imageName = "board_3.png";
                            break;
                        case "Board 4":
                            imageName = "board_4.png";
                            break;
                    }
                    imageName = "/images/" + imageName;
                    gamePage_boardBackground.setIcon(new ImageIcon(this.getClass().getResource(imageName)));
                    repaint();
                }
            }
        });


        settingsPage_selectedFontSizeValue.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                int fontSize = 0;

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = e.getItem().toString();

                    switch (selectedItem) {
                        case "Small":
                            fontSize = 15;
                            break;
                        case "Meduim":
                            fontSize = 16;
                            break;
                        case "Large":
                            fontSize = 17;
                            break;
                    }

                    setNewFont(new Font("Arial", Font.BOLD, fontSize));
                }
            }
        });


        settingsPage_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsPage_selectedBoardValue.setSelectedItem("Board 1");
                settingsPage_selectedFontSizeValue.setSelectedItem("Meduim");
                gamePage_boardBackground.setIcon(new ImageIcon(this.getClass().getResource("/images/board_1.png")));
                setNewFont(new Font("Arial", Font.BOLD, 16));
            }
        });


        settingsPage_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(container, "startPage");
            }
        });


        // هنا قمنا بتحديد بعض خصائص النافذة و جعلناها مرئية
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Main();
            }
        });
    }

}