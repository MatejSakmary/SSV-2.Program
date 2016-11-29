package tul.ssv.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import tul.ssv.DrawTool;
import tul.ssv.model.Planet;
import tul.ssv.model.SimpleColor;

public class Controls extends javax.swing.JPanel {
    
    public PlanetHolder planetHolder;
    
    public Controls(PlanetHolder planetHolder) {
        initComponents();
        colorComboBoxActionPerformed(null);
        this.planetHolder = planetHolder;
    }
    
    private ComboBoxModel getComboColorModel() {
        return new DefaultComboBoxModel(
                new SimpleColor[]{
                    new SimpleColor("red", Color.RED),
                    new SimpleColor("green", Color.GREEN),
                    new SimpleColor("blue", Color.BLUE),
                    new SimpleColor("yellow", Color.YELLOW),}
        );
    }
    
    public void updatePos(MouseEvent e) {
        xPos.setText(Integer.toString(e.getX()));
        yPos.setText(Integer.toString(e.getY()));
    }
    
    public void updateDebugArea() {
        if (planetHolder == null)
            return;
        
        StringBuilder sb = new StringBuilder();
        for (Planet p : planetHolder.items) {
            sb.append(String.format("%10s: "
                    + "%n\tvx: %1.3f"
                    + "%n\tvy: %1.3f"
                    + "%n\tma: %1.3f"
                    + "%n",
                    p.getName(), p.getVx(), p.getVy(), p.getMass() / 1.0e20));
        }
        debugTA.setText(sb.toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yPos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        xPos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        massSlider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        sizeSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        colorComboBox = new javax.swing.JComboBox();
        colorPreview = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        debugTA = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        planetName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        speedSlider = new javax.swing.JSlider();
        fps = new javax.swing.JLabel();
        drawScale = new javax.swing.JSlider();

        setPreferredSize(new java.awt.Dimension(240, 600));

        yPos.setText("60");

        jLabel1.setText("Position: ");

        xPos.setText("50");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        massSlider.setMaximum(40);
        massSlider.setMinimum(15);
        massSlider.setValue(25);

        jLabel2.setText("Mass: ");

        sizeSlider.setMaximum(50);
        sizeSlider.setMinimum(10);
        sizeSlider.setValue(15);

        jLabel3.setText("Size: ");

        jLabel4.setText("Color");

        colorComboBox.setModel(getComboColorModel());
        colorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorComboBoxActionPerformed(evt);
            }
        });

        colorPreview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout colorPreviewLayout = new javax.swing.GroupLayout(colorPreview);
        colorPreview.setLayout(colorPreviewLayout);
        colorPreviewLayout.setHorizontalGroup(
            colorPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        colorPreviewLayout.setVerticalGroup(
            colorPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        debugTA.setColumns(20);
        debugTA.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        debugTA.setRows(5);
        jScrollPane1.setViewportView(debugTA);

        jLabel5.setText("Name:");

        jLabel6.setText("Speed:");

        fps.setText("fps");

        drawScale.setMaximum(10000000);
        drawScale.setMinimum(250000);
        drawScale.setValue(500000);
        drawScale.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                drawScaleStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(colorPreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(planetName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(xPos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yPos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(massSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(drawScale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(yPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(massSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(colorPreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(colorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(planetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(drawScale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fps)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void colorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorComboBoxActionPerformed
        SimpleColor color = (SimpleColor) colorComboBox.getSelectedItem();
        colorPreview.setBackground(color.color);

    }//GEN-LAST:event_colorComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Planet p = new Planet(
                planetName.getText().trim(),
                Math.pow(10.0, massSlider.getValue()),
                Integer.parseInt(xPos.getText()) * DrawTool.drawScale,
                Integer.parseInt(yPos.getText()) * DrawTool.drawScale,
                sizeSlider.getValue(),
                ((SimpleColor) colorComboBox.getSelectedItem()).color
        );
        p.setVy(1.0 * (speedSlider.getValue() * 10 * 1000));
        planetHolder.add(p);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void drawScaleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_drawScaleStateChanged
        DrawTool.drawScale = drawScale.getValue();
    }//GEN-LAST:event_drawScaleStateChanged
    
    public void setFPS(long nano) {
        fps.setText(
                Double.toString(1.0 / (nano / 1.0e9))
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox colorComboBox;
    private javax.swing.JPanel colorPreview;
    private javax.swing.JTextArea debugTA;
    private javax.swing.JSlider drawScale;
    private javax.swing.JLabel fps;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider massSlider;
    private javax.swing.JTextField planetName;
    private javax.swing.JSlider sizeSlider;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JTextField xPos;
    private javax.swing.JTextField yPos;
    // End of variables declaration//GEN-END:variables
}
