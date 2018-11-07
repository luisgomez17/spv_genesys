package Controlador;
//

import Modelo.ApartadoDao;
import Modelo.ApartadoVo;
import Modelo.BagDao;
import Modelo.BagVo;
import Modelo.ProductoDao;
import Modelo.ProductoVo;
import Vista.Productos;
import Modelo.ColorDao;
import Modelo.ColorVo;
import Modelo.CreditoDao;
import Modelo.CreditoVo;
import Modelo.LocalDao;
import Modelo.LocalVo;
import Modelo.NotaDao;
import Modelo.NotaVo;
import Modelo.SubcategoryDao;
import Modelo.SubcategoryVo;
import Modelo.SystemDao;
import Modelo.SystemVo;
import Modelo.TallaDao;
import Modelo.TallaVo;
import Modelo.UsuarioDao;
import Modelo.UsuarioVo;
import Vista.Login;
import Vista.Colores;
import Vista.DetalleVenta;
import Vista.Inicio;
import Vista.Usuarios;
import Vista.Ventas;
import java.util.ArrayList;
import Modelo.VentaDao;
import Modelo.VentaVo;
import Vista.Abonos;
import Vista.AgregarVendedor;
import Vista.Apartado;
import Vista.ListAbonos;
import Vista.Login1;
import Vista.Multipago;
import Vista.Notas;
import Vista.NotasCredito;
import Vista.NuevaNota;
import Vista.RVentas;
import Vista.Reportes;
import Vista.Total;
import Vista.Vendedores;
import Vista.VentaCredito;
import Vista.cambiarProducto;

public class Coordinador {

    private Login login;
    private Productos productos;
    private Colores color;
    private Inicio inicio;
    private Usuarios usuario;
    private Ventas venta;
    private DetalleVenta detalle;
    private Total total;
    private Reportes reporte;
    private VentaCredito credito;
    private NotasCredito notas;
    private cambiarProducto cambio;
    private Login1 login1;
    private AgregarVendedor add;
    private Vendedores vendedores;
    private Multipago multi;
    private Abonos abono;
    private Notas nc;
    private NuevaNota nn;
    private Apartado apartado;
    private RVentas rventas;
    private ListAbonos listabn;

    public ListAbonos getListabn() {
        return listabn;
    }

    public void setListabn(ListAbonos listabn) {
        this.listabn = listabn;
    }

    public RVentas getRventas() {
        return rventas;
    }

    public void setRventas(RVentas rventas) {
        this.rventas = rventas;
    }

    public Apartado getApartado() {
        return apartado;
    }

    public void setApartado(Apartado apartado) {
        this.apartado = apartado;
    }

    public NuevaNota getNn() {
        return nn;
    }

    public void setNn(NuevaNota nn) {
        this.nn = nn;
    }

    public Notas getNc() {
        return nc;
    }

    public void setNc(Notas nc) {
        this.nc = nc;
    }

    public Abonos getAbono() {
        return abono;
    }

    public void setAbono(Abonos abono) {
        this.abono = abono;
    }

    public Multipago getMulti() {
        return multi;
    }

    public void setMulti(Multipago multi) {
        this.multi = multi;
    }

    public Vendedores getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedores vendedores) {
        this.vendedores = vendedores;
    }

    public AgregarVendedor getAdd() {
        return add;
    }

    public void setAdd(AgregarVendedor add) {
        this.add = add;
    }

    public Login1 getLogin1() {
        return login1;
    }

    public void setLogin1(Login1 login1) {
        this.login1 = login1;
    }

    public cambiarProducto getCambio() {
        return cambio;
    }

    public void setCambio(cambiarProducto cambio) {
        this.cambio = cambio;
    }

    public NotasCredito getNotas() {
        return notas;
    }

    public void setNotas(NotasCredito notas) {
        this.notas = notas;
    }

    public VentaCredito getCredito() {
        return credito;
    }

    public void setCredito(VentaCredito credito) {
        this.credito = credito;
    }

    public Reportes getReporte() {
        return reporte;
    }

    public void setReporte(Reportes reporte) {
        this.reporte = reporte;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public Inicio getInicio() {
        return inicio;
    }

    public void setInicio(Inicio inicio) {
        this.inicio = inicio;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public UsuarioVo buscarUsuario(Integer id_user) {
        UsuarioDao usuario = new UsuarioDao();
        return usuario.getUsuario(id_user);
    }

    public ProductoVo getDetallesProducto(String art) {
        ProductoDao producto = new ProductoDao();
        return producto.getDetallesProducto(art);
    }

    public ProductoVo getDetallesProductoColor(String art, String color) {
        ProductoDao producto = new ProductoDao();
        return producto.getDetallesProductoColor(art, color);
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public ColorVo buscarColor(String color_art) {
        ColorDao dao = new ColorDao();
        return dao.getColor(color_art);
    }

    public ArrayList<ColorVo> buscarColores() {
        ColorDao color = new ColorDao();
        return color.getColores();
    }

    public SystemVo buscarUser(String user, String password) {
        SystemDao system = new SystemDao();
        return system.getUser(user, password);

    }

    public void mostrarColores() {
        getColor().setVisible(true);
    }

    public void mostrarPrincipal() {
        getInicio().setVisible(true);
        getLogin().dispose();
    }

    public void agregarColor(ColorVo color) {
        ColorDao cool = new ColorDao();
        cool.registrarColor(color);
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Ventas getVenta() {
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public ProductoVo getSrcProducto(String art, String color_art) {
        ProductoDao producto = new ProductoDao();
        return producto.getProducto(art, color_art);
    }

    public DetalleVenta getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleVenta detalle) {
        this.detalle = detalle;
    }

    public ArrayList<SubcategoryVo> getSubcategories(Integer id_category) {
        SubcategoryDao subcategories = new SubcategoryDao();
        return subcategories.getSubcategories(id_category);
    }

    public ArrayList<TallaVo> getTallas(Integer id_category, Integer id_type_product) {
        TallaDao tallas = new TallaDao();
        return tallas.getTallas(id_category, id_type_product);
    }

    public ProductoVo getAmountProducto(String art, String color_art, Integer id_size) {
        ProductoDao producto = new ProductoDao();
        return producto.getAmountProducto(art, color_art, id_size);
    }

    public void InsertProductDetails(ProductoVo producto) {
        ProductoDao dao = new ProductoDao();
        dao.InsertProductDetails(producto);
    }

    public void UpdateProductDetails(ProductoVo producto) {
        ProductoDao dao = new ProductoDao();
        dao.UpdateProductDetails(producto);
    }

    public void InsertProduct(ProductoVo producto) {
        ProductoDao dao = new ProductoDao();
        dao.InsertProduct(producto);
    }

    public void UpdateProduct(ProductoVo producto) {
        ProductoDao dao = new ProductoDao();
        dao.UpdateProduct(producto);
    }

    public void InsertProductSizes(ProductoVo producto) {
        ProductoDao dao = new ProductoDao();
        dao.InsertProductSizes(producto);
    }

    public void UpdateProductSizes(ProductoVo producto) {
        ProductoDao dao = new ProductoDao();
        dao.UpdateProductSizes(producto);
    }

    public ArrayList<UsuarioVo> buscarUsuarios() {
        UsuarioDao usuarios = new UsuarioDao();
        return usuarios.getUsuarios();
    }

    public ArrayList<TallaVo> obtenerTallasProducto(String talla) {
        TallaDao tall = new TallaDao();
        return tall.obtener_tallas(talla);

    }

    public ArrayList<ColorVo> obtenerColorProducto(String art, int talla) {
        ColorDao color = new ColorDao();
        return color.getColorArt(art, talla);
    }

    public int obtenerSiguienteId() {
        VentaDao venta = new VentaDao();
        return venta.getLastId();
    }

    public void InsertBag(BagVo bag) {
        BagDao dao = new BagDao();
        dao.InsertBag(bag);
    }

    public void InsertVenta(VentaVo venta) {
        VentaDao dao = new VentaDao();
        dao.InsertCompra(venta);
    }

    public void UpdateProductSizesSales(ProductoVo producto) {
        ProductoDao dao = new ProductoDao();
        dao.UpdateProductSizesSale(producto);
    }

    public void UpdateSizesNota(ProductoVo producto) {
        ProductoDao dao = new ProductoDao();
        dao.UpdateSizesNota(producto);
    }

    public void ActualizarMonedero(UsuarioVo usuario) {
        UsuarioDao dao = new UsuarioDao();
        dao.UpdateMonedero(usuario);
    }

    public ArrayList<VentaVo> selectYears() {
        VentaDao year = new VentaDao();
        return year.getYears();

    }

    public ArrayList<VentaVo> obtenerVentas(String fecha, String fecha2) {
        VentaDao dao = new VentaDao();
        return dao.getSales(fecha, fecha2);
    }

    public ArrayList<BagVo> obtenerProductosVenta(int id) {
        BagDao dao = new BagDao();
        return dao.getProductsSale(id);
    }

    public ArrayList<BagVo> getProductsCreditOnline(int id) {
        BagDao dao = new BagDao();
        return dao.getProductsSaleOnline(id);
    }

    public void ingresarCredito(VentaVo credit) {
        VentaDao compra = new VentaDao();
        compra.InsertCompraCredito(credit);
    }

    public ArrayList<VentaVo> ventasSinCliente(String fecha) {
        VentaDao sincliente = new VentaDao();
        return sincliente.getSalesNoClient(fecha);

    }

    public ArrayList<VentaVo> ventasCredito() {
        VentaDao credito = new VentaDao();
        return credito.getSalesCredit();

    }

    public void pagarDeuda(VentaVo venta) {
        VentaDao cred = new VentaDao();
        cred.UpdateDeuda(venta);
    }

    public void updateTotalNota(VentaVo venta) {
        VentaDao cred = new VentaDao();
        cred.UpdateTotalNota(venta);
    }

    public ArrayList<LocalVo> obtenerLocales() {
        LocalDao dao = new LocalDao();
        return dao.getLocales();
    }

    public ArrayList<ProductoVo> getProductoTienda(int local, String art) {
        ProductoDao pro = new ProductoDao();
        return pro.getProductoTienda(local, art);
    }

    public ArrayList<ProductoVo> getProductoTiendaOnline(int local, String art) {
        ProductoDao pro = new ProductoDao();
        return pro.getProductoTiendaOnline(local, art);

    }

    public ArrayList<ProductoVo> getProductoTiendaCategory(int local, int categoria, int subcategoria) {
        ProductoDao pro = new ProductoDao();
        return pro.getProductoTiendaCategory(local, categoria, subcategoria);
    }

    public ArrayList<ProductoVo> getProductoTiendaCategoryOnline(int local, int categoria, int subcategoria) {
        ProductoDao pro = new ProductoDao();
        return pro.getProductoTiendaCategoryOnline(local, categoria, subcategoria);
    }

    public ArrayList<ColorVo> getColorsArt(String art) {
        ColorDao dao = new ColorDao();
        return dao.getColorsArt(art);
    }

    public ArrayList<TallaVo> getTallasColor(String art, String color) {
        TallaDao talla = new TallaDao();
        return talla.getTallasColor(art, color);
    }

    public ArrayList<VentaVo> getSalesOnline() {
        VentaDao vent = new VentaDao();
        return vent.getSalesOnline();
    }

    public ArrayList<BagVo> getProductsSaleOnline(int id) {
        BagDao dao = new BagDao();
        return dao.getProductsSaleOnline(id);
    }

    public VentaVo getSalesOnlineId(int id) {
        VentaDao vent = new VentaDao();
        return vent.getSalesOnlineId(id);
    }

    public ArrayList<UsuarioVo> getEstados() {
        UsuarioDao user = new UsuarioDao();
        return user.getEstados();
    }

    public ArrayList<UsuarioVo> getLocalidadesPorEstado(int id) {
        UsuarioDao user = new UsuarioDao();
        return user.getLocalidadesPorEstado(id);

    }

    public void agregarUsuario(UsuarioVo usuario) {
        UsuarioDao usu = new UsuarioDao();
        usu.agregarUsuario(usuario);
    }

    public ArrayList<UsuarioVo> getUsuariosBusqueda(String name) {
        UsuarioDao user = new UsuarioDao();
        return user.getUsuariosBusqueda(name);
    }

    public ArrayList<UsuarioVo> getUsuariosBusquedaCredito(String name) {
        UsuarioDao user = new UsuarioDao();
        return user.getUsuariosBusqueda(name);
    }

    public ArrayList<VentaVo> salesCreditId(int id) {
        VentaDao credi = new VentaDao();
        return credi.getSalesCreditId(id);

    }

    public ArrayList<UsuarioVo> getUsuariosCredito() {
        UsuarioDao user = new UsuarioDao();
        return user.getUsuariosCredito();
    }

    public BagVo getBag(int id) {
        BagDao bag = new BagDao();
        return bag.getBag(id);
    }

    public ProductoVo getDetallesProductoColorTalla(String art, String color, int size) {
        ProductoDao details = new ProductoDao();
        return details.getDetallesProductoColorTalla(art, color, size);
    }

    public void updateBag(BagVo bag) {
        BagDao bagg = new BagDao();
        bagg.UpdateBag(bag);
    }

    public void borrarBag(int bag) {
        BagDao bagg = new BagDao();
        bagg.BorrarBag(bag);
    }

    public void InsertTraspaso(ProductoVo producto) {
        ProductoDao pro = new ProductoDao();
        pro.InsertTraspaso(producto);
    }

    public ArrayList<ProductoVo> getTransfer() {
        ProductoDao ducto = new ProductoDao();
        return ducto.getTransfer();
    }

    public void UpdateTransfer(ProductoVo pro) {
        ProductoDao da = new ProductoDao();
        da.UpdateTransfer(pro);
    }

    public void registrarVendedor(SystemVo system) {
        SystemDao d = new SystemDao();
        d.registrarVendedor(system);
    }

    public ArrayList<SystemVo> getListVendedores() {
        SystemDao sys = new SystemDao();
        return sys.getListVendedores();
    }

    public ArrayList<SystemVo> getVendedoresNombre(String nombre) {
        SystemDao sys = new SystemDao();
        return sys.getVendedoresNombre(nombre);
    }

    public ArrayList<VentaVo> getSalesVendedorDia(int id_vendedor, String fecha) {
        VentaDao ven = new VentaDao();
        return ven.getSalesVendedorDia(id_vendedor, fecha);
    }

    public ArrayList<VentaVo> getSalesVendedorMes(int id_vendedor, int mes, int year) {
        VentaDao ven = new VentaDao();
        return ven.getSalesVendedorMes(id_vendedor, mes, year);
    }

    public ArrayList<VentaVo> getSalesVendedorYear(int id_vendedor, int year) {
        VentaDao ven = new VentaDao();
        return ven.getSalesVendedorYear(id_vendedor, year);
    }

    public ArrayList<VentaVo> getSalesVendedorPeriodoVenta(int id_vendedor, String fecha1, String fecha2) {
        VentaDao ven = new VentaDao();
        return ven.getSalesVendedorPeriodoVenta(id_vendedor, fecha1, fecha2);
    }

    public ArrayList<VentaVo> getSalesVendedorPeriodoTotal(int id_vendedor, String fecha1, String fecha2) {
        VentaDao ven = new VentaDao();
        return ven.getSalesVendedorPeriodoTotal(id_vendedor, fecha1, fecha2);
    }

    public ArrayList<VentaVo> getSalesGeneralDia(String fecha) {
        VentaDao ven = new VentaDao();
        return ven.getSalesGeneralDia(fecha);
    }

    public ArrayList<VentaVo> getSalesGeneralMes(int mes, int year) {
        VentaDao ven = new VentaDao();
        return ven.getSalesGeneralMes(mes, year);
    }

    public ArrayList<VentaVo> getSalesGeneralYear(int year) {
        VentaDao ven = new VentaDao();
        return ven.getSalesGeneralYear(year);
    }

    public ArrayList<VentaVo> getSalesGeneralPeriodo(String fecha1, String fecha2) {
        VentaDao ven = new VentaDao();
        return ven.getSalesGeneralPeriodo(fecha1, fecha2);
    }

    public ProductoVo getProductoCodigo(String codigo) {
        ProductoDao prt = new ProductoDao();
        return prt.getProductoCodigo(codigo);
    }

    public TallaVo getTalla(int id) {
        TallaDao tll = new TallaDao();
        return tll.getTalla(id);
    }

    public void updateSizes(ProductoVo pro) {
        ProductoDao pdao = new ProductoDao();
        pdao.UpdateSizes(pro);
    }

    public ProductoVo getCode(String code) {
        ProductoDao pdao = new ProductoDao();
        return pdao.getCode(code);
    }

    public int getSigId() {
        ProductoDao pr = new ProductoDao();
        return pr.getSigId();
    }

    public void updateCodigo(ProductoVo pro) {
        ProductoDao pr = new ProductoDao();
        pr.UpdateCodigo(pro);
    }

    public void insertCode(ProductoVo pro) {
        ProductoDao pr = new ProductoDao();
        pr.InsertCode(pro);
    }

    public int getLastCompra() {
        VentaDao vdao = new VentaDao();
        return vdao.getLastCompra() + 1;
    }

    public ArrayList<VentaVo> getSalesCreditIdOnline(int id) {
        VentaDao vd = new VentaDao();
        return vd.getSalesCreditIdOnline(id);
    }

    public void updateAbono(VentaVo abono) {
        VentaDao da = new VentaDao();
        da.UpdateAbono(abono);
    }

    public void insertAbono(VentaVo ven) {
        VentaDao vdao = new VentaDao();
        vdao.InsertAbono(ven);
    }

    public void insertAbonoApart(VentaVo ven) {
        VentaDao vdao = new VentaDao();
        vdao.InsertAbonoApart(ven);
    }

    public ArrayList<VentaVo> getAllSales() {
        VentaDao vent = new VentaDao();
        return vent.getAllSales();
    }

    public ArrayList<VentaVo> getSalesDate(String f1, String f2) {
        VentaDao vent = new VentaDao();
        return vent.getSalesDate(f1, f2);
    }

    public void InsertNota(NotaVo nota) {
        NotaDao note = new NotaDao();
        note.InsertNota(nota);
    }

    public ArrayList<NotaVo> getNotas(int usuario) {
        NotaDao ndao = new NotaDao();
        return ndao.getNotas(usuario);
    }

    public ArrayList<NotaVo> getNotasFecha(int usuario, String f1, String f2) {
        NotaDao ndao = new NotaDao();
        return ndao.getNotasFecha(usuario, f1, f2);
    }

    public void updateNota(NotaVo producto) {
        NotaDao nt = new NotaDao();
        nt.updateNota(producto);
    }

    public void insertApartado(ApartadoVo apart) {
        ApartadoDao apr = new ApartadoDao();
        apr.InsertAparatdo(apart);
    }

    public ArrayList<ApartadoVo> getProductsApartado() {
        ApartadoDao apr = new ApartadoDao();
        return apr.getProductsApartado();
    }

    public ArrayList<ApartadoVo> getApartadoFecha(String f1, String f2) {
        ApartadoDao apr = new ApartadoDao();
        return apr.getApartadoFecha(f1, f2);
    }

    public void updateApartado(ApartadoVo apart) {
        ApartadoDao apr = new ApartadoDao();
        apr.UpdateApartado(apart);
    }

    public void updateEstado(ApartadoVo apart) {
        ApartadoDao apr = new ApartadoDao();
        apr.UpdateEstado(apart);
    }

    public void updateAbon(ApartadoVo apart) {
        ApartadoDao apr = new ApartadoDao();
        apr.UpdateAbon(apart);
    }

    public ArrayList<VentaVo> getSalesCreditDate(String f1, String f2) {
        VentaDao vtn = new VentaDao();
        return vtn.getSalesCreditDate(f1, f2);
    }

    public ArrayList<VentaVo> getAbonos(int venta) {
        VentaDao vtn = new VentaDao();
        return vtn.getAbonos(venta);
    }
    
    public ArrayList<VentaVo> getAbonosApt(int venta) {
        VentaDao vtn = new VentaDao();
        return vtn.getAbonosApt(venta);
    }
}
