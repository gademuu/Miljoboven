package miljoboven.client;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

import miljoboven.client.listcases.ListCasesListener;
import miljoboven.client.listcases.ListCasesSetter;
import miljoboven.client.listcases.ListCasesView;
import miljoboven.client.listcases.ListCasesViewActionHandler;
import miljoboven.client.login.LoginListener;
import miljoboven.client.login.LoginSetter;
import miljoboven.client.login.LoginView;
import miljoboven.client.login.LoginViewActionHandler;
import miljoboven.client.registercase.RegisterCaseListener;
import miljoboven.client.registercase.RegisterCaseView;
import miljoboven.client.registercase.RegisterCaseViewActionHandler;
import miljoboven.client.registercase.RegisterCaseViewSetter;
import miljoboven.client.registeruser.RegisterUserListener;
import miljoboven.client.registeruser.RegisterUserView;
import miljoboven.client.registeruser.RegisterUserViewActionHandler;
import miljoboven.client.updatecase.UpdateCaseListener;
import miljoboven.client.updatecase.UpdateCaseView;
import miljoboven.client.updatecase.UpdateCaseViewActionHandler;
import miljoboven.client.updatecase.UpdateCaseViewSetter;
import miljoboven.logic.login.LoginManager;
import miljoboven.logic.registercase.RegisterCaseManager;
import miljoboven.logic.registeruser.RegisterUserManager;
import miljoboven.logic.updatecase.UpdateCaseManager;

import java.awt.*;
import java.awt.event.*; 


public class MainFrame extends JFrame implements LoginSetter{
    
	private Role loggedInUser = new Role();
	
	//register case
    private RegisterCaseView rcView = null;
    private RegisterCaseViewActionHandler rcvHandler = null;
    //login
    private LoginView lv = null;
    private LoginViewActionHandler lvHandler = null;
    //register user
    private RegisterUserView ruView = null;
    private RegisterUserViewActionHandler ruvHandler = null;
    //update case
    private UpdateCaseView ucView = null;
    private UpdateCaseViewActionHandler ucvHandler = null;
    private UpdateCaseListener ucl = null; 
    //list cases
    private ListCasesView lcView = null;
    private ListCasesViewActionHandler lcvHandler = null;
    private ListCasesListener lcl = null;
    
    private CardLayout layout = null;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame(RegisterCaseListener rcl, LoginListener ll, RegisterUserListener rul, UpdateCaseListener ucl, ListCasesListener lcl) {
        super("Miljöboven");
        this.ucl = ucl;
        this.lcl = lcl;
        
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setSize(1000,1000);
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
        
    
 
        //Login
        lvHandler = new LoginViewActionHandler(this,ll);
        lv = new LoginView(lvHandler);
        lvHandler.setView(lv);
        add(lv, "LOGIN_VIEW");
        
        //RegisterUser
        ruvHandler = new RegisterUserViewActionHandler(this, rul);
        ruView = new RegisterUserView(ruvHandler);
        ruvHandler.setView(ruView);
        add(ruView, "REGISTER_USER_VIEW");
        
        //UpdateCase
        ucvHandler = new UpdateCaseViewActionHandler(this, ucl,lcl);
        ucView = new UpdateCaseView(this,ucvHandler);
        ucvHandler.setView(ucView);
        add(ucView, "UPDATE_CASE_VIEW");
        
        //ListCases
        lcvHandler = new ListCasesViewActionHandler(this, lcl);
        lcView = new ListCasesView(this,lcvHandler);
        lcvHandler.setView(lcView);
        add(lcView, "LIST_CASES_VIEW");
        
        
        
        
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
   
    /**
     * Returns the layout.
     */
    public CardLayout getLayout() {
        return layout;
    }
    
    
    /**
     * 
     * @returns the logged in User.
     */
    public Role getRole(){
    	return loggedInUser;
    }
    
    /**
     * Sets the role of the logged in user.
     * @param role
     */
    public void setRole(String role){
    	
    	this.loggedInUser.role = role;
    	
    	 //Initialize UpdateCase
    	ucView.removeAll();
        ucView.initialize();
        
        //Initialize ListCases
        lcView.removeAll();
        lcView.initialize();
    }
    
    public ListCasesSetter getListCasesSetter(){
    	
    	return  lcView;
    }
    
    
    public UpdateCaseViewSetter getUpdateCaseSetter(){
    	
    	return  ucView;
    }
    
    
}
