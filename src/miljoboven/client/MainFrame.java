package miljoboven.client;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

import miljoboven.client.login.LoginListener;
import miljoboven.client.login.LoginView;
import miljoboven.client.login.LoginViewActionHandler;
import miljoboven.client.registercase.RegisterCaseListener;
import miljoboven.client.registercase.RegisterCaseView;
import miljoboven.client.registercase.RegisterCaseViewActionHandler;
import miljoboven.client.registercase.RegisterCaseViewSetter;
import miljoboven.client.showcase.ShowCaseView;
import miljoboven.client.showcase.ShowCaseViewActionHandler;

import java.awt.*;
import java.awt.event.*; 


public class MainFrame extends JFrame {
    
	//register
    private RegisterCaseView rcView = null;
    private RegisterCaseViewActionHandler rcvHandler = null;
    //show
    private ShowCaseView scView = null;
    private ShowCaseViewActionHandler scvHandler = null;
    //login
    private LoginView lv = null;
    private LoginViewActionHandler lvHandler = null;
    
    private CardLayout layout = null;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame(RegisterCaseListener rcl, LoginListener ll) {
        super("Miljöboven");
        
        setSize(600,600);
        setLocationRelativeTo(null); //This will center the JFrame in the middle of the screen
        Border outline = BorderFactory.createLineBorder(Color.black); //creating a border to highlight the component areas
        
        layout = new CardLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        setLayout(layout);   
        
        // Set up sub panels and handlers
        
        //RegisterCase
        rcvHandler = new RegisterCaseViewActionHandler(this, rcl);
        rcView = new RegisterCaseView(rcvHandler);
        rcvHandler.setView(rcView);
        add(rcView, "REGISTER_CASE_VIEW");
        
        //ShowCase
        scvHandler = new ShowCaseViewActionHandler(this);
        scView = new ShowCaseView(scvHandler);
        add(scView, "SHOW_CASE_VIEW");
        
        //Login
        lvHandler = new LoginViewActionHandler(this,ll);
        lv = new LoginView(lvHandler);
        lvHandler.setView(lv);
        add(lv, "LOGIN_VIEW");
        
        
        layout.show(getContentPane(), "LOGIN_VIEW");
        
        addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent windowEvent){
	        System.exit(0);
         }        
      });    
        
    }
    
    
    /**
     *
     */
    public void initialize() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }
   
    
    public CardLayout getLayout() {
        return layout;
    }
    
    public RegisterCaseViewSetter getRegisterCaseViewSetter(){
    	//TODO
    	
    	return null;
    }
    
    
}
