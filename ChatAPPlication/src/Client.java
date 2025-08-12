import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame implements ActionListener {
    JTextField text;
    JPanel a1;
    static Box vertical = Box.createVerticalBox();
    JLabel name; 

    Client() {
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        add(p1);
        
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        JLabel back = new JLabel(new ImageIcon(i2));
        back.setBounds(5, 20, 25, 25);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        JLabel profile = new JLabel(new ImageIcon(i5));
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);

        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        JLabel video = new JLabel(new ImageIcon(i8));
        video.setBounds(300, 20, 30, 30);
        p1.add(video);

        
        video.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(Client.this, 
                    "Calling feature will be updated soon till then enjoy");
            }
        });

       
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        JLabel phone = new JLabel(new ImageIcon(i11));
        phone.setBounds(360, 20, 30, 30);
        p1.add(phone);

       
        phone.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(Client.this, 
                    "Calling feature will be available soon till then enjoy");
            }
        });

      
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        JLabel morevert = new JLabel(new ImageIcon(i14));
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert);

        
        // 3 dot icon er kaj 
        morevert.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JPopupMenu menu = new JPopupMenu();

                JMenuItem editProfile = new JMenuItem("Edit Profile");
                editProfile.addActionListener(ae -> {
                    String newName = JOptionPane.showInputDialog(Client.this, "Enter new name:");
                    if (newName != null && !newName.trim().isEmpty()) {
                        name.setText(newName.trim());
                    }
                });

                JMenuItem updateItem = new JMenuItem("Update");
                updateItem.addActionListener(ae -> {
                    JOptionPane.showMessageDialog(Client.this, "Up to date");
                });

                menu.add(editProfile);
                menu.add(updateItem);
                menu.show(morevert, morevert.getWidth(), morevert.getHeight());
            }
        });

        // eikhane name er kaj 
        name = new JLabel("Nila");
        name.setBounds(110, 15, 200, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(status);

        a1 = new JPanel();
        a1.setBounds(5, 75, 425, 570);
        add(a1);

        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(text);

        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(send);

        setSize(450, 700);
        setLocation(600, 50);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String out = text.getText();
        JPanel p2 = formatLabel(out);
        a1.setLayout(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        a1.add(vertical, BorderLayout.PAGE_START);
        text.setText("");
        repaint();
        invalidate();
        validate();
    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        panel.add(output);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
    }

    public static void main(String[] args) {
        new Client();
    }
}