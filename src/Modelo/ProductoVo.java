package Modelo;

public class ProductoVo {
    private String art;
    private String art_name;
    private String color_art;
    private String color_name;
    private Integer id_type_product;
    private String type_product_name;
    private Integer id_size;
    private String size_name;
    private Double price;
    private Integer id_category;
    private String category_name;
    private Integer id_subcategory;
    private String subcategory_name;
    private String description;
    private String composition;
    private Integer amount;
    private String src1;
    private String src2;
    private String src3;
    private int id_local;
    private int id_local_destino;
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_local_destino() {
        return id_local_destino;
    }

    public void setId_local_destino(int id_local_destino) {
        this.id_local_destino = id_local_destino;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getArt_name() {
        return art_name;
    }

    public void setArt_name(String art_name) {
        this.art_name = art_name;
    }

    public String getColor_art() {
        return color_art;
    }

    public void setColor_art(String color_art) {
        this.color_art = color_art;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public Integer getId_type_product() {
        return id_type_product;
    }

    public void setId_type_product(Integer id_type_product) {
        this.id_type_product = id_type_product;
    }

    public String getType_product_name() {
        return type_product_name;
    }

    public void setType_product_name(String type_product_name) {
        this.type_product_name = type_product_name;
    }

    public Integer getId_size() {
        return id_size;
    }

    public void setId_size(Integer id_size) {
        this.id_size = id_size;
    }

    public String getSize_name() {
        return size_name;
    }

    public void setSize_name(String size_name) {
        this.size_name = size_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId_category() {
        return id_category;
    }

    public void setId_category(Integer id_category) {
        this.id_category = id_category;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Integer getId_subcategory() {
        return id_subcategory;
    }

    public void setId_subcategory(Integer id_subcategory) {
        this.id_subcategory = id_subcategory;
    }

    public String getSubcategory_name() {
        return subcategory_name;
    }

    public void setSubcategory_name(String subcategory_name) {
        this.subcategory_name = subcategory_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSrc1() {
        return src1;
    }

    public void setSrc1(String src1) {
        this.src1 = src1;
    }

    public String getSrc2() {
        return src2;
    }

    public void setSrc2(String src2) {
        this.src2 = src2;
    }

    public String getSrc3() {
        return src3;
    }

    public void setSrc3(String src3) {
        this.src3 = src3;
    }
    
}
