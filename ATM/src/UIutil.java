import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
//import javax.print.attribute.AttributeSet;
//此类是控制文本框输入类
public class UIutil extends DocumentFilter{

        private int maxCharacters;
 
        public UIutil(int maxChars) {
            maxCharacters = maxChars;
        }
 
        public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
                        throws BadLocationException {
 
            if ((fb.getDocument().getLength() + str.length()) <= maxCharacters) {
                super.insertString(fb, offs, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
 
        public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a)
                        throws BadLocationException {
 
            if ((fb.getDocument().getLength() + str.length() - length) <= maxCharacters) {
                super.replace(fb, offs, length, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    
 
}
	

	