/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test;

import controller.FuncionarioController;
import controller.GrupoFamiliarController;
import domain.Funcionario;
import domain.GrupoFamiliar;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alucp
 */
public class Main2 extends javax.swing.JFrame {

    private final FuncionarioController funcionarioController;
    private final GrupoFamiliarController grupoFamiliarController;
    private final static String[] COLUMNS = {"ID", "TIPOID", "NUMEROID", "NOMBRES", "APELLIDOS", "ESTADOCIVIL", "SEXO", "DIRECCION", "TELEFONO", "FECHANACIMIENTO"};
    private final static String[] COLUMNS1 = {"ID", "NOMBRES", "APELLIDOS", "PARENTESCO"};
    private final static String SELECCIONE = "--SELECCIONE--";
    private final static String SELECCIONE1 = "--SELECCIONE--";

    /**
     * Creates new form Main2
     */
    public Main2() {
        initComponents();
        txtFuncionarioId.setEditable(false);
        funcionarioController = new FuncionarioController();
        grupoFamiliarController = new GrupoFamiliarController();
        listFuncionarios();
        listGruposFamiliares();
        addListener();

    }

    private void listFuncionarios() {

        cbxFuncionarios.removeAllItems();
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNombres(SELECCIONE);
        funcionario1.setApellidos("");
        cbxFuncionarios.addItem(funcionario1);
        tblFuncionarios.removeAll();

        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);

        }

        tblFuncionarios.setModel(defaultTableModel);
        tblFuncionarios1.setModel(defaultTableModel);

        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                return;
            }
            defaultTableModel.setRowCount(funcionarios.size());
            int row = 0;
            for (Funcionario funcionario : funcionarios) {
                defaultTableModel.setValueAt(funcionario.getId(), row, 0);
                defaultTableModel.setValueAt(funcionario.getTipoid(), row, 1);
                defaultTableModel.setValueAt(funcionario.getNumeroid(), row, 2);
                defaultTableModel.setValueAt(funcionario.getNombres(), row, 3);
                defaultTableModel.setValueAt(funcionario.getApellidos(), row, 4);
                defaultTableModel.setValueAt(funcionario.getEstadocivil(), row, 5);
                defaultTableModel.setValueAt(funcionario.getSexo(), row, 6);
                defaultTableModel.setValueAt(funcionario.getDireccion(), row, 7);
                defaultTableModel.setValueAt(funcionario.getTelefono(), row, 8);
                defaultTableModel.setValueAt(funcionario.getFechanacimiento(), row, 9);
                row++;

                cbxFuncionarios.addItem(funcionario);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void listGruposFamiliares() {
        cbxGrupoFamiliarEdit.removeAllItems();


        GrupoFamiliar grupoFamiliar1 = new GrupoFamiliar();
        grupoFamiliar1.setNombres(SELECCIONE1);
        grupoFamiliar1.setApellidos("");


        cbxGrupoFamiliarEdit.addItem(grupoFamiliar1.getNombres() + " " + grupoFamiliar1.getApellidos());


        tblGruposFamiliares.removeAll();

        DefaultTableModel defaultTableModel1 = new DefaultTableModel();
        for (String COLUMN : COLUMNS1) {
            defaultTableModel1.addColumn(COLUMN);
        }
        tblGruposFamiliares.setModel(defaultTableModel1);

        try {
            List<GrupoFamiliar> gruposFamiliares = grupoFamiliarController.obtenerGruposFamiliares();
            if (gruposFamiliares.isEmpty()) {
                return;
            }
            defaultTableModel1.setRowCount(gruposFamiliares.size());
            int row = 0;
            for (GrupoFamiliar grupoFamiliar : gruposFamiliares) {
                defaultTableModel1.setValueAt(grupoFamiliar.getFuncionarioId(), row, 0);
                defaultTableModel1.setValueAt(grupoFamiliar.getNombres(), row, 1);
                defaultTableModel1.setValueAt(grupoFamiliar.getApellidos(), row, 2);
                defaultTableModel1.setValueAt(grupoFamiliar.getParentesco(), row, 3);
                row++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addListener() {
        cbxFuncionarios.addItemListener(event -> {
            Funcionario selectedFuncionario = (Funcionario) event.getItem();
            if (selectedFuncionario.getNombres().equals(SELECCIONE)) {
                txtFuncionarioId.setText("");
                txtTipoidEdit.setText("");
                txtNumeroidEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadocivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechanacimientoEdit.setText("");

            } else {
                txtFuncionarioId.setText(String.valueOf(selectedFuncionario.getId()));
                txtTipoidEdit.setText(String.valueOf(selectedFuncionario.getTipoid()));
                txtNumeroidEdit.setText(String.valueOf(selectedFuncionario.getNumeroid()));
                txtNombresEdit.setText(String.valueOf(selectedFuncionario.getNombres()));
                txtApellidosEdit.setText(String.valueOf(selectedFuncionario.getApellidos()));
                txtEstadocivilEdit.setText(String.valueOf(selectedFuncionario.getEstadocivil()));
                txtSexoEdit.setText(String.valueOf(selectedFuncionario.getSexo()));
                txtDireccionEdit.setText(String.valueOf(selectedFuncionario.getDireccion()));
                txtTelefonoEdit.setText(String.valueOf(selectedFuncionario.getTelefono()));
                txtFechanacimientoEdit.setText(String.valueOf(selectedFuncionario.getFechanacimiento()));
            }
            System.out.println("selectedFuncionario = " + selectedFuncionario);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTPanels = new javax.swing.JTabbedPane();
        jPFun = new javax.swing.JPanel();
        jPCampus = new javax.swing.JPanel();
        lblTipoid = new javax.swing.JLabel();
        lblNumeroid = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEstadocivil = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFechanacimiento = new javax.swing.JLabel();
        txtTipoid = new javax.swing.JTextField();
        txtNumeroid = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEstadocivil = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFechanacimiento = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPEditar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        lblFuncionarioID = new javax.swing.JLabel();
        lblTipoidEdit = new javax.swing.JLabel();
        lblNumeroidEdit = new javax.swing.JLabel();
        lblNombresEdit = new javax.swing.JLabel();
        lblApellidosEdit = new javax.swing.JLabel();
        lblEstadocivilEdit = new javax.swing.JLabel();
        lblSexoEdit = new javax.swing.JLabel();
        lblDireccionEdit = new javax.swing.JLabel();
        lblTelefonoEdit = new javax.swing.JLabel();
        lblFechanacimientoEdit = new javax.swing.JLabel();
        txtFuncionarioId = new javax.swing.JTextField();
        txtTipoidEdit = new javax.swing.JTextField();
        txtNombresEdit = new javax.swing.JTextField();
        txtEstadocivilEdit = new javax.swing.JTextField();
        txtSexoEdit = new javax.swing.JTextField();
        txtNumeroidEdit = new javax.swing.JTextField();
        txtApellidosEdit = new javax.swing.JTextField();
        txtDireccionEdit = new javax.swing.JTextField();
        txtTelefonoEdit = new javax.swing.JTextField();
        txtFechanacimientoEdit = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPCrear = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFunId = new javax.swing.JTextField();
        txtNombresGp = new javax.swing.JTextField();
        txtApellidosGp = new javax.swing.JTextField();
        txtParentescoGp = new javax.swing.JTextField();
        btnCrearGp = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGruposFamiliares = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFuncionarios1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPEditar1 = new javax.swing.JPanel();
        cbxGrupoFamiliarEdit = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFunIdEdit = new javax.swing.JTextField();
        txtNombresGpEdit = new javax.swing.JTextField();
        txtApellidosGpEdit = new javax.swing.JTextField();
        txtParentescoGpEdit = new javax.swing.JTextField();
        btnActualizarGp = new javax.swing.JButton();
        btnEliminarGp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FUNCIONARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 6, -1, 30));

        jPCampus.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblTipoid.setText("Tipo Doc.");

        lblNumeroid.setText("Numero Doc");

        lblNombres.setText("Nombres");

        lblApellidos.setText("Apellidos");

        lblEstadocivil.setText("Estado Civil");

        lblSexo.setText("Sexo");

        lblDireccion.setText("Direccion");

        lblTelefono.setText("Telefono");

        lblFechanacimiento.setText("Fecha Nac.");

        txtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSexoActionPerformed(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCampusLayout = new javax.swing.GroupLayout(jPCampus);
        jPCampus.setLayout(jPCampusLayout);
        jPCampusLayout.setHorizontalGroup(
            jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtFechanacimiento)
                    .addComponent(lblTipoid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumeroid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumeroid, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(lblFechanacimiento, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTipoid))
                .addGap(79, 79, 79)
                .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombres)
                    .addComponent(lblApellidos)
                    .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(txtApellidos))
                .addGap(89, 89, 89)
                .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCampusLayout.createSequentialGroup()
                        .addComponent(lblEstadocivil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDireccion)
                        .addGap(127, 127, 127))
                    .addGroup(jPCampusLayout.createSequentialGroup()
                        .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEstadocivil, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(txtSexo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCrear)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(78, 78, 78))
                    .addGroup(jPCampusLayout.createSequentialGroup()
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTelefono)
                        .addGap(125, 125, 125))))
        );
        jPCampusLayout.setVerticalGroup(
            jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCampusLayout.createSequentialGroup()
                .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCampusLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoid)
                            .addComponent(lblNombres)
                            .addComponent(lblEstadocivil)))
                    .addGroup(jPCampusLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblDireccion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadocivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroid)
                    .addComponent(lblApellidos)
                    .addComponent(lblSexo)
                    .addComponent(lblTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(lblFechanacimiento)
                .addGap(7, 7, 7)
                .addGroup(jPCampusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPFunLayout = new javax.swing.GroupLayout(jPFun);
        jPFun.setLayout(jPFunLayout);
        jPFunLayout.setHorizontalGroup(
            jPFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFunLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPFunLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPFunLayout.setVerticalGroup(
            jPFunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFunLayout.createSequentialGroup()
                .addComponent(jPCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPanels.addTab("Crear", jPFun);

        jPEditar.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique los siguientes campos"));

        jLabel2.setText("Funcionarios");

        lblFuncionarioID.setText("ID");

        lblTipoidEdit.setText("Tipo Doc");

        lblNumeroidEdit.setText("Numero Doc");

        lblNombresEdit.setText("Nombres");

        lblApellidosEdit.setText("Apellidos");

        lblEstadocivilEdit.setText("Estado C.");

        lblSexoEdit.setText("Sexo");

        lblDireccionEdit.setText("Direccion");

        lblTelefonoEdit.setText("Telefono");

        lblFechanacimientoEdit.setText("Fec. nac.");

        txtTipoidEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoidEditActionPerformed(evt);
            }
        });

        txtNombresEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresEditActionPerformed(evt);
            }
        });

        txtEstadocivilEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadocivilEditActionPerformed(evt);
            }
        });

        txtNumeroidEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroidEditActionPerformed(evt);
            }
        });

        btnActualizar.setText("Acutalizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPEditarLayout = new javax.swing.GroupLayout(jPEditar);
        jPEditar.setLayout(jPEditarLayout);
        jPEditarLayout.setHorizontalGroup(
            jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNumeroidEdit)
                            .addComponent(lblFuncionarioID)
                            .addComponent(txtFuncionarioId, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(txtNumeroidEdit))))
                .addGap(47, 47, 47)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellidosEdit)
                            .addComponent(lblTipoidEdit))
                        .addGap(85, 85, 85)
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombresEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccionEdit)
                            .addComponent(lblNombresEdit)))
                    .addComponent(txtTipoidEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstadocivilEdit)
                            .addComponent(lblTelefonoEdit))
                        .addGroup(jPEditarLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtEstadocivilEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSexoEdit)
                    .addComponent(lblFechanacimientoEdit)
                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(txtFechanacimientoEdit))
                .addGap(24, 24, 24))
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(btnActualizar)
                        .addGap(71, 71, 71)
                        .addComponent(btnEliminar))
                    .addGroup(jPEditarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPEditarLayout.setVerticalGroup(
            jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioID)
                    .addComponent(lblTipoidEdit)
                    .addComponent(lblNombresEdit)
                    .addComponent(lblEstadocivilEdit)
                    .addComponent(lblSexoEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoidEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombresEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadocivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroidEdit)
                    .addComponent(lblApellidosEdit)
                    .addComponent(lblDireccionEdit)
                    .addComponent(lblTelefonoEdit)
                    .addComponent(lblFechanacimientoEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroidEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechanacimientoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTPanels.addTab("Editar", jPanel2);

        jLabel4.setText("FuncionarioID");

        jLabel5.setText("Nombres");

        jLabel6.setText("Apellidos");

        jLabel7.setText("Parentesco");

        txtFunId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFunIdActionPerformed(evt);
            }
        });

        txtNombresGp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresGpActionPerformed(evt);
            }
        });

        txtApellidosGp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosGpActionPerformed(evt);
            }
        });

        txtParentescoGp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParentescoGpActionPerformed(evt);
            }
        });

        btnCrearGp.setText("Crear");
        btnCrearGp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearGpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCrearLayout = new javax.swing.GroupLayout(jPCrear);
        jPCrear.setLayout(jPCrearLayout);
        jPCrearLayout.setHorizontalGroup(
            jPCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCrearLayout.createSequentialGroup()
                .addGroup(jPCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCrearLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(txtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCrearLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel4)))
                .addGroup(jPCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCrearLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCrearLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(txtNombresGp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCrearLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(jPCrearLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(txtApellidosGp, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(txtParentescoGp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(jPCrearLayout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(btnCrearGp)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPCrearLayout.setVerticalGroup(
            jPCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCrearLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombresGp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidosGp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParentescoGp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(btnCrearGp)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        tblGruposFamiliares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblGruposFamiliares);

        tblFuncionarios1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblFuncionarios1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTPanels.addTab("Crear Grp Fam", jPanel1);

        cbxGrupoFamiliarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGrupoFamiliarEditActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Funcionario");

        jLabel8.setText("Nombres");

        jLabel9.setText("Apellidos");

        jLabel10.setText("Parentesco");

        txtApellidosGpEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosGpEditActionPerformed(evt);
            }
        });

        btnActualizarGp.setText("Actualizar");
        btnActualizarGp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarGpActionPerformed(evt);
            }
        });

        btnEliminarGp.setText("Eliminar");

        javax.swing.GroupLayout jPEditar1Layout = new javax.swing.GroupLayout(jPEditar1);
        jPEditar1.setLayout(jPEditar1Layout);
        jPEditar1Layout.setHorizontalGroup(
            jPEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditar1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEditar1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel9)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel10)
                        .addGap(61, 61, 61))
                    .addGroup(jPEditar1Layout.createSequentialGroup()
                        .addComponent(cbxGrupoFamiliarEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPEditar1Layout.createSequentialGroup()
                        .addComponent(txtFunIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addGroup(jPEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPEditar1Layout.createSequentialGroup()
                                .addComponent(btnActualizarGp)
                                .addGap(136, 136, 136)
                                .addComponent(btnEliminarGp)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPEditar1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtNombresGpEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtApellidosGpEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtParentescoGpEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))))
        );
        jPEditar1Layout.setVerticalGroup(
            jPEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditar1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cbxGrupoFamiliarEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFunIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombresGpEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidosGpEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParentescoGpEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(jPEditar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarGp)
                    .addComponent(btnEliminarGp))
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPEditar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 251, Short.MAX_VALUE))
        );

        jTPanels.addTab("Editar Grp Fam", jPanel3);

        getContentPane().add(jTPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 750, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSexoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTipoidEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoidEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoidEditActionPerformed

    private void txtNumeroidEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroidEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroidEditActionPerformed

    private void txtEstadocivilEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadocivilEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadocivilEditActionPerformed

    private void txtNombresEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresEditActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Funcionario selectedFuncionario = (Funcionario) cbxFuncionarios.getSelectedItem();

        if (selectedFuncionario == null || selectedFuncionario.getNombres().equals(SELECCIONE)) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario para actualizar");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de actualizar el funcionario?", "Confirmar Actualización", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                int id = selectedFuncionario.getId();

             
                String nuevoTipoid = txtTipoidEdit.getText().trim();
                String nuevoNumeroid = txtNumeroidEdit.getText().trim();
                String nuevoNombres = txtNombresEdit.getText().trim();
                String nuevoApellidos = txtApellidosEdit.getText().trim();
                String nuevoEstadocivil = txtEstadocivilEdit.getText().trim();
                String nuevoSexo = txtSexoEdit.getText().trim();
                String nuevoDireccion = txtDireccionEdit.getText().trim();
                String nuevoTelefono = txtTelefonoEdit.getText().trim();
                String nuevoFechanacimiento = txtFechanacimientoEdit.getText().trim();

      
                Funcionario funcionarioActualizado = new Funcionario();
                funcionarioActualizado.setTipoid(nuevoTipoid);
                funcionarioActualizado.setNumeroid(nuevoNumeroid);
                funcionarioActualizado.setNombres(nuevoNombres);
                funcionarioActualizado.setApellidos(nuevoApellidos);
                funcionarioActualizado.setEstadocivil(nuevoEstadocivil);
                funcionarioActualizado.setSexo(nuevoSexo);
                funcionarioActualizado.setDireccion(nuevoDireccion);
                funcionarioActualizado.setTelefono(nuevoTelefono);
                funcionarioActualizado.setFechanacimiento(nuevoFechanacimiento);

      
                funcionarioController.actualizarFuncionario(id, funcionarioActualizado);
                listFuncionarios();
                JOptionPane.showMessageDialog(null, "Funcionario actualizado con éxito");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el funcionario");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        if (txtTipoid.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el tipo de idetificacion");
            txtTipoid.requestFocus();
            return;
        }

        if (txtNumeroid.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el numero de idetificacion");
            txtNumeroid.requestFocus();
            return;
        }

        if (txtNombres.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite su Nombre/s");
            txtNombres.requestFocus();
            return;
        }

        if (txtApellidos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite su Apellidos");
            txtNombres.requestFocus();
            return;
        }

        if (txtEstadocivil.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite su Estado Civil");
            txtEstadocivil.requestFocus();
            return;
        }

        if (txtSexo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite su Sexo");
            txtSexo.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite su Direccion");
            txtDireccion.requestFocus();
            return;
        }

        if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite su Telefono");
            txtTelefono.requestFocus();
            return;
        }

        if (txtFechanacimiento.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite su Fecha de Nacimiento");
            txtFechanacimiento.requestFocus();
            return;
        }

        try {

            Funcionario funcionario = new Funcionario();
            funcionario.setTipoid(txtTipoid.getText().trim());
            funcionario.setNumeroid(txtNumeroid.getText().trim());
            funcionario.setNombres(txtNombres.getText().trim());
            funcionario.setApellidos(txtApellidos.getText().trim());
            funcionario.setEstadocivil(txtEstadocivil.getText().trim());
            funcionario.setSexo(txtSexo.getText().trim());
            funcionario.setDireccion(txtDireccion.getText().trim());
            funcionario.setTelefono(txtTelefono.getText().trim());
            funcionario.setFechanacimiento(txtFechanacimiento.getText().trim());

            funcionarioController.crear(funcionario);

            txtTipoid.setText("");
            txtNumeroid.setText("");
            txtNombres.setText("");
            txtApellidos.setText("");
            txtEstadocivil.setText("");
            txtSexo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtFechanacimiento.setText("");
            listFuncionarios();
            JOptionPane.showMessageDialog(null, "Funcionario creado con exito");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo crear el funcionario");
        }

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Funcionario selectedFuncionario = (Funcionario) cbxFuncionarios.getSelectedItem();

        if (selectedFuncionario == null || selectedFuncionario.getNombres().equals(SELECCIONE)) {
            JOptionPane.showMessageDialog(null, "Seleccione un funcionario para eliminar");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el funcionario?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                int id = selectedFuncionario.getId();
                funcionarioController.eliminarFuncionario(id);
                listFuncionarios();
                JOptionPane.showMessageDialog(null, "Funcionario eliminado con éxito");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el funcionario");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtApellidosGpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosGpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosGpActionPerformed

    private void txtParentescoGpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParentescoGpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParentescoGpActionPerformed

    private void txtFunIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFunIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFunIdActionPerformed

    private void btnCrearGpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearGpActionPerformed

        if (txtFunId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el ID del funcionario");
            txtFunId.requestFocus();
            return;
        }

        if (txtNombresGp.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el ID del funcionario");
            txtNombresGp.requestFocus();
            return;
        }

        if (txtApellidosGp.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el ID del funcionario");
            txtApellidosGp.requestFocus();
            return;
        }

        if (txtParentescoGp.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el ID del funcionario");
            txtParentescoGp.requestFocus();
            return;
        }

        try {
            int funcionarioId = Integer.parseInt(txtFunId.getText().trim());

            GrupoFamiliar grupoFamiliar = new GrupoFamiliar();
            grupoFamiliar.setFuncionarioId(funcionarioId);
            grupoFamiliar.setNombres(txtNombresGp.getText().trim());
            grupoFamiliar.setApellidos(txtApellidosGp.getText().trim());
            grupoFamiliar.setParentesco(txtParentescoGp.getText().trim());

            grupoFamiliarController.crear(grupoFamiliar);

            txtFunId.setText("");
            txtNombresGp.setText("");
            txtApellidosGp.setText("");
            txtParentescoGp.setText("");

            listGruposFamiliares();
            JOptionPane.showMessageDialog(null, "Funcionario creado con éxito");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo crear el funcionario");
        }


    }//GEN-LAST:event_btnCrearGpActionPerformed

    private void txtNombresGpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresGpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresGpActionPerformed

    private void txtApellidosGpEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosGpEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosGpEditActionPerformed

    private void btnActualizarGpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarGpActionPerformed
        GrupoFamiliar selectedGrupoFamiliar = (GrupoFamiliar) cbxGrupoFamiliarEdit.getSelectedItem();

        if (selectedGrupoFamiliar == null || selectedGrupoFamiliar.getNombres().equals(SELECCIONE1)) {
            JOptionPane.showMessageDialog(null, "Seleccione un grupo familiar para actualizar");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de actualizar el grupo familiar?", "Confirmar Actualización", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                int id = selectedGrupoFamiliar.getId();

                
                String nuevosNombres = txtNombresGpEdit.getText().trim();
                String nuevosApellidos = txtApellidosGpEdit.getText().trim();
                String nuevoParentesco = txtParentescoGpEdit.getText().trim();

              
                GrupoFamiliar grupoFamiliarActualizado = new GrupoFamiliar();
                grupoFamiliarActualizado.setNombres(nuevosNombres);
                grupoFamiliarActualizado.setApellidos(nuevosApellidos);
                grupoFamiliarActualizado.setParentesco(nuevoParentesco);


                grupoFamiliarController.actualizarGrupoFamiliar(id, grupoFamiliarActualizado);
                listGruposFamiliares();
                JOptionPane.showMessageDialog(null, "Grupo familiar actualizado con éxito");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el grupo familiar");
            }
        }

    }//GEN-LAST:event_btnActualizarGpActionPerformed

    private void cbxGrupoFamiliarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGrupoFamiliarEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxGrupoFamiliarEditActionPerformed

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
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarGp;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnCrearGp;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarGp;
    private javax.swing.JComboBox<Funcionario> cbxFuncionarios;
    private javax.swing.JComboBox<String> cbxGrupoFamiliarEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPCampus;
    private javax.swing.JPanel jPCrear;
    private javax.swing.JPanel jPEditar;
    private javax.swing.JPanel jPEditar1;
    private javax.swing.JPanel jPFun;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTPanels;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblApellidosEdit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionEdit;
    private javax.swing.JLabel lblEstadocivil;
    private javax.swing.JLabel lblEstadocivilEdit;
    private javax.swing.JLabel lblFechanacimiento;
    private javax.swing.JLabel lblFechanacimientoEdit;
    private javax.swing.JLabel lblFuncionarioID;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNombresEdit;
    private javax.swing.JLabel lblNumeroid;
    private javax.swing.JLabel lblNumeroidEdit;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoEdit;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoEdit;
    private javax.swing.JLabel lblTipoid;
    private javax.swing.JLabel lblTipoidEdit;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTable tblFuncionarios1;
    private javax.swing.JTable tblGruposFamiliares;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosEdit;
    private javax.swing.JTextField txtApellidosGp;
    private javax.swing.JTextField txtApellidosGpEdit;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEdit;
    private javax.swing.JTextField txtEstadocivil;
    private javax.swing.JTextField txtEstadocivilEdit;
    private javax.swing.JTextField txtFechanacimiento;
    private javax.swing.JTextField txtFechanacimientoEdit;
    private javax.swing.JTextField txtFunId;
    private javax.swing.JTextField txtFunIdEdit;
    private javax.swing.JTextField txtFuncionarioId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNombresEdit;
    private javax.swing.JTextField txtNombresGp;
    private javax.swing.JTextField txtNombresGpEdit;
    private javax.swing.JTextField txtNumeroid;
    private javax.swing.JTextField txtNumeroidEdit;
    private javax.swing.JTextField txtParentescoGp;
    private javax.swing.JTextField txtParentescoGpEdit;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoEdit;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEdit;
    private javax.swing.JTextField txtTipoid;
    private javax.swing.JTextField txtTipoidEdit;
    // End of variables declaration//GEN-END:variables
}
