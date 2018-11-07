package Vista;

import Controlador.Coordinador;
import Modelo.ColorVo;
import Modelo.LocalVo;
import Modelo.ProductoVo;
import Modelo.SubcategoryVo;
import Modelo.TallaVo;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class Productos extends javax.swing.JInternalFrame {

    private Coordinador miCoordinador;
    DefaultComboBoxModel modeloColor;
    DefaultComboBoxModel modeloSubcategory;
    DefaultComboBoxModel modeloTalla;
    DefaultComboBoxModel modeloLocal;

    private ArrayList<ColorVo> colores;
    private ProductoVo producto;
    private ArrayList<SubcategoryVo> subcategories;
    private ArrayList<TallaVo> tallas;
    private ArrayList<LocalVo> locales;

    private boolean isArt;
    private boolean isColor;
    private boolean isSize;

    private File src1File;
    private String src1Name;
    private File src2File;
    private String src2Name;
    private File src3File;
    private String src3Name;
    private String cod_barras;

    private FTPUploader  ftpUploader;
    public Productos() {
        initComponents();
        
        AutoCompleteDecorator.decorate(comboColor);
        //setLocationRelativeTo(null);
       // setSize(1280, 800);

        colores = new ArrayList<>();
        producto = new ProductoVo();
        subcategories = new ArrayList<>();
        tallas = new ArrayList<>();

        isArt = false;
        isColor = false;
        isSize = false;
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
        setLocales();
        getColores();
    }

    public void getColores() {
        colores = miCoordinador.buscarColores();
        
        
    }

    public void SetColores(ArrayList<ColorVo> colors) {
        for (int i = 0; i < colors.size(); i++) {
            modeloColor.addElement(""+colors.get(i).getColor_name());
        }
        ColoriarComboBox();
    }

    public void ColoriarComboBox() {

        try {
            comboColor.setRenderer(new Coloriar<String>());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    class Coloriar<String> extends JLabel implements ListCellRenderer {

        public Coloriar() {
            super();
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());

            Object texto = modeloColor.getElementAt(index);

            if (texto != null && index > 0) {
                Color color = Color.decode(colores.get(index - 1).getColor_hex_code());
                setBackground(Color.WHITE);
                setForeground(color);

                if (isSelected) {
                    setBackground(color);
                    setForeground(Color.WHITE);
                    txtBackColor.setBackground(color);
                }
            } else {
                setForeground(Color.BLACK);
            }
            return this;
        }
    }

    public void getDetallesProducto(String art) {
        ProductoVo product = miCoordinador.getDetallesProducto(codigoArtCadena(art));
        if (product.getArt() != null) {
            producto = product;
            this.SetDetallesProducto(producto);
            isArt = true;
        } else {
            System.out.println("producto no encontrado");
            JOptionPane.showMessageDialog(null,"Producto no encontrado");
        }
    }

     public void setLocales() {
        
        modeloLocal = new DefaultComboBoxModel();
        //modeloLocal.addElement("Seleccionar...");

        locales = miCoordinador.obtenerLocales();
    

            for (int i = 0; i < locales.size(); i++) {
                modeloLocal.addElement(locales.get(i).getId_local()+"-"+locales.get(i).getNombre());
            }
            comboLocal.setModel(modeloLocal);
        }
     
        
    
    public void SetDetallesProducto(ProductoVo producto) {
        txtName.setText(producto.getArt_name());
        txtPrice.setText(producto.getPrice().toString());
        txtDescrip.setText(producto.getDescription());
        txtCompo.setText(producto.getComposition());
        comboCategory.setSelectedIndex(producto.getId_category());
        comboType.setSelectedIndex(producto.getId_type_product());
       // comboSub.setSelectedIndex(1-producto.getId_subcategory());
    }

    public void SetTallas() {
        Integer id_cat = producto.getId_category();
        Integer id_type = producto.getId_type_product();
        String color_art = producto.getColor_art();

        modeloTalla = new DefaultComboBoxModel();
        modeloTalla.addElement("Seleccionar...");

        producto.setId_size(null);

        if (id_cat != null && id_type != null && color_art != null) {
            tallas = miCoordinador.getTallas(id_cat, id_type);

            for (int i = 0; i < tallas.size(); i++) {
                modeloTalla.addElement(tallas.get(i).getSize_name());
            }
        }
        comboSize.setModel(modeloTalla);
    }
    
    public String codigoArtCadena(String art){
    String codigo = art.trim();
   String cadena="";
   if(codigo.length()>5){
   cadena = codigo.substring(2, 7);
   }
   else if(codigo.length()==5){
   cadena = codigo;
   }
   System.out.print(cadena);
   return cadena;
            }
    
    public void cargarImagenes(int opc){
         //Comprobar src vacÃ­os
        String srcFile1 = producto.getSrc1();
        String srcFile2 = producto.getSrc2();
        String srcFile3 = producto.getSrc3();
        
          //Rutas para el src
            String category = comboCategory.getItemAt(comboCategory.getSelectedIndex());
            String subcategory = comboSub.getItemAt(comboSub.getSelectedIndex());
            String color = colores.get(comboColor.getSelectedIndex() - 1).getColor_name();

            String path = category + "/" + subcategory;
            String src = producto.getArt_name() + " " + color + " " ;
            
            
          switch(opc){
              case 1:
                try {
            String value = new String(src.getBytes("UTF-8"), "ISO-8859-1");
            String value2 = new String(path.getBytes("UTF-8"), "ISO-8859-1");
            
                    ftpUploader = new FTPUploader("www.genesysmi.com", "genesysmi@genesysmi.com", "65i1r3WqQd",src1File.getPath(),value+src1Name,"/img/products/" + value2+"/");
                } catch (Exception ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                producto.setSrc1(path + "/" + src + src1Name);    
          break;
              case 2:
                try {
            String value = new String(src.getBytes("UTF-8"), "ISO-8859-1");
            String value2 = new String(path.getBytes("UTF-8"), "ISO-8859-1");
            
                    ftpUploader = new FTPUploader("www.genesysmi.com", "genesysmi@genesysmi.com", "65i1r3WqQd",src2File.getPath(),value+src2Name,"/img/products/" + value2+"/");
                } catch (Exception ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
                producto.setSrc2(path + "/" + src + src2Name);
                break;
              case 3:
                 try {
            String value = new String(src.getBytes("UTF-8"), "ISO-8859-1");
            String value2 = new String(path.getBytes("UTF-8"), "ISO-8859-1");
            
                    ftpUploader = new FTPUploader("www.genesysmi.com", "genesysmi@genesysmi.com", "65i1r3WqQd",src3File.getPath(),value+src3Name,"/img/products/" + value2+"/");
                } catch (Exception ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }    producto.setSrc3(path + "/" + src + src3Name);
                break;
          
          }
            
           
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        comboCategory = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboSub = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescrip = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCompo = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        comboSize = new javax.swing.JComboBox<>();
        txtCant = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnmas = new javax.swing.JButton();
        btnmenos = new javax.swing.JButton();
        comboLocal = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnImage2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnImage1 = new javax.swing.JButton();
        checkSrc3 = new javax.swing.JCheckBox();
        btnImage3 = new javax.swing.JButton();
        checkSrc2 = new javax.swing.JCheckBox();
        checkSrc1 = new javax.swing.JCheckBox();
        txtBackColor = new javax.swing.JTextField();
        comboColor = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel2.setBackground(new java.awt.Color(237, 237, 237));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 65, 92));
        jPanel1.setForeground(new java.awt.Color(50, 194, 77));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Baghdad", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Agregar/Editar producto");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(1, 129, 176));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Articulo:");

        txtCode.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCode.setCaretColor(new java.awt.Color(51, 51, 51));
        txtCode.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeKeyTyped(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(153, 255, 102));
        btnBuscar.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/IconSearch.png"))); // NOI18N
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 2, true));
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(1, 129, 176));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria:");

        comboCategory.setBackground(new java.awt.Color(242, 242, 242));
        comboCategory.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboCategory.setForeground(new java.awt.Color(51, 51, 51));
        comboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Recién nacido/Ellas", "Recién nacido/Ellos", "Baby/Ellas", "Baby/Ellos", "Mini/Ellas", "Mini/Ellos", "Junior/Ellas", "Junior/Ellos", "Accesorios y regalos" }));
        comboCategory.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoryActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Subcategoria:");

        comboSub.setBackground(new java.awt.Color(242, 242, 242));
        comboSub.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboSub.setForeground(new java.awt.Color(51, 51, 51));
        comboSub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        comboSub.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo de producto:");

        comboType.setBackground(new java.awt.Color(242, 242, 242));
        comboType.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboType.setForeground(new java.awt.Color(51, 51, 51));
        comboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Ropa", "Zapatos", "Otro" }));
        comboType.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypeActionPerformed(evt);
            }
        });

        txtDescrip.setBackground(new java.awt.Color(242, 242, 242));
        txtDescrip.setColumns(20);
        txtDescrip.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtDescrip.setLineWrap(true);
        txtDescrip.setRows(5);
        txtDescrip.setWrapStyleWord(true);
        txtDescrip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDescrip.setCaretColor(new java.awt.Color(51, 51, 51));
        txtDescrip.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(txtDescrip);

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Descripcion:");

        txtCompo.setBackground(new java.awt.Color(242, 242, 242));
        txtCompo.setColumns(20);
        txtCompo.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtCompo.setLineWrap(true);
        txtCompo.setRows(5);
        txtCompo.setWrapStyleWord(true);
        txtCompo.setAutoscrolls(false);
        txtCompo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCompo.setCaretColor(new java.awt.Color(51, 51, 51));
        txtCompo.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(txtCompo);

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Composicion:");

        btnAdd.setBackground(new java.awt.Color(0, 37, 145));
        btnAdd.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(237, 237, 237));
        btnCancel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 37, 145));
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Talla:");

        comboSize.setBackground(new java.awt.Color(242, 242, 242));
        comboSize.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboSize.setForeground(new java.awt.Color(51, 51, 51));
        comboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        comboSize.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSizeActionPerformed(evt);
            }
        });

        txtCant.setBackground(new java.awt.Color(242, 242, 242));
        txtCant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCant.setText("0");
        txtCant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCant.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtCantPropertyChange(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cantidad:");

        txtName.setBackground(new java.awt.Color(242, 242, 242));
        txtName.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtName.setCaretColor(new java.awt.Color(51, 51, 51));
        txtName.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio:");

        txtPrice.setBackground(new java.awt.Color(242, 242, 242));
        txtPrice.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        txtPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPrice.setCaretColor(new java.awt.Color(51, 51, 51));
        txtPrice.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        btnmas.setBackground(new java.awt.Color(0, 37, 145));
        btnmas.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnmas.setForeground(new java.awt.Color(255, 255, 255));
        btnmas.setText("+");
        btnmas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmasActionPerformed(evt);
            }
        });

        btnmenos.setBackground(new java.awt.Color(0, 37, 145));
        btnmenos.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnmenos.setForeground(new java.awt.Color(255, 255, 255));
        btnmenos.setText("-");
        btnmenos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmenos.setMaximumSize(new java.awt.Dimension(41, 27));
        btnmenos.setMinimumSize(new java.awt.Dimension(41, 27));
        btnmenos.setName(""); // NOI18N
        btnmenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenosActionPerformed(evt);
            }
        });

        comboLocal.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboLocal.setForeground(new java.awt.Color(51, 51, 51));
        comboLocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Ropa", "Zapatos", "Otro" }));
        comboLocal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        comboLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboLocalMouseClicked(evt);
            }
        });
        comboLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLocalActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Local:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboSub, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboLocal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnmas, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnmenos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(comboSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(comboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(42, 42, 42))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnmas)
                                .addGap(23, 23, 23)
                                .addComponent(btnmenos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel5.setBackground(new java.awt.Color(1, 129, 176));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Colores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnImage2.setBackground(new java.awt.Color(237, 237, 237));
        btnImage2.setForeground(new java.awt.Color(51, 51, 51));
        btnImage2.setText("Examinar");
        btnImage2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImage2ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Imagen #1");

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Imagen #3");

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Imagen #2");

        btnImage1.setBackground(new java.awt.Color(237, 237, 237));
        btnImage1.setForeground(new java.awt.Color(51, 51, 51));
        btnImage1.setText("Examinar");
        btnImage1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImage1ActionPerformed(evt);
            }
        });

        checkSrc3.setEnabled(false);

        btnImage3.setBackground(new java.awt.Color(237, 237, 237));
        btnImage3.setForeground(new java.awt.Color(51, 51, 51));
        btnImage3.setText("Examinar");
        btnImage3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImage3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImage3ActionPerformed(evt);
            }
        });

        checkSrc2.setEnabled(false);

        checkSrc1.setEnabled(false);

        txtBackColor.setEditable(false);
        txtBackColor.setAutoscrolls(false);
        txtBackColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtBackColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBackColorActionPerformed(evt);
            }
        });

        comboColor.setBackground(new java.awt.Color(242, 242, 242));
        comboColor.setEditable(true);
        comboColor.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 14)); // NOI18N
        comboColor.setForeground(new java.awt.Color(51, 51, 51));
        comboColor.setMaximumRowCount(12);
        comboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));
        comboColor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        comboColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColorActionPerformed(evt);
            }
        });
        comboColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comboColorKeyTyped(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Apple SD Gothic Neo", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Color:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(60, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtBackColor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addComponent(jLabel12)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkSrc3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkSrc2)
                            .addComponent(checkSrc1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(12, 12, 12))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(btnImage1))
                    .addComponent(checkSrc1))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtBackColor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkSrc2)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnImage2)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkSrc3)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnImage3)
                                .addComponent(jLabel12)))))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ProductoVo pro = new ProductoVo();
        ProductoVo prod = new ProductoVo();
        ProductoVo pr ;
        int local_index = comboLocal.getSelectedIndex() + 1;
        
        txtCode.setText(producto.getArt());
        producto.setId_local(local_index);
        producto.setArt_name(txtName.getText());
        producto.setComposition(txtCompo.getText());
        producto.setDescription(txtDescrip.getText());

        String textPrice = txtPrice.getText();
        if (!textPrice.equals("")) {
            producto.setPrice(Double.parseDouble(textPrice));
        } else {
            producto.setPrice(null);
        }

        String textCant = txtCant.getText();
        
        int amount = 0;
        if (!textCant.equals("")) {
            amount = Integer.parseInt(textCant);
        }
           
            
        //AquÃ­ ocurre la magia
        if (producto.getArt() != null && !producto.getArt_name().equals("")
                && producto.getColor_art() != null && !producto.getComposition().equals("")
                && !producto.getDescription().equals("") && producto.getId_category() != null
                && producto.getId_size() != null && producto.getId_subcategory() != null
                && producto.getId_type_product() != null && producto.getPrice() != null
                 ) {
// && producto.getSrc1() != null
          
int idaux1 = miCoordinador.getSigId() + 1;
producto.setId_local_destino(idaux1);

            if (isArt) {
                miCoordinador.UpdateProductDetails(producto);
                if (isColor) {
                    miCoordinador.UpdateProduct(producto);
                    if (isSize) {
                        producto.setAmount(amount);
                        miCoordinador.UpdateProductSizes(producto);
                    } else {
                        producto.setAmount(amount);
                        miCoordinador.InsertProductSizes(producto);
                    }
                } else {
                    producto.setAmount(amount);
                    miCoordinador.InsertProduct(producto);
                    miCoordinador.InsertProductSizes(producto);
                }
            } else {
                producto.setAmount(amount);
                miCoordinador.InsertProductDetails(producto);
                miCoordinador.InsertProduct(producto);
                miCoordinador.InsertProductSizes(producto);
            }
            
            pr = miCoordinador.getCode(cod_barras);
            System.out.println(pr.getId_type_product());
            
            if(pr.getId_type_product() == null){           
            int idaux = miCoordinador.getSigId() + 1;
                                    
            prod.setType_product_name(cod_barras);            
            prod.setArt_name(producto.getArt_name());
            
            pro.setId_type_product(idaux);
            pro.setArt(producto.getArt());            
            pro.setColor_art(producto.getColor_art());
            pro.setId_size(producto.getId_size());
            
            miCoordinador.insertCode(prod);
            miCoordinador.updateCodigo(pro);
            
            }
            
            
            txtCode.setText("");
            btnBuscar.doClick();
JOptionPane.showMessageDialog(null, "Producto Agregado Satisfactoriamente", "Completo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Completa todos los campos", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        cod_barras = txtCode.getText().trim();
        String art = codigoArtCadena(txtCode.getText());
        producto = new ProductoVo();
        
        
        modeloColor = new DefaultComboBoxModel();
        comboColor.setModel(modeloColor);
        modeloColor.addElement(" Seleccionar...");

        txtBackColor.setBackground(Color.WHITE);

        comboColor.setSelectedIndex(0);
        comboCategory.setSelectedIndex(0);
        comboType.setSelectedIndex(0);

        txtName.setText("");
        txtPrice.setText("");
        txtDescrip.setText("");
        txtCompo.setText("");

        isArt = false;
        isColor = false;
        isSize = false;

        if (!art.equals("")) {
            producto.setArt(art);
            SetColores(colores);
            //this.getColores();
            this.getDetallesProducto(art);
        } else {
            producto.setArt(null);
        }
       // System.out.println(cod_barras);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void comboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoryActionPerformed
        
        Integer cat_index = comboCategory.getSelectedIndex();

        modeloSubcategory = new DefaultComboBoxModel();
        modeloSubcategory.addElement("Seleccionar...");

        Integer sub_index = -1;

        if (cat_index > 0) {
            
            producto.setId_category(cat_index);

            subcategories = miCoordinador.getSubcategories(cat_index);

            for (int i = 0; i < subcategories.size(); i++) {
                
                System.out.println(subcategories.get(i).getId_subcategory());
                modeloSubcategory.addElement(subcategories.get(i).getSucategory_name());
                if (subcategories.get(i).getId_subcategory().equals(producto.getId_subcategory())) {
                    sub_index = i;
                    
                }
                
            }
        } else {
            producto.setId_category(null);
        }
        SetTallas();
System.out.println(sub_index);
        comboSub.setModel(modeloSubcategory);
        if ((sub_index+1) > 0) {
            comboSub.setSelectedIndex(sub_index + 1);
        
        }
        else {
            
            comboSub.setSelectedIndex(0);
        }
      
    }//GEN-LAST:event_comboCategoryActionPerformed

    private void comboColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColorActionPerformed
        // TODO add your handling code here:
        isColor = false;
        int color_index = comboColor.getSelectedIndex();
        if (color_index > 0) {
            producto.setColor_art(colores.get(color_index - 1).getColor_art());

            ProductoVo product = miCoordinador.getSrcProducto(producto.getArt(), producto.getColor_art());

            producto.setSrc1(product.getSrc1());
            producto.setSrc2(product.getSrc2());
            producto.setSrc3(product.getSrc3());

            if (producto.getSrc1() != null) {

                isColor = true;

                checkSrc1.setSelected(true);
            } else {
                checkSrc1.setSelected(false);
            }
            if (producto.getSrc2() != null) {
                checkSrc2.setSelected(true);
            } else {
                checkSrc2.setSelected(false);
            }
            if (producto.getSrc3() != null) {
                checkSrc3.setSelected(true);
            } else {
                checkSrc3.setSelected(false);
            }
        } else {
            producto.setColor_art(null);
            producto.setSrc1(null);
            producto.setSrc2(null);
            producto.setSrc3(null);
            checkSrc1.setSelected(false);
            checkSrc2.setSelected(false);
            checkSrc3.setSelected(false);
        }
        SetTallas();
    }//GEN-LAST:event_comboColorActionPerformed

    private void comboTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypeActionPerformed
        // TODO add your handling code here:
        Integer type_index = comboType.getSelectedIndex();
        if (type_index > 0) {
            producto.setId_type_product(type_index);
        } else {
            producto.setId_type_product(null);
        }
        SetTallas();
    }//GEN-LAST:event_comboTypeActionPerformed

    private void comboSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSizeActionPerformed
        // TODO add your handling code here:
        Integer size_index = comboSize.getSelectedIndex();
        if (size_index > 0) {
            producto.setId_size(tallas.get(size_index - 1).getId_size());

            ProductoVo product = miCoordinador.getAmountProducto(producto.getArt(), producto.getColor_art(), producto.getId_size());
            comboLocal.setSelectedIndex(product.getId_local()-1);
            Integer amount = product.getAmount();
            if (amount != null) {
                producto.setAmount(amount);
                txtCant.setText(amount.toString()); 
                isSize = true;
            } else {
                isSize = false;
                txtCant.setText("0");
                producto.setAmount(null);
            }
        } else {
            producto.setId_size(null);
        }
    }//GEN-LAST:event_comboSizeActionPerformed

    private void comboSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubActionPerformed
        // TODO add your handling code here:
        Integer sub_index = comboSub.getSelectedIndex();
        if (sub_index > 0) {
            producto.setId_subcategory(subcategories.get(sub_index - 1).getId_subcategory());
        } else {
            producto.setId_subcategory(null);
        }
    }//GEN-LAST:event_comboSubActionPerformed

    private void btnImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImage1ActionPerformed
if(txtName.getText()!=null && comboCategory.getSelectedIndex()>0 && comboSub.getSelectedIndex()>0){        
        JFileChooser dir = new JFileChooser();
        int option = dir.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            src1File = dir.getSelectedFile();
            
            String fileName = dir.getName(dir.getSelectedFile());
            String color = colores.get(comboColor.getSelectedIndex()-1).getColor_art();
            String art = producto.getArt();
            
            src1Name = fileName;
            cargarImagenes(1);
            checkSrc1.setSelected(true);
            
        } else {
            checkSrc1.setSelected(false);
        }
        
    }//GEN-LAST:event_btnImage1ActionPerformed
else{
JOptionPane.showMessageDialog(null, "Completa los campos correspondientes faltantes", "ERROR", JOptionPane.INFORMATION_MESSAGE);
}
    }
    private void btnImage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImage2ActionPerformed
        if(txtName.getText()!=null && comboCategory.getSelectedIndex()>0 && comboSub.getSelectedIndex()>0){
        JFileChooser dir = new JFileChooser();
        int option = dir.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
             src2File = dir.getSelectedFile();
            String fileName = dir.getName(dir.getSelectedFile());

            src2Name = fileName;
            checkSrc2.setSelected(true);
               cargarImagenes(2);
        } else {
            checkSrc2.setSelected(false);
        }     
    }//GEN-LAST:event_btnImage2ActionPerformed
else{
JOptionPane.showMessageDialog(null, "Completa los campos correspondientes faltantes", "ERROR", JOptionPane.INFORMATION_MESSAGE);
}
    }
    private void btnImage3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImage3ActionPerformed
        if(txtName.getText()!=null && comboCategory.getSelectedIndex()>0 && comboSub.getSelectedIndex()>0){
        JFileChooser dir = new JFileChooser();
        int option = dir.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            src3File = dir.getSelectedFile();
            String fileName = dir.getName(dir.getSelectedFile());

            src3Name = fileName;
            checkSrc3.setSelected(true);
               cargarImagenes(3);
        } else {
            checkSrc3.setSelected(false);
        } 
    }//GEN-LAST:event_btnImage3ActionPerformed
    else{
JOptionPane.showMessageDialog(null, "Completa los campos correspondientes faltantes", "ERROR", JOptionPane.INFORMATION_MESSAGE);
}
    }
    private void btnmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmasActionPerformed
int cantidad = Integer.parseInt(txtCant.getText());
cantidad += 1;
txtCant.setText(Integer.toString(cantidad));
    }//GEN-LAST:event_btnmasActionPerformed

    private void btnmenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenosActionPerformed
int cantidad = Integer.parseInt(txtCant.getText());
cantidad -= 1;
if(cantidad >= 0)
txtCant.setText(Integer.toString(cantidad));
    }//GEN-LAST:event_btnmenosActionPerformed

    private void txtCantPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtCantPropertyChange
        txtCant.setHorizontalAlignment(txtCant.CENTER);
    }//GEN-LAST:event_txtCantPropertyChange

    private void comboLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLocalActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_comboLocalActionPerformed

    private void comboLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboLocalMouseClicked
      // TODO add your handling code here:
    }//GEN-LAST:event_comboLocalMouseClicked

    private void txtCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyTyped
  char c=evt.getKeyChar();
   int ascii = (int)c;
        if(ascii<48 || ascii>57) {
            getToolkit().beep();

            evt.consume();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeKeyTyped

    private void txtBackColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBackColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBackColorActionPerformed

    private void comboColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboColorKeyTyped

    }//GEN-LAST:event_comboColorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnImage1;
    private javax.swing.JButton btnImage2;
    private javax.swing.JButton btnImage3;
    private javax.swing.JButton btnmas;
    private javax.swing.JButton btnmenos;
    private javax.swing.JCheckBox checkSrc1;
    private javax.swing.JCheckBox checkSrc2;
    private javax.swing.JCheckBox checkSrc3;
    private javax.swing.JComboBox<String> comboCategory;
    private javax.swing.JComboBox<String> comboColor;
    private javax.swing.JComboBox<String> comboLocal;
    private javax.swing.JComboBox<String> comboSize;
    private javax.swing.JComboBox<String> comboSub;
    private javax.swing.JComboBox<String> comboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBackColor;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextArea txtCompo;
    private javax.swing.JTextArea txtDescrip;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
