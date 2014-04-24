package miljoboven.client.showcase;

import java.awt.event.*;

import miljoboven.client.MainFrame;

/**
 *
 * @author herman
 */
public class ShowCaseViewActionHandler implements ActionListener {
    
    private MainFrame mainFrame = null;
    
    public ShowCaseViewActionHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

         if(e.getActionCommand().equals("OK")) {
            
            mainFrame.getLayout().show(mainFrame.getContentPane(), "REGISTER_CASE_VIEW");
            
        }
        
    }
    
}