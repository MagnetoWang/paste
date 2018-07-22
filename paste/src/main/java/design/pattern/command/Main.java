package design.pattern.command;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



import design.pattern.command.drawer.DrawCanvas;
import design.pattern.command.drawer.DrawCommand;

/**
 * @program: paste
 * @description: 执行程序的类
 * @author: MagnetoWang
 * @create: 2018-07-21 07:26
 **/
public class Main extends JFrame implements ActionListener,MouseMotionListener,WindowListener{
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas= new DrawCanvas(400,400,history);
    private JButton clearButton=new JButton("clear");

     // 构造函数
     public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        show();
    }

     // ActionListener接口中的方法
     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.repaint();
        }
    }

    // MouseMotionListener接口中的方法
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    // WindowListener接口中的方法
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }


}
