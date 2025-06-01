/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlaceholderTextField{
    
    public static void aplicarPlaceholder(final JTextField campo, final String placeholder) {
    campo.setForeground(Color.GRAY);
    campo.setText(placeholder);

    campo.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (campo.getText().equals(placeholder)) {
                campo.setText("");
                campo.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (campo.getText().isEmpty()) {
                campo.setForeground(Color.GRAY);
                campo.setText(placeholder);
            }
        }
    });

    // Força disparar o foco perdido para aplicar o placeholder, caso o campo já tenha foco
    if (campo.getText().isEmpty()) {
        campo.setForeground(Color.GRAY);
        campo.setText(placeholder);
    }
    }
}