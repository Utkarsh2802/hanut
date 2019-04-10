/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_hanut;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.sql.ResultSet;

/**
 *
 * @author MAHE
 */
public class CartWishlist extends javax.swing.JFrame {

    /**
     * Creates new form CartWishlist
     */
    public CartWishlist() {
        initComponents();
        initializeCart();
        initializeWish();
        jPanel10.setVisible(true);

    }

    public void addcart(int pid) {
        ResultSet rs = SqlQ.retrive("select count(P_ID) as cpid from cart where cust_ID='" + Session.curr_user() + "';");
        int count_pid = 0;
        try {
            if (rs.next()) {
                count_pid = Integer.parseInt(rs.getString("cpid"));
            }
        } catch (Exception e) {
            System.out.println(e + "hello");

        }
        if (count_pid == 3) {
            JOptionPane.showMessageDialog(this, "Cannot Add More Then Three Items To The Cart!");
        } else {
            System.out.println(pid);
            String query = "insert into cart values('" + Session.curr_user() + "','" + pid + "');";
            System.out.println(query);
            SqlQ.updateq(query);
            SqlQ.updateq("delete from wishlist where P_ID='" + pid + "';");
            new CartWishlist().setVisible(true);
            this.dispose();
        }

    }

    public String getImgID(int pid) {
        switch (pid) {
            case 800001:
                return "PicturesSmall/b01_MasterOfTheGame.jpeg";
            case 800002:
                return "PicturesSmall/b02_Divergent.jpeg";
            case 800003:
                return "PicturesSmall/b03_sapiens.jpeg";
            case 800004:
                return "PicturesSmall/b04_WingOfFire.jpeg";
            case 800005:
                return "PicturesSmall/b06_Notebook.jpeg";
            case 800006:
                return "PicturesSmall/b05_HalfBloodPrince.jpeg";
            case 800007:
                return "PicturesSmall/b07_LightingThief.jpeg";
            case 800008:
                return "PicturesSmall/b08_DigitalFortress.jpeg";
            case 800009:
                return "PicturesSmall/as01_Watch.jpeg";
            case 800010:
                return "PicturesSmall/as02_Bag.jpeg";
            case 800011:
                return "PicturesSmall/as03_Purse.jpeg";
            case 800012:
                return "PicturesSmall/as04_Cuffs.jpeg";
            case 800013:
                return "PicturesSmall/as05_Wallet.jpeg";
            case 800014:
                return "PicturesSmall/as06_HairBand.jpeg";
            case 800015:
                return "PicturesSmall/as07_Neckless.jpeg";
            case 800016:
                return "PicturesSmall/as08Ring.jpeg";
            case 800017:
                return "PicturesSmall/e01_Earphones.jpeg";
            case 800018:
                return "PicturesSmall/e02_Headphones.jpeg";
            case 800019:
                return "PicturesSmall/e03_Laptop.jpeg";
            case 800020:
                return "PicturesSmall/e04_Phone.jpeg";
            case 800021:
                return "PicturesSmall/e05_Ram.jpeg";
            case 800022:
                return "PicturesSmall/e06_Mouse.jpeg";
            case 800023:
                return "PicturesSmall/e07_Keyboard.jpeg";
            case 800024:
                return "PicturesSmall/e08_Speaker.jpeg";
            case 800025:
                return "PicturesSmall/f01_WJacket.jpeg";
            case 800026:
                return "PicturesSmall/f02_MJacket.jpeg";
            case 800027:
                return "PicturesSmall/f03_TShirt.jpeg";
            case 800028:
                return "PicturesSmall/f04_WTop.jpeg";
            case 800029:
                return "PicturesSmall/f05_MPants.jpeg";
            case 800030:
                return "PicturesSmall/f06_Palazzo.jpeg";
            case 800031:
                return "PicturesSmall/f07_Kurti.jpeg";
            case 800032:
                return "PicturesSmall/f08_Dress.jpeg";
            case 800033:
                return "PicturesSmall/hf01_Sofa.jpeg";
            case 800034:
                return "PicturesSmall/hf02_Bed.jpeg";
            case 800035:
                return "PicturesSmall/hf03_DinningTable.jpeg";
            case 800036:
                return "PicturesSmall/hf04_StudyTable.jpeg";
            case 800037:
                return "PicturesSmall/hf05_cabinets.jpeg";
            case 800038:
                return "PicturesSmall/hf06_Vase.jpeg";
            case 800039:
                return "PicturesSmall/hf07_Fountain.jpeg";
            case 800040:
                return "PicturesSmall/hf08_lamp.jpeg";
            default:
                return null;

        }
    }

    public void initializeCart() {
        ResultSet rs = SqlQ.retrive("select count(P_ID) as pid from cart where cust_ID='" + Session.curr_user() + "';");
        int count_pid = 0;
        System.out.println("hello");
        ResultSet rs2 = SqlQ.retrive("select P_ID,name,cost,quantity from cart natural join product where cust_ID='" + Session.curr_user() + "';");

        try {
            if (rs.next()) {
                count_pid = Integer.parseInt(rs.getString("pid"));
            }
        } catch (Exception e) {
            System.out.println(e + "hello");

        }
        System.out.println(count_pid);
        if (count_pid == 0) {
            jPanel15.setVisible(false);
            jPanel14.setVisible(false);
            jPanel11.setVisible(false);
            jButton6.setVisible(false);
            jButton4.setVisible(false);
        } else if (count_pid == 1) {
            jPanel15.setVisible(false);
            jPanel14.setVisible(false);
            try {
                if (rs2.next()) {
                    ImageIcon im1 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel10.setIcon(im1);
                    System.out.println(rs2.getString("P_ID"));
                    jLabel5.setText(rs2.getString("name"));
                    jLabel6.setText(rs2.getString("cost"));
                    jLabel7.setText(rs2.getString("quantity"));

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (count_pid == 2) {
            jPanel15.setVisible(false);
            try {
                if (rs2.next()) {
                    ImageIcon im1 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel10.setIcon((Icon) im1);
                    System.out.println(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel5.setText(rs2.getString("name"));
                    jLabel6.setText(rs2.getString("cost"));
                    jLabel7.setText(rs2.getString("quantity"));
                    rs2.next();
                    ImageIcon im2 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel14.setIcon((Icon) im2);
                    jLabel11.setText(rs2.getString("name"));
                    jLabel12.setText(rs2.getString("cost"));
                    jLabel13.setText(rs2.getString("quantity"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            try {
                if (rs2.next()) {
                    ImageIcon im1 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel10.setIcon((Icon) im1);
                    jLabel5.setText(rs2.getString("name"));
                    jLabel6.setText(rs2.getString("cost"));
                    jLabel7.setText(rs2.getString("quantity"));
                    rs2.next();
                    ImageIcon im2 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel14.setIcon((Icon) im2);
                    jLabel11.setText(rs2.getString("name"));
                    jLabel12.setText(rs2.getString("cost"));
                    jLabel13.setText(rs2.getString("quantity"));
                    rs2.next();
                    ImageIcon im3 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel18.setIcon((Icon) im3);
                    jLabel15.setText(rs2.getString("name"));
                    jLabel16.setText(rs2.getString("cost"));
                    jLabel17.setText(rs2.getString("quantity"));

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public void initializeWish() {
        ResultSet rs = SqlQ.retrive("select count(P_ID) as pid from wishlist where cust_ID='" + Session.curr_user() + "';");
        int count_pid = 0;
        System.out.println("hello");
        ResultSet rs2 = SqlQ.retrive("select P_ID,name,cost,quantity from wishlist natural join product where cust_ID='" + Session.curr_user() + "';");

        try {
            if (rs.next()) {
                count_pid = Integer.parseInt(rs.getString("pid"));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        System.out.println(count_pid);
        if (count_pid == 0) {
            jPanel18.setVisible(false);
            jPanel19.setVisible(false);
            jPanel20.setVisible(false);
        } else if (count_pid == 1) {
            jPanel19.setVisible(false);
            jPanel20.setVisible(false);
            try {
                if (rs2.next()) {
                    ImageIcon im1 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel30.setIcon(im1);
                    System.out.println(rs2.getString("P_ID"));
                    jLabel27.setText(rs2.getString("name"));
                    jLabel28.setText(rs2.getString("cost"));
                    jLabel29.setText(rs2.getString("quantity"));

                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (count_pid == 2) {
            jPanel20.setVisible(false);
            try {
                if (rs2.next()) {
                    ImageIcon im1 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel30.setIcon((Icon) im1);
                    System.out.println(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel27.setText(rs2.getString("name"));
                    jLabel28.setText(rs2.getString("cost"));
                    jLabel29.setText(rs2.getString("quantity"));
                    rs2.next();
                    ImageIcon im2 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel34.setIcon((Icon) im2);
                    jLabel31.setText(rs2.getString("name"));
                    jLabel32.setText(rs2.getString("cost"));
                    jLabel33.setText(rs2.getString("quantity"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            try {
                if (rs2.next()) {
                    ImageIcon im1 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel30.setIcon((Icon) im1);
                    jLabel27.setText(rs2.getString("name"));
                    jLabel28.setText(rs2.getString("cost"));
                    jLabel29.setText(rs2.getString("quantity"));
                    rs2.next();
                    ImageIcon im2 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel34.setIcon((Icon) im2);
                    jLabel31.setText(rs2.getString("name"));
                    jLabel32.setText(rs2.getString("cost"));
                    jLabel33.setText(rs2.getString("quantity"));
                    rs2.next();
                    ImageIcon im3 = new ImageIcon(getImgID(Integer.parseInt(rs2.getString("P_ID"))));
                    jLabel38.setIcon((Icon) im3);
                    jLabel35.setText(rs2.getString("name"));
                    jLabel36.setText(rs2.getString("cost"));
                    jLabel37.setText(rs2.getString("quantity"));

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 49, 60));

        jPanel3.setBackground(new java.awt.Color(51, 49, 60));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("hANUT");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel1.setFont(new java.awt.Font("Ink Free", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("The Online Shop");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 124, -1));

        jPanel5.setBackground(new java.awt.Color(51, 49, 60));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("© CURP Foundations");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("2019");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(2, 2, 2)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 539));

        jPanel4.setBackground(new java.awt.Color(99, 96, 112));

        jButton3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 49, 60));
        jButton3.setText("LogOut");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 49, 60));
        jButton5.setText("Home");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 640, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 840, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 49, 60));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Wishlist");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 397, 36));

        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setText("jLabel5");
        jPanel18.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 13, 221, 26));

        jLabel28.setText("jLabel6");
        jPanel18.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 40, 228, 27));

        jLabel29.setText("jLabel7");
        jPanel18.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 78, 120, 26));

        jLabel30.setText("jLabel10");
        jPanel18.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 156, 113));

        jButton1.setText("Add To Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        jPanel2.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 47, 400, -1));

        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel31.setText("jLabel5");

        jLabel32.setText("jLabel6");

        jLabel33.setText("jLabel7");

        jLabel34.setText("jLabel10");

        jButton2.setText("Add To Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)))
            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 400, -1));

        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel35.setText("jLabel5");

        jLabel36.setText("jLabel6");

        jLabel37.setText("jLabel7");

        jLabel38.setText("jLabel10");

        jButton10.setText("Add To Cart");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10))
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10)))
            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 400, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 54, 420, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 49, 60));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cart");

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel10.setText("jLabel10");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setText("jLabel5");

        jLabel12.setText("jLabel6");

        jLabel13.setText("jLabel7");

        jLabel14.setText("jLabel10");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setText("jLabel5");

        jLabel16.setText("jLabel6");

        jLabel17.setText("jLabel7");

        jLabel18.setText("jLabel10");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", " " }));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton6.setBackground(new java.awt.Color(51, 49, 60));
        jButton6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Empty Cart");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 49, 60));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Buy Now");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(29, 29, 29))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton4))
                .addGap(242, 242, 242))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 410, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ResultSet rs = SqlQ.retrive("select count(order_ID) as cpid from orders where cust_ID='" + Session.curr_user() + "';");
        int count_pid = 0;
        try {
            if (rs.next()) {
                count_pid = Integer.parseInt(rs.getString("cpid"));
                System.out.println(count_pid+"count or order oid");
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        ResultSet rs2 = SqlQ.retrive("select count(P_ID) as cpid1 from cart where cust_ID='" + Session.curr_user() + "';");
        int count_pid1 = 0;
        try {
            if (rs2.next()) {
                count_pid1 = Integer.parseInt(rs2.getString("cpid1"));
                System.out.println(count_pid1+"count or order pid");
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        System.out.println(count_pid + count_pid1+"sum of them");
        if (count_pid + count_pid1 <= 3) {
            ResultSet rs3 = SqlQ.retrive("select P_ID from cart where cust_ID='" + Session.curr_user() + "';");
            int i=1;
            while (count_pid1!= 0) {
                int pid = 0;
                try {
                    if (rs3.next()) {
                        pid = Integer.parseInt(rs3.getString("P_ID"));
                        System.out.println(pid+"pid");
                    }
                  } 
                catch (Exception e) {
                    System.out.println(e);

                   }
                
                ResultSet rs8 = SqlQ.retrive("select quantity,S_ID,cost from product where P_ID='" + pid + "';");
                int qty =0;
                int sid=0;
                float cost = 0;
                try {
                    if (rs8.next()) {
                        qty = Integer.parseInt(rs8.getString("quantity"));
                        sid = Integer.parseInt(rs8.getString("S_ID"));
                        cost = Float.parseFloat(rs8.getString("cost"));
                    }
                  } 
                catch (Exception e) {
                    System.out.println(e);

                   }
                ResultSet rs7 = SqlQ.retrive("select income,profit from S_ACC where S_ID='" + sid + "';");
                float profit = 0;
                float income = 0;
                try {
                    if (rs7.next()) {
                        
                        profit = Float.parseFloat(rs7.getString("profit"));
                        income = Float.parseFloat(rs7.getString("income"));
                        System.out.println(income+"  "+profit+"income and profit");
                    }
                  } 
                catch (Exception e) {
                    System.out.println(e);

                   }
               
                int q=1;
                if (i==1)
                    q=Integer.parseInt(jComboBox1.getSelectedItem().toString());
                else if(i==2)
                    q=Integer.parseInt(jComboBox2.getSelectedItem().toString());
                else
                    q=Integer.parseInt(jComboBox3.getSelectedItem().toString());
                if(q<qty)
                {
                    qty=(int)qty-q;
                float a=(float)q*cost;
                income=income+a;
                profit=profit+a;
                String query = "insert into orders(cust_ID,amount) values('" + Session.curr_user() + "','" + a+ "');";
                SqlQ.updateq(query);
                SqlQ.updateq("update S_ACC set income='"+income+"' where S_ID='" + sid + "';");
                SqlQ.updateq("update S_ACC set profit='"+profit+"' where S_ID='" + sid + "';");
                System.out.println("Error");
                
                SqlQ.updateq("update product set quantity='"+qty+"' where P_ID='" + pid + "';");
                SqlQ.updateq("delete from cart where cust_ID='" + Session.curr_user() + "' and P_ID='" + pid + "';");
                ResultSet rs4 = SqlQ.retrive("select max(order_ID) as m from orders group by cust_ID having cust_ID='" + Session.curr_user() + "';");
                int oid = 0;
                try {
                    if (rs4.next()) {
                        oid = Integer.parseInt(rs4.getString("m"));
                        System.out.println(oid+"oid");
                    }
                } catch (Exception e) {
                    System.out.println(e);

                }
                String query3 = "insert into items(order_ID,P_ID,qty) values('" + oid + "','" + pid + "','" + q + "');";
                SqlQ.updateq(query3);
                int days=7;
                String s="Ordered";
                String query2 = "insert into delivery values('" + oid + "','" + pid + "','" + days+ "','" +s+ "');";
                SqlQ.updateq(query2);
                JOptionPane.showMessageDialog(this, "Congratulations!! Your Order Has Been Successfully Placed!!");
                CustomerCart c = new CustomerCart();
                this.setVisible(false);
                c.setVisible(true);
                
               }
                else
                {
                    JOptionPane.showMessageDialog(this, "Please Select Available Quantity");
                    break;
                }
                count_pid1--;
            }
           

        } 
        else 
        {
            JOptionPane.showMessageDialog(this, "Cannot Add More Then Three Items To The Orders List!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        ResultSet rs = SqlQ.retrive("select count(P_ID) as cpid from cart where cust_ID='" + Session.curr_user() + "';");
        int count_pid = 0;
        try {
            if (rs.next()) {
                count_pid = Integer.parseInt(rs.getString("cpid"));
                System.out.println(count_pid);
            }
        } catch (Exception e) {
            System.out.println(e);
          }
            if(count_pid==0)
            {
                JOptionPane.showMessageDialog(this, "Add Items To cart To Remove!");
            }
            else
            {
             SqlQ.updateq("delete from cart where cust_ID='" + Session.curr_user() + "';");
             new CartWishlist().setVisible(true);
            this.dispose();
            }

        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        LoginPage l = new LoginPage();
        Session.logout();
        this.setVisible(false);
        l.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        AllProductPage a = new AllProductPage();
        a.setVisible(true);
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ResultSet rs = SqlQ.retrive("select P_ID as pid from product where name='" + jLabel31.getText() + "';");
        int pid = 0;
        try {
            if (rs.next()) {
                pid = Integer.parseInt(rs.getString("pid"));
            }
        } catch (Exception e) {
            System.out.println(e + "hello");

        }
        addcart(pid);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ResultSet rs = SqlQ.retrive("select P_ID as pid from product where name='" + jLabel27.getText() + "';");
        int pid = 0;
        try {
            if (rs.next()) {
                pid = Integer.parseInt(rs.getString("pid"));
            }
        } catch (Exception e) {
            System.out.println(e + "hello");

        }
        addcart(pid);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        ResultSet rs = SqlQ.retrive("select P_ID as pid from product where name='" + jLabel35.getText() + "';");
        int pid = 0;
        try {
            if (rs.next()) {
                pid = Integer.parseInt(rs.getString("pid"));
            }
        } catch (Exception e) {
            System.out.println(e + "hello");

        }
        addcart(pid);
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CartWishlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartWishlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartWishlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartWishlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CartWishlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
